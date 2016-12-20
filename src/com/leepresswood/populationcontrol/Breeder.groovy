package com.leepresswood.populationcontrol

import com.leepresswood.population.Text

class Breeder {
    private static final Integer POPULATION_GENERATION_SIZE = 100
    private static final int POPULATION_DIVISOR = 10
    
    public static List<Text> generateInitialPopulation(Text original){
        List<Text> population = []
        POPULATION_GENERATION_SIZE.times{ population << new Text(original.length, original) }
        population
    }
    
    public static List<Text> getNewPopulationMembersFromOld(List<Text> population){
        int subpopulationSize = population.size() / POPULATION_DIVISOR
        List<Text> newPopulationMembers = []
        subpopulationSize.times({
            List<Text> subpopulation = getSubpopulation(population)
            Tuple2 parents = selectTwoMembers(subpopulation)
            newPopulationMembers << new Text(parents)
        })
        
        newPopulationMembers
    }
    
    private static List<Text> getSubpopulation(List<Text> population){
        int subpopulationSize = population.size() / POPULATION_DIVISOR
        Random random = new Random()
    
//        subpopulation.get
        
        List<Text> subpopulation = []
        //        subpopulationSize.times {subpopulation << }
    }
    
    private static Tuple2 selectTwoMembers(List<Text> subpopulation){
        Text parent1
        Text parent2
        
        subpopulation = subpopulation.sort({ it.compareToOriginalAndScore() }).reverse()
        parent1 = subpopulation[0]
        parent2 = subpopulation[1]
        
        new Tuple2(parent1, parent2)
    }
}
