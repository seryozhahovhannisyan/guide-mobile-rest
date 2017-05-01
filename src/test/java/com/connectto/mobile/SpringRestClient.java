package com.connectto.mobile;

import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Set;

/**
 * Created by User on 29.04.2017.
 */
public class SpringRestClient {
    public static final String REST_SERVICE_URI = "http://localhost:8080";

    /*
     * Add HTTP Authorization header, using Basic-Authentication to send user-credentials.
     */
    private static HttpHeaders getHeaders() {

        HttpHeaders headers = new HttpHeaders();
        headers.add("Authorization", "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJhZG1pbiIsImF1ZGllbmNlIjoid2ViIiwiY3JlYXRlZCI6MTQ5MzQyMTc4MDc2NywiZXhwIjoxNDk0MDI2NTgwfQ.epoXeLq-xCdjGUIHGHimkAfSiIXtLbTnK0WDID7VEXmcOBL5yrNhYJ1nN-LvZR4QZHoyE0iDgpjcUgl8hjnvkg");
        headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
        return headers;
    }

    /*
     * Send a GET request to get list of all users.
     */
    @SuppressWarnings("unchecked")
    private static void persons() {
        System.out.println("\nTesting listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<List> response = restTemplate.exchange(REST_SERVICE_URI + "/persons", HttpMethod.GET, request, List.class);
        List<LinkedHashMap<String, Object>> usersMap = (List<LinkedHashMap<String, Object>>) response.getBody();

        if (usersMap != null) {
            for (LinkedHashMap<String, Object> map : usersMap) {
                System.out.println("Person :    Name=" + map.get("name") + ", email=" + map.get("email"));
                ;
            }
        } else {
            System.out.println("No user exist----------");
        }
    }

    @SuppressWarnings("unchecked")
    private static void user() {
        System.out.println("\nTesting listAllUsers API-----------");
        RestTemplate restTemplate = new RestTemplate();

        HttpEntity<String> request = new HttpEntity<String>(getHeaders());
        ResponseEntity<Object> response = restTemplate.exchange(REST_SERVICE_URI + "/user", HttpMethod.GET, request, Object.class);
        LinkedHashMap<String, Object> usersMap = (LinkedHashMap<String, Object>) response.getBody();

        if (usersMap != null) {
            Set<String> keys = usersMap.keySet();
            for (String s : keys  ) {
                System.out.println(s);
            }
        } else {
            System.out.println("No user exist----------");
        }
    }


    public static void main(String args[]) {

        //persons();

        user();
    }
}