package com.example.springplayground.services;

import org.springframework.stereotype.Service;
import org.springframework.util.MultiValueMap;

@Service
public class MathService {
    public int add(int x, int y){
        return x+y;
    }
    public int subtract(int x, int y){
        return x-y;
    }
    public int multiply(int x, int y){
        return x+y;
    }
    public int divide(int x, int y){
        return x/y;
    }
    public int calculate (MultiValueMap<String,String> queryString){
        return queryString.get("n")
                .stream()
                .mapToInt(Integer::parseInt)
                .sum();
    }
}
