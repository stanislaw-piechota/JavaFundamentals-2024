package com.example;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;

public class App 
{
    public static void main( String[] args ) throws IOException
    {
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(App.class.getResource("/db.json"));
        System.out.println(root);
    }
}
