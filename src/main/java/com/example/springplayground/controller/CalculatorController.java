package com.example.springplayground.controller;

import com.example.springplayground.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController

public class CalculatorController {
    @Autowired
    private MathService mathService;
    @GetMapping ("/math/calculate")
    public String calculate(@RequestParam(defaultValue = "add") String operation,@RequestParam int x, @RequestParam int y){
//        if(operation.equals("add")) return (x+y)+"";
//        if(operation.equals("multiply")) return  (x*y)+"";
//        if(operation.equals("subtract")) return (x-y)+"";
//        if(operation.equals("divide")) return  (x/y)+"";
        if(operation.equals("add")) return mathService.add(x,y)+"";
        if(operation.equals("multiply")) return  mathService.multiply(x,y)+"";
        if(operation.equals("subtract")) return mathService.subtract(x,y)+"";
        if(operation.equals("divide")) return  mathService.divide(x,y)+"";
        return "Operation " +HttpStatus.NOT_ACCEPTABLE.getReasonPhrase();

    }
    @GetMapping("/math/sum")
    public String calculate(@RequestParam MultiValueMap<String, String> queryString) {
//        return String.valueOf(queryString.get("n")
//                .stream()
//                .mapToInt(Integer::parseInt)
//                .sum());
        return String.valueOf(mathService.calculate(queryString));

//
//        List<Integer> sum= new ArrayList<>();
//        queryString.keySet().stream().forEach(element -> {
//            System.out.println("current element -->"+ element);
//            queryString.get(element).stream().forEach(innerElement -> sum.add(innerElement));
//        });
//        return sum.stream().reduce(0,(element1,element2)->element1+element2);
    }
}
