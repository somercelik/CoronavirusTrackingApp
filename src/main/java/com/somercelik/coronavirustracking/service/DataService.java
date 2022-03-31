package com.somercelik.coronavirustracking.service;

import com.somercelik.coronavirustracking.model.LocationStat;
import com.somercelik.coronavirustracking.utils.Utils;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * CoronavirusDataService
 *
 * @author s84240320
 * @since 2022-03-31
 */
// Being called after application initialization
@Service
public class DataService {


    private static final String COVID_API_URL = "https://raw.githubusercontent.com/CSSEGISandData/COVID-19/master/csse_covid_19_data/csse_covid_19_time_series/time_series_covid19_confirmed_global.csv";

    private List<LocationStat> allStats;
    // Being called right after class initialization
    @PostConstruct
    // Second - Minute - Hour - Day - Month - Year
    @Scheduled(cron = "* * 1 * * *")
    public HttpResponse<String> fetchCovidData() throws IOException, InterruptedException {
        allStats = new ArrayList<>();
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(COVID_API_URL))
                .build();

        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
        String[][] rows = Utils.readCsvFile(response.body(), true, ",");
        allStats = parseCsvData(rows);
        return response;
    }
    private List<LocationStat> parseCsvData(String[][] rows){
        List<LocationStat> locationStats = new ArrayList<>();
        for (String[] row : rows) {
            locationStats.add(new LocationStat(
                    row[1],
                    row[0],
                    Integer.valueOf(row[rows.length - 1])
            ));
        }
        return locationStats;
    }

    public List<LocationStat> getAllStats() {
        return allStats;
    }
}
