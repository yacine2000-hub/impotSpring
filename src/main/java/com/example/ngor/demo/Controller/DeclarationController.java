package com.example.ngor.demo.Controller;

import com.example.ngor.demo.Dto.DeclarationDto;
import com.example.ngor.demo.Repository.DeclarantRepository;
import com.example.ngor.demo.Repository.DeclarationRepository;
import com.example.ngor.demo.model.Declarant;
import com.example.ngor.demo.model.Declaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class DeclarationController {


    @Autowired
    DeclarationRepository declarationRepository;


    @Autowired
    DeclarantRepository declarantRepository;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/declarations")
    private ResponseEntity<List<Declaration>>getAllUsers()
    {
        return new ResponseEntity<>(declarationRepository.findAll(), HttpStatus.OK);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/declarations")
    private ResponseEntity<String> saveUser(@RequestBody DeclarationDto declarationDto)
    {
        //User user = this.modelMapper.map(userDto, User.class);
        Declarant declarant= declarantRepository.findById(Long.valueOf(declarationDto.getDeclarant_id())).get();

        Declaration declaration = new Declaration();
        declaration.setDeclarant(declarant);
        declaration.setDate(declarationDto.getDate());
        declaration.setMontant(declarationDto.getMontant());
        //User user = UserMapper.mapToUser(userDto, role);
        declarationRepository.save(declaration);
        return new ResponseEntity<>("add with success", HttpStatus.OK);
    }


}
