package com.example.lab8;

public class City implements Comparable {

    private String city;
    private String province;

    public City(String city, String province){
        this.city = city;
        this.province = province;
    }

    String getCityName(){
        return this.city;
    }

    String getProvinceName(){
        return this.province;
    }

    /**
     *
     * @param o
     *  this is the city object that is supposed to be compared
     * @return
     *  returns the city comparison
     */
    @Override
    public int compareTo(Object o) {
        City city = (City) o;
        return this.city.compareTo(city.getCityName());
    }

    /**
     *
     * @param o
     *  o is the city that we are trying to test to see if it is equal to our city in thew class
     * @return
     *  returns true if the cityNames and provinceNames are the same and false if wither are different.
     */
    @Override
    public boolean equals(Object o){
        City city = (City) o;
        return (this.city.equals(city.getCityName()) && this.province.equals(city.getProvinceName()));
    }
}
