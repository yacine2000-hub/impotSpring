package com.example.ngor.demo.Dto;

import lombok.*;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class DeclarationDto {

    private Long id ;
    private LocalDate date;
    private Double montant;
    private Integer declarant_id;

}
