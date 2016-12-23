package com.leepresswood.population

import com.leepresswood.util.RandomStringUtils

class Text{
    public String text
    public Text original
    
    public Text(Text original){
        this.original = original
        this.text = RandomStringUtils.getRandomString(original.text.size())
    }
    
    public Text(Text original, String text){
        this.original = original
        this.text = text
    }
    
    public static Text createOriginalTextInstance(String text){
        new Text(null, text)
    }
    
    public int compareToOriginalAndScore(){
        int count = 0
        original.text.size().times{
            //Looking for any characters that match the parent. Fitter members have more matches.
            if(original.text.charAt(it) == this.text.charAt(it)){
                count++
            }
        }
        
        count
    }
}
