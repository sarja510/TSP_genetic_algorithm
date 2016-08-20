package com.tsp.ga;

import java.util.ArrayList;
import java.util.Map;
import java.util.stream.IntStream;

/**
 * Created by sarja on 8/19/2016.
 */
public class GeneticAlgorithm {

    public static final double MUTATION_RATE = 0.25;
    public static final int TOURNAMENT_SELECTION_SIZE = 3; // USED IN CHROMOSOME CROSSOVER SELECTION OR ROUTE CROSSOVER SELECTION
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

         population.getRoutes().stream().filter(x -> population.getRoutes().indexOf(x) >= NUMB_OF_ELITE_ROUTES).forEach(x -> mutateRoute(x));

        return  population;
    }



    // crossoverRoute method details -
    //an example of route1 and route2
    //route1 = [New york, San francisco, Houston, Chicago, Boston, Austin, Seattle, Denvec, Dallas, Los Angeles]
    //route2 = [Los Angeles,Seattle,Austin,Boston,Denvec,New york,Houston,Dallas,San francisco,Chicago]
    //intermidiate_crossover_route = [New york, San francisco, Houston, Chicago, Boston, null,null,null,null,null]
    //finatl_crossover_route = [New york, San francisco, Houston, Chicago, Boston,Los Angeles, Seattle, Austin,Denvec,Dallas]

    Route crossoverRoute(Route route1, Route route2){

        return null;

    }

    // fillNullsInCrossoverRoute method details -
    //crossoverRoute = [New york, San francisco, Houston, Chicago, Boston, null,null,null,null,null]
    //route = [Los Angeles,Seattle,Austin,Boston,Denvec,New york,Houston,Dallas,San francisco,Chicago]
    //crossoverRoure = [New york, San francisco, Houston, Chicago, Boston,Los Angeles, Seattle, Austin,Denvec,Dallas]

    private Route fillNullsInCrossoverRoute(Route crossoverRoute, Route route){

        route.getCities().stream().filter(x -> !crossoverRoute.getCities().contains(x)).forEach(cityX ->{
            for(int y = 0; y < route.getCities().size(); y++){
                if(crossoverRoute.getCities().get(y) == null){
                    crossoverRoute.getCities().set(y, cityX);
                    break;
                }
            }
        });


        return crossoverRoute;
    }


    // mutatePopulation method details -
    //original route: [Boston, Denver,  Los angeles, Austin , New york ,Seattle, Chicago, San Francisco, Dallas , Houston]]
    //mutated route: [Boston, Denver,  New york , Austin , Los angeles , Seattle, San Francisco, Chicago, Dallas , Houston]]

    Route mutateRoute (Route route){

        route.getCities().stream().filter(x -> Math.random() < MUTATION_RATE).forEach(cityX -> {
            int y = (int) (route.getCities().size() * Math.random());
            City cityY = route.getCities().get(y);
            route.getCities().set(route.getCities().indexOf(cityX),cityY);
            route.getCities().set(y, cityX);


        });

        return route;
    }


    Population selectTournamentPopulation(Population population){

        Population tournamentPopulation = new Population(TOURNAMENT_SELECTION_SIZE,this);
        IntStream.range(0, TOURNAMENT_SELECTION_SIZE).forEach(x -> tournamentPopulation.getRoutes().set(
                x, population.getRoutes().get((int) (Math.random() * population.getRoutes().size()))));
        tournamentPopulation.sortRoutesByFitness();

        return tournamentPopulation;
    }
}
