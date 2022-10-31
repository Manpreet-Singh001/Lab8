package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    private City city;

    /**
     * create a mock CustomList
     *
     * @return list
     */
    public CustomList MockCityList() {
        list = new CustomList(null, new ArrayList<>());
        return list;
    }

    /**
     * create a mock city
     *
     * @return City
     */
    public City MockCity() {
        city = new City("Edmonton", "AB");
        return city;
    }


    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size plus one
     */
    @Test
    public void addCityTest() {
        list = MockCityList();
        int intialSize = list.getCount();
        list.addCity(new City("Edmonton", "AB"));
        assertEquals(list.getCount(), intialSize + 1);
    }

    /**
     * check if list.hasCity(mockCity) returns false
     * add a mockCity to the list
     * check if list.hasCity(mockCity) returns true
     */
    @Test
    public void hasCityTest() {
        list = MockCityList();
        city = MockCity();
        assertFalse(list.hasCity(city));    // check for mockCity
        list.addCity(city);
        assertTrue(list.hasCity(city));     // check for mockCity

    }

    /**
     * add mockCity to the list
     * check if list.has(mockCity) returns true
     * delete mockCity from the list
     * check if list.has(mockCity) returns false
     */
    @Test
    public void deleteCityTest() {
        list = MockCityList();
        city = MockCity();
        list.addCity(city);
        assertTrue(list.hasCity(city));
        list.deleteCity(city);
        assertFalse(list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () ->
        {
            list.deleteCity(city);
        });
    }

    /**
     * check to see if CustomList.countCities() returns
     * correct number of cities
     */
    @Test
    public void countCitiesTest(){
        list = MockCityList();
        assertEquals(0, list.countCities());
        city = MockCity();
        list.addCity(city);
        assertEquals(1, list.countCities());
        list.addCity(new City("Calgary", "AB"));
        assertEquals(2, list.countCities());
        list.deleteCity(city);
        assertEquals(1, list.countCities());
    }

}
