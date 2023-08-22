package com.example.ngor.demo.Repository;


import com.example.ngor.demo.model.Declaration;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeclarationRepository extends JpaRepository<Declaration, Long> {
}
