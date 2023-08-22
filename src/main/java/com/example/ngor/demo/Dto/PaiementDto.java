package com.example.ngor.demo.Dto;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PaiementDto {

    private Long id ;
    private LocalDate date;
    private Double montant;
    private Integer declaration_id;

}
