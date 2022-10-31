package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

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
     * add content to our list
     * @return Null
     */
    @Test
    public void addCityTest(){
        list = MockCityList();
        list.add(new City("Edmonton", "AB"));
    }
}
