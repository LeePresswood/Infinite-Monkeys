package com.leepresswood

class Breeder {
    private static final Integer POPULATION_GENERATION_SIZE = 100
    
    public static List<Text> generateInitialPopulation(Text original){
        List<Text> population = []
        POPULATION_GENERATION_SIZE.times{ population << new Text(original.length, original) }
        population
    }
    
    public static List<Text> getNewPopulationMembersFromOld(List<Text> population){

    }
}
