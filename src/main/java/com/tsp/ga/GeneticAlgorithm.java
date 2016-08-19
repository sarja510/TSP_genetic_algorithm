package com.tsp.ga;

import java.util.ArrayList;
import java.util.stream.IntStream;

/**
 * Created by sarja on 8/19/2016.
 */
public class GeneticAlgorithm {

    public static final double MUTATION_RATE = 0.25;
    public static final double TOURNAMENT_SELECTION_SIZE = 3; // USED IN CHROMOSOME CROSSOVER SELECTION OR ROUTE CROSSOVER SELECTION
    public static final int POPULATION_SIZE = 8; // number of routes in a generation
    public static final int NUMB_OF_ELITE_ROUTES = 1;
    public static final int NUMB_OF_GENERATIONS = 30;

    private ArrayList<City> initialRoute = null;

    public GeneticAlgorithm(ArrayList<City> initialRoute) {
        this.initialRoute = initialRoute;
    }

    public ArrayList<City> getInitialRoute() {
        return initialRoute;
    }


    public Population evolve(Population population){          // apply crossover and mutation to the passed in population

        return mutatePopulation(crossoverPopulation(population));
    }

    Population crossoverPopulation(Population population){

        Population crossoverPopulation = new Population(population.getRoutes().size(), this);
        IntStream.range(0, NUMB_OF_ELITE_ROUTES).forEach(x -> crossoverPopulation.getRoutes().set(x, population.getRoutes().get(x)));
        IntStream.range(NUMB_OF_ELITE_ROUTES, crossoverPopulation.getRoutes().size()).forEach(x ->{
            Route route1 = selectTournamentPopulation(population).getRoutes().get(0);
            Route route2 = selectTournamentPopulation(population).getRoutes().get(0);
            crossoverPopulation.getRoutes().set(x, crossoverRoute(route1, route2));
        });
        return crossoverPopulation;
    }

    Population mutatePopulation(Population population){

        return  null;
    }

    Route mutateRoute (Route route){

        return null;
    }

    Route crossoverRoute(Route route1, Route route2){

        return null;

    }

    Population selectTournamentPopulation(Population population){

        return null;
    }
}
