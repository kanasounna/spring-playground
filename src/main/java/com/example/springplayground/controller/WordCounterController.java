package com.example.springplayground.controller;

import com.example.springplayground.services.WordCounter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class WordCounterController {

    @Autowired
    private WordCounter wordCounter;

    @PostMapping("/words/count")
    public Map<String, Integer> doWordsCount(@RequestBody String words){
        return wordCounter.count(words);
    }
}
