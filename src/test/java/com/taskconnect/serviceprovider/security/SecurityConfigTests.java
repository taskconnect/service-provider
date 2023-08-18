package com.taskconnect.serviceprovider.security;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class SecurityConfigTests {
    @Autowired
    private MockMvc mockMvc;

    private final String requestPath = "/api/v1/service-providers";

    @Test
    public void should_GetResponse_When_RequestedFromCrossOrigin() throws Exception {
        // When
        ResultActions result = mockMvc.perform(MockMvcRequestBuilders.options(requestPath)
                        .header("Access-Control-Request-Method", "GET")
                        .header("Origin", "http://localhost:3000"));

        // Then
        result.andDo(MockMvcResultHandlers.print()).andExpect(MockMvcResultMatchers.status().isOk());
    }
}
