package com.leepresswood.util

class RandomStringUtils{
    private static List alphabet = ('a'..'z') + ('A'..'Z') + ' ' + ',' + '.' + '!' + '?' + '"' + '\'' + '$' + '%'
    private static Random random = new Random()
    
    public static String getRandomString(int length){
        (1..length).collect({ getRandomChar() }).join("")
    }
    
    public static char getRandomChar(){
        alphabet[random.nextInt(alphabet.size())]
    }
}
