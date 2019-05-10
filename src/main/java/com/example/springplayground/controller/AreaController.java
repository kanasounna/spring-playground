package com.example.springplayground.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AreaController {
    @PostMapping(value = "/math/area", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getArea(@RequestParam Map<String, String> formData) {
        double pi=3.1415925;
        if(formData.get("type").equals("circle")){
            if((formData.get("raduis")==null)
                || (formData.get("height")!=null)
                || (formData.get("width")!=null)){
                return "Invalid";
            }
            else{
                return String.format("Area of a circle with a radius of %s is %s!",
                        formData.get("raduis"),
                        pi*(Integer.valueOf(formData.get("raduis"))*Integer.valueOf(formData.get("raduis"))));
            }
        }
        else {
            if(formData.get("type").equals("rectangle")){
                if(formData.get("raduis")!=null
                        || formData.get("height")==null
                        || formData.get("width")==null){
                    return "Invalid";
                }
                else
                    return String.format("Area of a %sx%s rectangle is %s!",
                            formData.get("height"),
                            formData.get("width"),
                            Integer.valueOf(formData.get("height"))*Integer.valueOf(formData.get("width")));
            }
            else
            return "Invalid";
        }
    }
}
