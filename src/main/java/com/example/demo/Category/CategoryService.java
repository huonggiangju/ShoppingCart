package com.example.demo.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CategoryService {
	
	@Autowired
	CategoryRepository repo;
	
	
	//add new category
	public void addNewCategory(Category category) {
		repo.save(category);
	}

	//list all categories
	public List<Category> getAllCategories(){
		return repo.findAll();
	}
	
	//get category by id
	public Category getCategoryById(Integer id) {
		Optional<Category> catId = repo.findById(id);
		return catId.get();
		
	}
	
	//delete category by id
	public void deleteCatgoryById(Integer id) {
		repo.deleteById(id);
	}
	
}
