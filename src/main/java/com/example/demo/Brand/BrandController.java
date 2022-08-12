package com.example.demo.Brand;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.Category.Category;
import com.example.demo.Category.CategoryRepository;

@Controller
public class BrandController {

	
	@Autowired 
	private BrandRepository brandRepo;
	
	@Autowired 
	private CategoryRepository catRepo;
	
	
	
	
	//show brand form
	@GetMapping("/brands/new")
	public String showBrandForm(Model model) {
		model.addAttribute("brand", new Brand());
		List<Category> listCategories = catRepo.findAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("titlePage", "Create New Brand");
		return "brand_form";
	}
	
	//save new brand
	@PostMapping("/brands/save")
	public String saveNewBrand(Brand brand) {
		brandRepo.save(brand);
		return "redirect:/brands";
	}
	
	//show list brand
	@GetMapping("/brands")
	public String listBrands(Model model) {
		List<Brand> listBrands = brandRepo.findAll();
		model.addAttribute("listBrands", listBrands);
		
		return "brands";
	}
	
	//edit brand
	@GetMapping("/brands/edit/{id}")
	public String editBrand(@PathVariable ("id") Integer id, Model model) {
		Brand brand = brandRepo.findById(id).get();
		model.addAttribute("brand", brand);
		
		//get list categories
		List<Category> listCategories = catRepo.findAll();
		model.addAttribute("listCategories", listCategories);
		model.addAttribute("titlePage", "Edit Brand ID: "+ id);
		return "brand_form";
	}
	
	
	//delete brand
	@GetMapping("/brands/delete/{id}")
	public String deleteBrand(@PathVariable ("id") Integer id, Model model) {
		
		brandRepo.deleteById(id);
		return "redirect:/brands";
	}
}
