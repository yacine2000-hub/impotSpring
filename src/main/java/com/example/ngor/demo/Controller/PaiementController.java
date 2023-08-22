package com.example.ngor.demo.Controller;


import com.example.ngor.demo.Dto.PaiementDto;
import com.example.ngor.demo.Repository.DeclarationRepository;
import com.example.ngor.demo.Repository.PaiementRepository;
import com.example.ngor.demo.model.Declaration;
import com.example.ngor.demo.model.Paiement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class PaiementController {


    @Autowired
    PaiementRepository paiementRepository;


    @Autowired
    DeclarationRepository declarationRepository;
    //creating a get mapping that retrieves all the books detail from the database
    @GetMapping("/paiements")
    private ResponseEntity<List<Paiement>>getAllUsers()
    {
        return new ResponseEntity<>(paiementRepository.findAll(), HttpStatus.OK);
    }

    //creating post mapping that post the book detail in the database
    @PostMapping("/paiements")
    private ResponseEntity<String> saveUser(@RequestBody PaiementDto paiementDto)
    {
        //User user = this.modelMapper.map(userDto, User.class);
        Declaration declaration= declarationRepository.findById(Long.valueOf(paiementDto.getDeclaration_id())).get();

        Paiement paiement = new Paiement();
        paiement.setDeclaration(declaration);
        paiement.setDate(paiementDto.getDate());
        paiement.setMontant(paiementDto.getMontant());
        //User user = UserMapper.mapToUser(userDto, role);
        paiementRepository.save(paiement);
        return new ResponseEntity<>("add with success", HttpStatus.OK);
    }

}
