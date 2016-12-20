package com.leepresswood

class Main {
    public static void main(String[] args) {
        Text original = getTextFromFile("resources/word.txt")
        int textLength = original.text.size()
        Text[] population = generatePopulation(textLength)
        int attempts = loopUntilMatchIsFound(population, original, textLength)

        println "Text match found after $attempts attempt(s)."
    }



    private static Text getTextFromFile(String fileName) {
        new Text(new File(fileName).text)
    }

    private static Text[] generatePopulation(int textLength) {
        Text[] population = []
        100.times { population << new Text(textLength) }
        population
    }

    private static int loopUntilMatchIsFound(Text[] population, Text original, int textLength) {
        int attempts = 0

        while (!matchHasBeenFound(population, original, textLength)) {


            attempts++
        }
        attempts
    }

    private static boolean matchHasBeenFound(Text[] population, Text text, int textLength) {
        population.any { it.getFitnessScore(text) == textLength }
    }
}
