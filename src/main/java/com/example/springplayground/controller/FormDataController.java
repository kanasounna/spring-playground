package com.example.springplayground.controller;

//import com.galvanize.RequestObjects.Search;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/rb")
public class FormDataController {

    @PostMapping("/individual-example")
    public String getIndividualParams(@RequestParam String from, @RequestParam("q") String query) {
        return String.format("q:%s from:%s", query, from);
    }

    @PostMapping(value = "/map-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getMapParams(@RequestParam Map<String, String> formData) {
        return formData.toString();
    }

    @PostMapping(value = "/object-example", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getObjectParams(Search search) {
        return search.toString();
    }

    @PostMapping("/string-example")
    public String getRawString(@RequestBody String rawBody) {
        return rawBody;
    }
    @PostMapping(value="/comments", consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String getComments( Search search) {
        return String.format("%s said %s!", search.getAuthor(), search.getContent());
    }

    @PostMapping(value="/comments")
    public String getComments2(@RequestBody Search search) {
        return String.format("%s said %s!", search.getAuthor(), search.getContent());
    }
    @PostMapping(value="/commentsXml",produces = {MediaType.APPLICATION_XML_VALUE, MediaType.APPLICATION_JSON_VALUE})
    public Search getCommentsXml(@RequestBody Search search) {
        return search;
    }
}

