package com.tsp.ga;

import java.util.ArrayList;

/**
 * Created by sarja on 8/19/2016.
 */
public class Population {

    private ArrayList<Route> routes = new ArrayList<Route>(GeneticAlgorithm.POPULATION_SIZE);

    public ArrayList<Route> getRoutes() {
        return routes;
    }

}
