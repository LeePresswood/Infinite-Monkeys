package com.leepresswood.population

class Text {
    private String text
    private Text original

    public Text(String text){
        this.text = text
    }

    public Text(int length, Text original){
        this.original = original
    }
    
    public Text(Tuple2 parents){
        
    }
    
    private String getRandomString(){
        Random random = new Random()
        def alphabet = ('a'..'z') + ('A'..'Z') + ' ' + ',' + '.' + '!' + '?' + '"' + '\'' + '$' + '%'
        
        (1..original.length).collect({ random.nextInt(alphabet.size() )}).join("")
    }
    
    public int getLength(){
        text.size()
    }

    public int compareToOriginalAndScore(){
        int count = 0
        for(int index = 0; index < original.text.size(); index++) {
            //Increment the counter variable for any characters that are the same.
            if(original.text.charAt(index) == this.text.charAt(index)){
                count++
            }
        }

        count
    }
}
