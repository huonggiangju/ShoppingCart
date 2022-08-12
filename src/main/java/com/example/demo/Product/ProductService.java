package com.example.demo.Product;

import java.io.IOException;
import java.nio.file.Paths;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Category.Category;
import com.example.demo.Category.CategoryRepository;
import com.example.demo.Category.CategoryService;


@Service
public class ProductService {

	@Autowired
	private ProductRepository repo;
	
	@Autowired
	private CategoryService categoryService;
	

	//add new Product
//	public void addNewProduct(MultipartFile file, 
//								Integer id, String name,
//								float price, Category category,
//								String Decription) {
//		String fileName = StringUtils.cleanPath(file.getOriginalFilename());
//		Product p = new Product();
//		
//		if(fileName.contains("..")) {
//			System.out.println("not a valid file");
//		}
//		try {
//			p.setImageName(Base64.getEncoder().encodeToString(file.getBytes()));
//		}catch(IOException e) {
//			e.printStackTrace();
//		}
//		
//		p.setId(id);
//		p.setName(name);
//		p.setDescription(Decription);
//		p.setPrice(price);
//		p.setImageName(fileName);
//		p.setCategory(categoryService.getCategoryById(category.getId()));
//		
//		repo.save(p);
//	}
	
	public void addNewProduct(Product p) {
		repo.save(p);
	}
	

	//list all Products
	public List<Product> getAllProducts(){
		return repo.findAll();
	}
	
	//get Product by id
	public Product getProductById(Integer id) {
		Optional<Product> proId = repo.findById(id);
		return proId.get();
		
	}
	
	//delete Product by id
	public void deleteProductById(Integer id) {
		repo.deleteById(id);
	}
	
	//get all products by category id
	public List<Product> getAllProductsByCategoryId(Integer id){
		return  repo.findAllByCategoryId(id);
		
	}
}
