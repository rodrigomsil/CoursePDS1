package com.iftm.PDS1.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.iftm.PDS1.dto.CategoryDTO;
import com.iftm.PDS1.entities.Category;
import com.iftm.PDS1.repositories.CategoryRepository;
import com.iftm.PDS1.services.exceptions.DatabaseException;
import com.iftm.PDS1.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository  repository;

	public List<CategoryDTO> findAll() {
		List<Category> list = repository.findAll();
		return list.stream().map(e -> new CategoryDTO(e)).collect(Collectors.toList());
	}
	
	public CategoryDTO findById(Long id) {		
		Optional<Category> obj =  repository.findById(id);
		Category entity = obj.orElseThrow(() -> new ResourceNotFoundException(id));
		return new CategoryDTO(entity);
	}
	
	
	public Category insert(Category obj) {
		return  repository.save(obj);
	}
	
	public void delete(Long id){
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException(id);
		}catch(DataIntegrityViolationException e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	public Category update(Long id, Category obj) {
		try {
			Category entity = repository.getOne(id);
			updateData(entity,obj);
			return repository.save(entity);
		}catch(EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
		
	}

	private void updateData(Category entity, Category obj) {
		entity.setName(obj.getName());
		
	}
}
