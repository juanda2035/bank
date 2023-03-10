package com.bank.service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.bank.domain.DocumentType;
import com.bank.repository.DocumentTypRepository;

@Service
public class DocumentTypeServiceImpl implements DocumentTypeService {

	@Autowired
	DocumentTypRepository documentTypRepository;
	
	@Autowired
	Validator validator;
	
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
	public void validate(DocumentType entity) throws ConstraintViolationException {
		Set<ConstraintViolation<DocumentType>> constraintViolation=validator.validate(entity);
		if (!constraintViolation.isEmpty()) {
			throw new ConstraintViolationException(constraintViolation);
		}
	}
	
	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DocumentType save(DocumentType entity) throws Exception {
		if(entity==null) {
			throw new Exception("El DocumentType es nulo");
		}
		validate(entity);
		
		if(documentTypRepository.existsById(entity.getDotyId()) == true) {
			throw new Exception("El DocmentType con id:" + entity.getDotyId() + " ya existe");
		}
	
		return documentTypRepository.save(entity);
	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public DocumentType update(DocumentType entity) throws Exception {
		if(entity==null) {
			throw new Exception("El DocumentType es nulo.");
		}
		validate(entity);
		
		if(documentTypRepository.existsById(entity.getDotyId()) == false) {
			throw new Exception("El DocmentType con id:" + entity.getDotyId() + " no existe.");
		}
	
		return documentTypRepository.save(entity);
	}

	@Override
	public void delete(DocumentType entity) throws Exception {
		if(entity==null) {
			throw new Exception("El DocumentType es nulo");
		}
		if(entity.getDotyId() == null || entity.getDotyId() == 0) {
			throw new Exception("El documentType id nulo");
		}
				
		if(documentTypRepository.existsById(entity.getDotyId()) == false) {
			throw new Exception("El DocmentType con id:" + entity.getDotyId() + " no existe.");
		}
		
		documentTypRepository.findById(entity.getDotyId()).ifPresent(documentType -> {
			if(documentType.getCustomers().isEmpty() == true) {
				throw new RuntimeException("El documentType tiene customers asociados");
			}
		});
		
		documentTypRepository.deleteById(entity.getDotyId());

	}

	@Override
	@Transactional(readOnly = false, propagation = Propagation.REQUIRED, rollbackFor = Exception.class)
	public void deleteById(Integer id) throws Exception {
		if (id == null || id <= 0) {
			throw new Exception("El id es nulo o menor igual a cero");
		}

		if (documentTypRepository.existsById(id) == false) {
			throw new Exception("El documentType con id:" + id + " no existe.");

		}
		delete(documentTypRepository.findById(id).get());
		

	}

}
