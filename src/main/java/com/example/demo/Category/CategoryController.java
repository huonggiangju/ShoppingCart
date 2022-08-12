package com.example.demo.Category;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class CategoryController {

	@Autowired
	CategoryService service;
	
	
	//list categories
	@GetMapping("/categories")
	public String listCategories(Model model) {
		List<Category> listCategories = service.getAllCategories();
		model.addAttribute("listCategories", listCategories);
		return "categories";
		
	}
	
	//show category form
	@GetMapping("/categories/new")
	public String showCategoryForm(Model model) {
		model.addAttribute("category", new Category());
		return "category_form";
	}
	
	//save new category
	
	@PostMapping("/category/save")
	public String saveNewCategory(@ModelAttribute("category") Category category) {
		service.addNewCategory(category);
		return "redirect:/categories";
	}
	
	
	//delete category
	@GetMapping("/categories/delete/{id}")
	public String deleteCat(@PathVariable("id") Integer id) {
		service.deleteCatgoryById(id);
		return "redirect:/categories";
	}
	
	//edit category
	@GetMapping("/categories/edit/{id}")
	public String updateCat(@PathVariable("id") Integer id, Model model) {
		Category category = service.getCategoryById(id);
		if(category != null) {
			model.addAttribute("category", category);
			model.addAttribute("titlePage", "Edit Category Id: " + id);
			return "category_form";
		}else {
			return "could not find any users with id " + category;
		}
		
	}
}
