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
        RandomStringUtils randomStringUtils = new RandomStringUtils()
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
