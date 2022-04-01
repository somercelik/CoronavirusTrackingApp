package com.somercelik.coronavirustracking.controller;

import com.somercelik.coronavirustracking.model.LocationStat;
import com.somercelik.coronavirustracking.service.DataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * HomeController
 *
 * @author s84240320
 * @since 2022-04-01
 */
@Controller
public class HomeController {

    @Autowired
    DataService dataService;

    @GetMapping("/")
    public String home(Model model) {
        List<LocationStat> allStats = dataService.getAllStats();
        int totalCases = allStats.stream().mapToInt(LocationStat::getLatestTotalCases).sum();
        model.addAttribute("locationStats", allStats);
        model.addAttribute("totalReportedCases", totalCases);
        return "home";
    }
}
