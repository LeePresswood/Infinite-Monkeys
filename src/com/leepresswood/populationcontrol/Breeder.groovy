package com.leepresswood.populationcontrol

import com.leepresswood.Text

class Breeder {
    private static final Integer POPULATION_GENERATION_SIZE = 100
    private static final int POPULATION_DIVISOR = 10
    
    public static List<Text> generateInitialPopulation(Text original){
        List<Text> population = []
        POPULATION_GENERATION_SIZE.times{ population << new Text(original.length, original) }
        population
    }
    
    public static List<Text> getNewPopulationMembersFromOld(List<Text> population){

    }
    
    public static List<Text> getSubpopulation(List<Text> population){
        int subpopulationSize = population.size() / POPULATION_DIVISOR
        List<Text> subpopulation = []
        //        subpopulationSize.times {subpopulation << }
    }
}
