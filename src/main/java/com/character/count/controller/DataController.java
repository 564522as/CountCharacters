package com.character.count.controller;

import com.character.count.model.CharacterQuantityInString;
import com.character.count.service.DataService;
import com.character.count.util.GetDataException;
import org.springframework.http.HttpEntity;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
public class DataController {
    private final DataService dataService;

    public DataController(DataService dataService) {
        this.dataService = dataService;
    }

    @PostMapping(value = "/sendingData",
    consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE},
    produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public HttpEntity<List<CharacterQuantityInString>> getData(@RequestBody Map<String, String> data) {
        String usefulData = data.get("data");
        if (usefulData == null) {
            throw new GetDataException("You have not point element data in your request body");
        }
        return new HttpEntity<>(dataService.processData(usefulData));
    }

}
