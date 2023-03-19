package org.example;
import java.util.List;

public interface CityDAO {
    void createCity(City city);

    City getCityById(Integer id);

    List<City> getAllCites();

    void updateCity(City city);

    void deleteCity(City city);
}