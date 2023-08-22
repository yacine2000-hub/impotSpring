package com.example.ngor.demo.Controller;

import com.example.ngor.demo.Repository.DeclarantRepository;
import com.example.ngor.demo.model.Declarant;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin(origins = "*")
public class DeclarantController {


    @Autowired
    DeclarantRepository declarantRepository;
    @GetMapping("/declarants")
    private ResponseEntity<List<Declarant>>getAllDeclarants()
    {
        return new ResponseEntity<>(declarantRepository.findAll(), HttpStatus.OK);
    }
    @PostMapping("/declarants")
    private ResponseEntity<String> saveUser(@RequestBody Declarant declarantDto)
    {
        declarantRepository.save(declarantDto);
        return new ResponseEntity<>("add with success", HttpStatus.OK);
    }

}
