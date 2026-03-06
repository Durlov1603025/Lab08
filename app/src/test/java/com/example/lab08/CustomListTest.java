package com.example.lab08;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;

public class CustomListTest {
    private CustomList list;
    private City city1;
    private City city2;

    @BeforeEach
    public void setUp() {
        list = new CustomList();
        city1 = new City("Edmonton", "AB");
        city2 = new City("Calgary", "AB");
    }

    // ========== TEST ADD CITY ==========
    @Test
    public void testAddCity() {
        // Check list starts empty
        assertEquals(0, list.countCities());

        // Add a city
        list.addCity(city1);

        // Verify city was added
        assertEquals(1, list.countCities());
        assertTrue(list.hasCity(city1));
    }

    // ========== TEST HAS CITY ==========
    @Test
    public void testHasCity() {
        // Initially should not have any city
        assertFalse(list.hasCity(city1));

        // Add a city
        list.addCity(city1);

        // Should have the city now
        assertTrue(list.hasCity(city1));
        assertFalse(list.hasCity(city2));
    }

    // ========== TEST DELETE CITY ==========
    @Test
    public void testDeleteCity() {
        // Add cities
        list.addCity(city1);
        list.addCity(city2);
        assertEquals(2, list.countCities());

        // Delete one city
        list.deleteCity(city1);

        // Verify deletion
        assertEquals(1, list.countCities());
        assertFalse(list.hasCity(city1));
        assertTrue(list.hasCity(city2));
    }

    @Test
    public void testDeleteNonExistentCity() {
        // Add one city
        list.addCity(city1);
        assertEquals(1, list.countCities());

        // Try to delete a city that doesn't exist
        list.deleteCity(city2);  // Should not throw exception

        // Verify nothing changed
        assertEquals(1, list.countCities());
        assertTrue(list.hasCity(city1));
    }

    // ========== TEST COUNT CITIES ==========
    @Test
    public void testCountCities() {
        // Test empty list
        assertEquals(0, list.countCities());

        // Add one city
        list.addCity(city1);
        assertEquals(1, list.countCities());

        // Add another city
        list.addCity(city2);
        assertEquals(2, list.countCities());

        // Delete a city
        list.deleteCity(city1);
        assertEquals(1, list.countCities());
    }

    @Test
    public void testCountCitiesWithMultipleOperations() {
        assertEquals(0, list.countCities());

        list.addCity(city1);
        assertEquals(1, list.countCities());

        list.addCity(city2);
        assertEquals(2, list.countCities());

        list.addCity(city1);  // Add duplicate
        assertEquals(3, list.countCities());

        list.deleteCity(city1);
        assertEquals(2, list.countCities());
    }
}