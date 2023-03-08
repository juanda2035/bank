package com.bank.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.DocumentType;
import com.bank.repository.DocumentTypRepository;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService{

	@Autowired
	DocumentTypRepository documentTypRepository;
	
	
	@Override
	@Transactional(readOnly = true)
	public List<DocumentType> findAll() {
		return documentTypRepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<DocumentType> findById(Integer id) {
		return documentTypRepository.findById(id);
	}

	@Override
	@Transactional(readOnly = true)  
	public long count() {
		return documentTypRepository.count();
	}

	@Override
	public void validate(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public DocumentType save(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public DocumentType update(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(DocumentType entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

}
