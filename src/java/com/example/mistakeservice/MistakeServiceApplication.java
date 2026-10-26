package com.example.mistakeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@SpringBootApplication
public class MistakeServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(MistakeServiceApplication.class, args);
    }
}

@RestController
@RequestMapping("/api")
class myController {

    @PostMapping("/process")
    public Map<String, String> processJson(@RequestBody Map<String, Object> requestBody) {
        String unusedVariable = "This variable is never used";

        try {
            String summary = "Summary: " + requestBody.get("summary").toString();
            System.out.println("Processing request: " + requestBody);
            return Map.of("summary", summary);
        } catch (Exception e) {
            e.printStackTrace();
            return Map.of("error", "An error occurred while processing the request");
        }
    }
}
