package org.example;


import java.util.Objects;

public class City {
    private String cityName;
    private Integer cityId;

    public City(String cityName, Integer cityId) {
        this.cityName = cityName;
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName) && Objects.equals(cityId, city.cityId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cityName, cityId);
    }

    @Override
    public String toString() {
        return "City " + cityName + " cityId " + cityId;
    }
}