package com.example.springplayground.services;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class WordCounter {

    public Map<String, Integer> count(String string){
        Map<String,Integer> wordCount=new HashMap<>();
        Arrays.asList(string.split(" ")).stream().forEach(elt -> {
            String stripedElt="";
            if(elt.endsWith(",")) {
                stripedElt = elt.substring(0, elt.length() - 1);
            }
            else stripedElt=elt;
                if(wordCount.get(stripedElt)==null) wordCount.put(stripedElt,1);
                else{
                    int currentNumber=wordCount.get(stripedElt);
                    wordCount.put(stripedElt,currentNumber+1);
                }
            });
        return wordCount;
    }
}
