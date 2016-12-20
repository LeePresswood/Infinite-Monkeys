package com.leepresswood

class Main{
    public static void main(String[] args){
        Text original = getTextFromFile("resources/word.txt")
        int attempts = loopUntilMatchIsFound(original)
        
        println "Text match found after $attempts attempt(s)."
    }
    
    private static Text getTextFromFile(String fileName){
        File file = new File(fileName)
        String fileText = file.text
        new Text(fileText)
    }
    
    private static int loopUntilMatchIsFound(Text original){
        List<Text> population = Breeder.generateInitialPopulation(original)
        int attempts = 0
        
        while(!matchHasBeenFound(population, original)){
            List<Text> newPopulationMembers = Breeder.getNewPopulationMembersFromOld(population)
            Killer.killWeakestMembers(population)
            population.addAll(newPopulationMembers)
    
            attempts++
        }
        attempts
    }
    
    private static boolean matchHasBeenFound(List<Text> population, Text original){
        population.any{ it.compareToOriginalAndScore() == original.length }
    }
}
