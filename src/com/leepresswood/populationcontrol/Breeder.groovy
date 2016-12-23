package com.leepresswood.populationcontrol

import com.leepresswood.population.Text
import com.leepresswood.util.RandomStringUtils

class Breeder{
    private static final Random random = new Random()
    private static final float MUTATION_CHANCE = 1.0f
    private static final int POPULATION_GENERATION_SIZE = 100
    private static final int POPULATION_DIVISOR = 10
    
    public static List<Text> generateInitialPopulation(Text original){
        List<Text> population = []
        POPULATION_GENERATION_SIZE.times{ population << new Text(original) }
        population
    }
    
    public static String breedTwoStrings(String s1, String s2){
        int charactersToBreed = s1.chars.length
        float percentParent2 = 100f - MUTATION_CHANCE
        float percentParent1 = percentParent2 / 2f;
        
        String newString = ""
        charactersToBreed.times{
            float roll = random.nextFloat()
            if(roll < percentParent1){
                newString << s1.charAt(it)
            }
            else if(roll < percentParent2){
                newString << s2.charAt(it)
            }
            else{
                newString << RandomStringUtils.getRandomChar()
            }
        }
    }
    
    public static List<Text> getNewPopulationMembersFromOld(List<Text> population){
        List<Text> newPopulationMembers = []
        getSubpopulationSize(population).times({
            List<Text> subpopulation = getSubpopulation(population)
            Tuple2 parents = selectTwoMembers(subpopulation)
            newPopulationMembers << new Text(parents)
        })
        
        newPopulationMembers
    }
    
    private static List<Text> getSubpopulation(List<Text> population){
        List<Integer> selected = []
        List<Text> subpopulation = []
        Random random = new Random()
        
        getSubpopulationSize(population).times({
            int index = random.nextInt(properties.size())
            while(index in selected){
                index = random.nextInt(properties.size())
            }
            
            selected << index
            subpopulation << population[index]
        })
    }
    
    private static Tuple2 selectTwoMembers(List<Text> subpopulation){
        Text parent1
        Text parent2
        
        subpopulation = subpopulation.sort({ it.compareToOriginalAndScore() }).reverse()
        parent1 = subpopulation[0]
        parent2 = subpopulation[1]
        
        new Tuple2(parent1, parent2)
    }
    
    private static BigDecimal getSubpopulationSize(List<Text> population){
        population.size() / POPULATION_DIVISOR
    }
}
