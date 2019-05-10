package com.example.springplayground.controller;

import com.example.springplayground.controller.CalculatorController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import  static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@RunWith(SpringRunner.class)
@WebMvcTest(CalculatorController.class)
public class CalculatorControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Test
    public void testAdd() throws Exception {
        this.mockMvc.perform(get("/math/calculate?operation=add&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("10"));
    }
    @Test
    public void testMultiply() throws Exception {
        this.mockMvc.perform(get("/math/calculate?operation=multiply&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("24"));
    }
    @Test
    public void testSubtract() throws Exception {
        this.mockMvc.perform(get("/math/calculate?operation=subtract&x=4&y=6").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("-2"));
    }
    @Test
    public void testDivide() throws Exception {
        this.mockMvc.perform(get("/math/calculate?operation=divide&x=26&y=2").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("13"));
    }
    @Test
    public void testDefaultOperation() throws Exception {
        this.mockMvc.perform(get("/math/calculate?x=26&y=2").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("28"));
    }
    @Test
    public void testSum() throws Exception {
        this.mockMvc.perform(get("/math/sum?n=26&n=2&n=-3").accept(MediaType.TEXT_PLAIN))
                .andExpect(status().isOk())
                .andExpect(content().string("25"));
    }
}
