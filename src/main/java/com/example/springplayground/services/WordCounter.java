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
            if(wordCount.get(elt)==null) wordCount.put(elt,1);
            else{
                int currentNumber=wordCount.get(elt);
                wordCount.put(elt,currentNumber+1);
            }
        });
        return wordCount;
    }
}
