package com.somercelik.coronavirustracking.model;

import java.util.Objects;

/**
 * LocationStats
 *
 * @author s84240320
 * @since 2022-03-31
 */
public class LocationStat {
    private String country;
    private String state;
    private Integer latestTotalCases;

    public LocationStat() {
        this.country = null;
        this.state = null;
        this.latestTotalCases = null;
    }

    public LocationStat(String country, String state, Integer latestTotalCases) {
        this.country = country;
        this.state = state;
        this.latestTotalCases = latestTotalCases;
    }

    public LocationStat(LocationStat source) {
        this.country = source.country;
        this.state = source.state;
        this.latestTotalCases = source.latestTotalCases;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass().equals(LocationStat.class)){
            LocationStat stat = (LocationStat) obj;
            return Objects.equals(stat.getCountry(), this.getCountry())
                    && Objects.equals(stat.getState(), this.getState())
                    && Objects.equals(stat.getLatestTotalCases(), this.getLatestTotalCases());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, state, latestTotalCases);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public Integer getLatestTotalCases() {
        return latestTotalCases;
    }

    public void setLatestTotalCases(Integer latestTotalCases) {
        this.latestTotalCases = latestTotalCases;
    }

    @Override
    public String toString() {
        return "LocationStat{" +
                "country='" + country + '\'' +
                ", state='" + state + '\'' +
                ", latestTotalCases=" + latestTotalCases +
                '}';
    }
}
