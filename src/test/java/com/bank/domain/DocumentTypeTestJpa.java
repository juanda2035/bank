package com.bank.domain;

import javax.persistence.EntityManager;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class DocumentTypeTestJpa {
	
	@Autowired
	EntityManager entityManager;
	
	
	@Test
	@Order(1)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	void debeEncontrarDocumentType () {
		
	}

	@Test
	@Order(2)
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED)
	void debeFallarAlEncontrarDocumentType() {
		
	}
	
	
}
