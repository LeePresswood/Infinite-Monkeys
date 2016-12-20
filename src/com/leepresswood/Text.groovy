package com.leepresswood

class Text {
    String text

    public Text(String text){
        this.text = text
    }

    public Text(int length){

    }

    public int getFitnessScore(Text original){
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
