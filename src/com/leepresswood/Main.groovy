package com.leepresswood

import com.leepresswood.population.Text
import com.leepresswood.populationcontrol.Breeder
import com.leepresswood.populationcontrol.Killer

class Main{
    public static void main(String[] args){
        Text original = getTextFromFile("resources/word.txt")
        List<Text> population = Breeder.generateInitialPopulation(original)
        int attempts = 0
        
        while(!matchHasBeenFound(population, original)){
            getCurrentGenerationStats(original, population, attempts)
            replaceWeakMembersWithNextGeneration(population)
            attempts++
        }
        
        println "Text match found after $attempts attempt(s)."
    }
    
    private static Text getTextFromFile(String fileName){
        File file = new File(fileName)
        String fileText = file.text
        Text.createOriginalTextInstance(fileText)
    }
    
    private static boolean matchHasBeenFound(List<Text> population, Text original){
        population.any{ it.compareToOriginalAndScore() == original.text.size() }
    }
    
    private static void getCurrentGenerationStats(Text original, List<Text> population, int attempts){
        int populationSize = population.size()
        int maxPossible = original.text.size()
        int min = population.min({ it.compareToOriginalAndScore() }).compareToOriginalAndScore()
        int max = population.max({ it.compareToOriginalAndScore() }).compareToOriginalAndScore()
        double average = population.sum({ it.compareToOriginalAndScore() }) / (double) populationSize
        Text closest = population.sort({ it.compareToOriginalAndScore() }).reverse()[0]
        
        println "\nAttempt number $attempts.\nMin: $min\nMax: $max\nMax Possible: $maxPossible\nAverage: ${average.round(3)}\nOriginal: ${original.text}\nClosest: ${closest.text}"
    }
    
    private static void replaceWeakMembersWithNextGeneration(List<Text> population){
        Killer.killWeakestMembers(population)
        List<Text> newPopulationMembers = Breeder.getNewPopulationMembersFromOld(population)
        population.addAll(newPopulationMembers)
    }
}
