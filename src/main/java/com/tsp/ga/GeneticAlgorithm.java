package com.tsp.ga;

import java.util.ArrayList;

/**
 * Created by sarja on 8/19/2016.
 */
public class GeneticAlgorithm {

    public static final double MUTATION_RATE = 0.25;
    public static final double TOURNAMENT_SELECTION_SIZE = 3; // USED IN CHROMOSOME CROSSOVER SELECTION OR ROUTE CROSSOVER SELECTION
    public static final int POPULATION_SIZE = 8; // number of routes in a generation

    private ArrayList<City> initialRoute = null;

    public GeneticAlgorithm(ArrayList<City> initialRoute) {
        this.initialRoute = initialRoute;
    }

    public ArrayList<City> getInitialRoute() {
        return initialRoute;
    }
}
