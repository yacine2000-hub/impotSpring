package com.example.ngor.demo.Repository;

import com.example.ngor.demo.model.Paiement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaiementRepository extends JpaRepository<Paiement, Long> {
}
