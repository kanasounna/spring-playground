package com.example.springplayground.controller;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(AreaController.class)
public class AreaControllerTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCircleArea() throws Exception {
        double pi=3.1415925;
        int raduis=4,width=4,height=7;
        MockHttpServletRequestBuilder request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("type", "circle")
                .param("raduis", "4");
        this.mockMvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Area of a circle with a radius of 4 is %s!", (raduis*raduis)*pi)));

        request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("type", "rectangle")
                .param("raduis", "4");
        this.mockMvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string("Invalid"));

        request1 = post("/math/area")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("type", "rectangle")
                .param("height", "7")
                .param("width","4");
        this.mockMvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Area of a %sx%s rectangle is %s!",height,width,height*width)));


    }
}
