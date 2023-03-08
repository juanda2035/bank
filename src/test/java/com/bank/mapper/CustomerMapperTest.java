package com.bank.mapper;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.UUID;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;

import com.bank.domain.Customer;
import com.bank.dto.CustomerDTO;


@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@TestMethodOrder(OrderAnnotation.class)
class CustomerMapperTest {

	@Autowired
	CustomerMapper customerMapper;
	
	@Test
	void debeMappearDeCustomeraCustomerDTO() {
		
		Customer customer=new Customer();
		customer.setAccounts(null);
		customer.setAddress("Avenidad siempre viva 123");
		customer.setCustId(2020);
		customer.setEmail("homerojssimpson@mapu.com");
		customer.setEnable(true);
		customer.setName("Homero J Simpson");
		customer.setPhone("5555555");
		customer.setRegisteredAccounts(null);
		customer.setToken(UUID.randomUUID().toString().toUpperCase());

		CustomerDTO customerDTO=null;
		
		//Act
		customerDTO=customerMapper.toCustomerDTO(customer);
	
		//Assert
		assertNotNull(customerDTO);
		
		
	}
	
	@Test
	void debeMappearDeCustomerDTOaCustomer() {
		
		//Arrange
		CustomerDTO customerDTO=new CustomerDTO()	;
		customerDTO.setAddress("Avenida Siempre viva 123");
		customerDTO.setCustId(202);
		customerDTO.setEmail("hsimpson@mapu.com");
		customerDTO.setEnable(true);
		customerDTO.setName("Homero J Simpson");
		customerDTO.setPhone("397554947");
		customerDTO.setToken(UUID.randomUUID().toString().toUpperCase());
		customerDTO.setDotyId(1);
		Customer customer=null;
		
		//Act
		customer=customerMapper.toCustomer(customerDTO);
		
		//Assert
		assertNotNull(customer);
		
	}

}
