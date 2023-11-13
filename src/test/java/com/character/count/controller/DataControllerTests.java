package com.character.count.controller;

import com.character.count.model.CharacterQuantityInString;
import com.character.count.service.DataService;
import com.character.count.service.DataServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.mockito.ArgumentMatchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(DataController.class)
public class DataControllerTests {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper objectMapper;
    @MockBean
    private DataService dataService;
    @BeforeEach
    void init() {
        List<CharacterQuantityInString> o = new ArrayList<>();
        Mockito.when(dataService.processData(any(String.class))).thenReturn(o);
    }
    @Test
    void whenDoRequest_thenStatusCodeCorrect() throws Exception {
        Map<String, String> requestBody = new HashMap<>();
        requestBody.put("data", "text");

        mockMvc.perform(post("http://localhost:8080/sendingData")
                .content(objectMapper.writeValueAsString(requestBody))
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is2xxSuccessful())
                .andDo(print());
    }

    @Test
    void whenGiveNotCorrectRequestBody_thenReturnBadStatusCode() throws Exception {
        Map<String, String> requestBody = new HashMap<>();

        mockMvc.perform(post("http://localhost:8080/sendingData")
                        .content(objectMapper.writeValueAsString(requestBody))
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .accept(MediaType.APPLICATION_JSON_VALUE))
                .andExpect(status().is4xxClientError())
                .andDo(print());
    }
}
