package com.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.domain.DocumentType;

public interface DocumentTypRepository extends JpaRepository<DocumentType, Integer> {

}
