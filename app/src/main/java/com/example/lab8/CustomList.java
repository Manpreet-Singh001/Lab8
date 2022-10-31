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

    public int getCount(){
        return cities.size();
    }

    /**
     * add city {@link City} to cities {@link CustomList#cities}
     * @param city {@link City} to add
     */
    public void addCity(City city){
        this.cities.add(city);
    }

    /**
     *
     * @param city
     * @return true if cities {@link CustomList#cities} has city {@link City}
     *         false if cities {@link CustomList#cities} does not have city {@link City}
     */
    public boolean hasCity(City city){
        return cities.contains(city);
    }

    /**
     * check if city{@link City} is in cities {@link CustomList#cities}
     * if city exists in cities, delete it.
     * @throws IllegalArgumentException if city is not contained in the cities
     * @param city {@link City}
     */
    public void deleteCity(City city){

    }

}
