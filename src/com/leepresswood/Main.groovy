package com.leepresswood

import com.leepresswood.population.Text
import com.leepresswood.populationcontrol.Breeder
import com.leepresswood.populationcontrol.Killer
import com.leepresswood.util.StatsLogger

class Main{
    public static void main(String[] args){
        Text original = getTextFromFile("resources/word.txt")
        List<Text> population = Breeder.generateInitialPopulation(original)
        StatsLogger logger = new StatsLogger()
        
        while(!matchHasBeenFound(population, original)){
            logger.getCurrentGenerationStats(original, population)
            replaceWeakMembersWithNextGeneration(population)
        }
    
        logger.printFinalStats(original, population)
    }
    
    private static Text getTextFromFile(String fileName){
        File file = new File(fileName)
        String fileText = file.text
        Text.createOriginalTextInstance(fileText)
    }
    
    private static boolean matchHasBeenFound(List<Text> population, Text original){
        population.any{ it.compareToOriginalAndScore() == original.text.size() }
    }
    
    private static void replaceWeakMembersWithNextGeneration(List<Text> population){
        Killer.killWeakestMembers(population)
        List<Text> newPopulationMembers = Breeder.getNewPopulationMembersFromOld(population)
        population.addAll(newPopulationMembers)
    }
}
