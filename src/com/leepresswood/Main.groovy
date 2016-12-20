package com.leepresswood

class Main {
    public static void main(String[] args) {
        //First, get text to match against.
        Text text = getTextFromFile("resources/word.txt")
        int textLength = text.text.size()

        //Next, create a population of randomly generated elements.
        int populationSize = 100
        Text[] population = []
        populationSize.times { population << new Text(textLength)}

        //Determine if any of these elements match the matched text.
        int attempts = 0
        if(population.any { it.getFitnessScore(text) == textLength}){
            println "Text match found after $attempts attempt(s)."
        }

    }

    private static Text getTextFromFile(String fileName) {
        new Text(new File(fileName).text)
    }
}
