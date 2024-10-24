package com.example.lab8;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


//import org.junit.Before;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class CustomListTest {
    private CustomList list;
    /**
     *create a mocklist for my citylist
     *
     * @return
     */
    public CustomList MockCityList(){
        list = new CustomList(null,new ArrayList<>());
        return list;
    }

    /**
     * get the size of the list
     * increase the list by adding a new city
     * check if our current size matches the initial size
     plus one */
    @Test
    public void addCityTest(){
        list = MockCityList();
        int listSize = list.getCount();
        list.addCity(new City("Estevan", "SK"));
        assertEquals(list.getCount(),listSize + 1);
    }

    @Test
    void testHasCity(){
        list = MockCityList();
        //test to see if the hasCity() works
        list.addCity(new City("edmonton","AB"));
        assertTrue(list.hasCity(new City("edmonton","AB")));
    }

    @Test
    void testDeleteCity(){
        list = MockCityList();
        list.addCity(new City("edmonton","AB"));
        list.addCity(new City("Charlottetown", "Prince Edward Island"));
        assertEquals(2,list.getCount());
        //test to see if we can delete mockCity() form city list
        list.deleteCity(new City("edmonton","AB"));
        assertEquals(1,list.getCount());
        //make sure that mockCity() is no longer in the list
        assertFalse(list.hasCity(new City("edmonton","AB")));
        list.deleteCity(new City("Charlottetown", "Prince Edward Island"));
        //remove the last item from the list
        assertEquals(0,list.getCount());
    }

}
