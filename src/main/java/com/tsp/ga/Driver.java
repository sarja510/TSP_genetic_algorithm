package com.tsp.ga;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by sarja on 8/19/2016.
 */
public class Driver {


    public ArrayList<City> initialRoute = new ArrayList<City>(Arrays.asList(

            new City("Boston", 42.3601, -71.0589),
            new City("Houston", 29.7604, -95.3698),
            new City("Austin", 30.2672, -97.7431),
            new City("San Francisco", 37.7749, -122.4194),
            new City("Denver", 39.7392, -104.9903),
            new City("Los Angeles", 34.0522, -118.2437),
            new City("Chicago", 41.8781, -87.6298),
            new City("New York", 40.7128, -74.0059),
            new City("Dallas", 32.7767, -96.7970),
            new City("Seattle", 47.6062, -122.3321)


    ));


    public static void main(String[] args) {

        Driver driver = new Driver();
        Population population = new Population(GeneticAlgorithm.POPULATION_SIZE, driver.initialRoute);
        population.sortRoutesByFitness();
        driver.printPopulaiton(population);


    }


    public  void printPopulaiton(Population population){
        population.getRoutes().forEach(x -> {

            System.out.println(Arrays.toString(x.getCities().toArray()) + " | " +
            String.format("%.4f", x.getFitness()) +" | "+ String.format("%.2f", x.calculateTotalDistance()));
        });
        System.out.println("");
    }
}
