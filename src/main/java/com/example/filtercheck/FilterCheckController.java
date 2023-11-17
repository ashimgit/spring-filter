package com.example.filtercheck;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class FilterCheckController {
	
	@GetMapping("/items")
    public ResponseEntity<Object> getResp(){
        System.out.println("=============Inside getResp===========");

        return ResponseEntity.accepted().body("Ok Tested");
    }
	
	@PostMapping("/items")
    public ResponseEntity<Object> postResp(@Valid @RequestHeader(required = true) String key1){
        System.out.println("=============Inside postResp===========");

        return ResponseEntity.accepted().body("Ok Tested");
    }

}
