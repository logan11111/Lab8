package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;

    /**
     * create a mocklist for my citylist
     * @return
     */
    public CustomList MockCityList(){
    list =  new CustomList(null,new ArrayList<>());
    return list;
}


    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SM"));
        assertEquals(list.getCount(),listSize + 1);

    }
    @Test
    void testHasCity(){
        list = MockCityList();
        City city = new City("Estevan", "SM");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        City city2 = new City("Medicine Hat", "Alberta");
        assertEquals(false, list.hasCity(city2));
    }

    @Test
    void testDelete(){
        list = MockCityList();
        City city = new City("Red Deer", "Alberta");
        list.addCity(city);
        assertEquals(true, list.hasCity(city));
        list.delete(city);
        assertEquals(false, list.hasCity(city));
        assertThrows(IllegalArgumentException.class, () -> list.delete(city));
    }
}

