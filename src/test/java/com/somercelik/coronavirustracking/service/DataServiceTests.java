package com.somercelik.coronavirustracking.service;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.net.http.HttpResponse;

@SpringBootTest
class DataServiceTests {
    static DataService service;
    static HttpResponse<String> response;

    @Autowired
    DataService dataService;

    @BeforeAll
    static void setup() throws IOException, InterruptedException {
        service = new DataService();
        response = service.fetchCovidData();
    }

    @Test
    void successfulResponseFromGitHub(){
        Assertions.assertEquals(200, response.statusCode());
    }

}
