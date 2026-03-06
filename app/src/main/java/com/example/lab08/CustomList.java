package com.example.lab08;

import java.util.ArrayList;

public class CustomList {
    private ArrayList<City> cities;

    public CustomList() {
        cities = new ArrayList<>();
    }

    /**
     * Add a city to the list
     * @param city The city to add
     */
    public void addCity(City city) {
        cities.add(city);
    }

    /**
     * Check if a city exists in the list
     * @param city The city to check
     * @return true if the city exists, false otherwise
     */
   public boolean hasCity(City city) {
        return cities.contains(city);
    }


    /**
     * Delete a city from the list
     * @param city The city to delete
     */
    public void deleteCity(City city) {
        if (cities.contains(city)) {
            cities.remove(city);
        }
    }

    /**
     * Count the number of cities in the list
     * @return The number of cities
     */
    public int countCities() {
        return cities.size();
    }
}
