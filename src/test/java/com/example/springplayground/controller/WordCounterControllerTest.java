package com.example.springplayground.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@WebMvcTest(WordCounterController.class)
public class WordCounterControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void doWordsCountTest() throws Exception {
        MockHttpServletRequestBuilder request = post("/words/count")
                .contentType(MediaType.TEXT_PLAIN)
                .content("A brown cow jumps over a brown fox");
        this.mockMvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\n" +
                        "  \"A\": 1,\n" +
                        "  \"brown\": 2,\n" +
                        "  \"cow\": 1,\n" +
                        "  \"jumps\": 1,\n" +
                        "  \"over\": 1,\n" +
                        "  \"a\": 1,\n" +
                        "  \"fox\": 1\n" +
                        "}"));
    }
}
