
package com.example.springplayground.controller;

import com.example.springplayground.controller.FormDataController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;

import java.util.Random;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(FormDataController.class)
public class FormDataControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void testCreateComment() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/rb/comments")
                .contentType(MediaType.APPLICATION_FORM_URLENCODED_VALUE)
                .param("content", content)
                .param("author", "Dwayne");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s!", content)));
    }

    @Test
    public void testCreateComment2() throws Exception {
        String content = String.valueOf(new Random().nextInt());

        MockHttpServletRequestBuilder request1 = post("/rb/comments")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"author\":\"Dwayne\",\"content\":\"" + content + "\"}");

        this.mvc.perform(request1)
                .andExpect(status().isOk())
                .andExpect(content().string(String.format("Dwayne said %s!", content)));
    }

}