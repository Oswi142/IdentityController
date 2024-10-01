package com.example.examen;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;

@SpringBootTest
@AutoConfigureMockMvc
public class IdentityControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testVerificarCIExistente() throws Exception {
        mockMvc.perform(get("/verify-ci")
                        .param("ci", "12345678"))
                .andExpect(status().isOk())
                .andExpect(content().string("La CI existe."));
    }

    @Test
    public void testVerificarCINoExistente() throws Exception {
        mockMvc.perform(get("/verify-ci")
                        .param("ci", "87654321"))
                .andExpect(status().isOk())
                .andExpect(content().string("La CI no existe."));
    }
}
