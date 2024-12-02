package com.example.demo.testcontainer.api;

import com.example.demo.testcontainer.AbstractIntegrationTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
class EmployeeControllerTest extends AbstractIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void all() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/employees")
                .content("application/json"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("Bilbo Baggins"));
    }

    @Test
    void newEmployee() {
    }

    @Test
    void one() {
    }

    @Test
    void replaceEmployee() {
    }

    @Test
    void deleteEmployee() {
    }
}