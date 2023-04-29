package com.kelly.boot.web;

import com.kelly.boot.web.HelloController;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest(controllers = HelloController.class)
public class HelloControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void hello_will_return() throws Exception {
        String hello = "hello";
        RequestBuilder builder = MockMvcRequestBuilders.get("/hello");
        mvc.perform(builder)
                .andExpect(content().string(hello))
                .andExpect(status().isOk());
    }

    @Test
    public void helloDto_will_return() throws Exception {
        String name = "hak";
        int amount = 1000;
        RequestBuilder builder = MockMvcRequestBuilders.get("/hello/dto")
                .param("name", name)
                .param("amount", String.valueOf(amount));

        mvc.perform(builder).andExpect(status().isOk())
                .andExpect(jsonPath("$.name", is(name)))
                .andExpect(jsonPath("$.amount", is(amount)));

    }


}
