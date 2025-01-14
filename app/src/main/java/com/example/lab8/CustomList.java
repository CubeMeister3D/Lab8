package com.example.lab8;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class CustomList extends ArrayAdapter<City> {

    private ArrayList<City> cities;
    private Context context;

    public CustomList(Context context, ArrayList<City> cities) {
        super(context, 0, cities);
        this.cities = cities;
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = convertView;

        if(view == null){
            view = LayoutInflater.from(context).inflate(R.layout.content, parent,false);
        }

        City city = cities.get(position);

        TextView cityName = view.findViewById(R.id.city_text);
        TextView provinceName = view.findViewById(R.id.province_text);

        cityName.setText(city.getCityName());
        provinceName.setText(city.getProvinceName());

        return view;

    }
    /**
     *
     * @return cityCount
     *  returns the number of cities that are in the list.
     */
    public int cityCount(){
       return cities.size();
    }
    public int getCount(){
        return cities.size();
    }

    /**
     * this adds a city object to the list *for the first phase it will be empty
     *
     * @param city
     */
    public void addCity(City city){
        cities.add(city);
    }

    /**
     *
     * @param city
     *  this is the city that we are testing to see if it is in the list
     * @return
     *  returns true if the city is in the list and false if it is not
     */
    public boolean hasCity(City city){
        for(int i = 0; i < cities.size();i++){
            if(cities.get(i).equals(city)){
                return true;
            }
        }
        return false;
    }

    /**
     *
     * @param city
     *  this is the city that we are trying to remove from the list
     * @throws IllegalArgumentException
     *  throws an error if the city that we are trying to remove from the list is not actually in the list
     */
    public void deleteCity(City city){
        if (!this.hasCity(city)){
            throw new IllegalArgumentException();
        }
        int i;
        for(i = 0; i < cities.size();i++){
            if(cities.get(i).equals(city)){break;}
        }
        cities.remove(i);
    }

}
