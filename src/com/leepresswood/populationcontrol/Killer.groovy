package com.leepresswood.populationcontrol

import com.leepresswood.population.Text

class Killer{
    private static final int POPULATION_DIVISOR = 10
    
    public static void killWeakestMembers(List<Text> population){
        int numberToKill = population.size() / POPULATION_DIVISOR
        population = population.sort({ Text member -> member.compareToOriginalAndScore() }).reverse()
        numberToKill.times({ population.pop() })
    }
}
