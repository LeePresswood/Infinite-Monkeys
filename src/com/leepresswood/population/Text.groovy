package com.leepresswood.population

import com.leepresswood.util.RandomStringUtils

class Text {
    private String text
    private Text original

    public Text(String text){
        this.text = text
    }

    public Text(Text original){
        this.original = original
        this.text = RandomStringUtils.getRandomString(original.length)
    }
    
    public Text(Text original, String text){
        this.original = original
        this.text = text
    }
    
    public int getLength(){
        text.size()
    }

    public int compareToOriginalAndScore(){
        int count = 0
        for(int index = 0; index < original.text.size(); index++) {
            //Looking for any characters that match the parent. Fitter members have more matches.
            if(original.text.charAt(index) == this.text.charAt(index)){
                count++
            }
        }

        count
    }
}
