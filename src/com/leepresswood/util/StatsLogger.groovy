package com.leepresswood.util

import com.leepresswood.population.Text
import com.leepresswood.populationcontrol.Breeder

class StatsLogger{
    private int attempts
    private List minList = []
    private List maxList = []
    private List averageList = []
    
    public void getCurrentGenerationStats(Text original, List<Text> population){
        int maxPossible = original.text.size()
        int min = population.min({ it.compareToOriginalAndScore() }).compareToOriginalAndScore()
        int max = population.max({ it.compareToOriginalAndScore() }).compareToOriginalAndScore()
        double average = population.sum({ it.compareToOriginalAndScore() }) / (double) Breeder.POPULATION_GENERATION_SIZE
        Text closest = population.sort({ it.compareToOriginalAndScore() }).reverse()[0]
        
        println "\nAttempt number $attempts.\nMin: $min\nMax: $max\nMax Possible: $maxPossible\nAverage: ${average.round(3)}\nOriginal: ${original.text}\nClosest: ${closest.text}"
    
        minList << min
        maxList << max
        averageList << average
        
        attempts++
    }
    
    public void printFinalStats(){
        double minRate = minList.sum({ it }) / (double) minList.size()
        double maxRate = maxList.sum({ it }) / (double) maxList.size()
        double averageRate = averageList.sum({ it }) / (double) averageList.size()
    
        println "\n===============================\nMatch Found!\n"
        println "Text match found after $attempts attempt(s)."
        println "Min rate of change: ${minRate.round(3)}"
        println "Max rate of change: ${maxRate.round(3)}"
        println "Average rate of change: ${averageRate.round(3)}"
    }
}
