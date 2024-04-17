package com.javarush.lectures.mvc_demo;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletResponse;
import net.minidev.json.JSONObject;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.io.IOException;

public class Rest {

    private final PersonService personService;

    public Rest (PersonService personService){
        this.personService = personService;
    }

    @PostMapping(value = "/updatePerson", consumes = "application/json", produces = "application/json")
    public Person createPerson (@RequestBody Person person){
        return personService.saveUpdatePerson(person);
    }

    @PostMapping(value = "/updatePerson", consumes = "application/json", produces = "application/json")
    public Person updatePerson(@RequestBody Person person, HttpServletResponse response){
        response.setHeader("Location", ServletUriComponentsBuilder.fromCurrentContextPath().path("/findPerson/" + person.getId()).toUriString());

        return personService.saveUpdatePerson(person);
    }

    @BeforeClass
    public static void runBeforeAllTestMethods(){
        String createPersonUrl = "http://localhost:8080/spring-rest/createPerson";
        String updatePersonUrl = "http://localhost:8080/spring-rest/updatePerson";

        RestTemplate restTemplate = new RestTemplate();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        JSONObject personJsonObject = new JSONObject();
        personJsonObject.put("id", 1);
        personJsonObject.put("name", "John");
    }
    private final ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void givenDataIsJson_whenDataIsPostedByPostForObject_thenResponseBodyIsNotFull()
        throws IOException{
        HttpEntity<String> request = new HttpEntity<String> (personJsonObject.toString(), headers);

        String personResultAsJsonStr = restTemplate.postForObject(createPersonUrl, request, String.class);
        JsonNode root = objectMapper.readTree(responseEntity.getBody());

        assertNotNull(responseEntityStr.getBody());
        assertNotNull(root.path("name").asText());

    }

}
