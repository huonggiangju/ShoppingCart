package com.example.demo.Product;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.Category.Category;
import com.example.demo.Category.CategoryService;

@Controller
public class ProductController {
	
	public static String uploadDir = System.getProperty("user.dir") + "/src/main/resources/static/image";

	@Autowired
	private ProductService productService;
	
	@Autowired
	private CategoryService categoryService;
	
	
	//show add new product form
	@GetMapping("/products/new")
	public String showProductForm(Model model) {
		//list categoresList
		model.addAttribute("listCategories", categoryService.getAllCategories());
		
		//add new product
		model.addAttribute("product", new Product());
		model.addAttribute("titlePage", "Create New Products");
		
		return "product_form";
	}
	
	//save new product
	@PostMapping("/products/save" )
//	public String saveNewProduct(Product product, HttpServletRequest request) {
//		String[] detailNames = request.getParameterValues("detailName");
//		String[] detailValues = request.getParameterValues("detailValue");
//		String[] detailIDs = request.getParameterValues("detailID");
//		
//		for(int i=0; i<detailNames.length; i++) {
//			if(detailIDs != null && detailIDs.length >0) {
//				product.setDetail(Integer.valueOf(detailIDs[i]), detailNames[i], detailValues[i]);
//			}else {
//				product.addDetail(detailNames[i], detailValues[i]);
//			}
//		}
//		
//		productService.addNewProduct(product);
//		return "redirect:/products";
//	}
	
	public String saveNewProduct(@ModelAttribute("product") Product product,
								@RequestParam("fileImage") MultipartFile file,
								@RequestParam("imgName")String imgName) throws IOException {
		
//		productService.addNewProduct(file, product.getId(), product.getName(), product.getPrice(), 
//				product.getCategory(), product.getDescription());
		
		Product p = new Product();
		p.setId(product.getId());
		p.setName(product.getName());
		p.setCategory(categoryService.getCategoryById(product.getCategory().getId()));
		p.setDescription(product.getDescription());
		p.setPrice(product.getPrice());
		
		String imageUUID;
		if(!file.isEmpty()) {
			imageUUID = file.getOriginalFilename();
			Path fileNameAndPath = Paths.get(uploadDir, imageUUID);
			Files.write(fileNameAndPath, file.getBytes());
		}else {
			imageUUID = imgName;
		}
		p.setImageName(imageUUID);
		productService.addNewProduct(p);
		
		return "redirect:/products";
	}
								
	
	//show list products
	@GetMapping("/products")
	public String listProducts(Model model) {
		model.addAttribute("listProduct", productService.getAllProducts());
		return "products";
	}
	
	//update product
	@GetMapping("/products/edit/{id}")
	public String showEditForm(@PathVariable("id") Integer id, Model model) {
		Product product = productService.getProductById(id);
		if(product != null) {
			model.addAttribute("product", product);
			model.addAttribute("titlePage", "Edit Product Id: " + id);
			
			//list categoresList
			List<Category> listCategories = categoryService.getAllCategories();
			model.addAttribute("listCategories", listCategories);
			
			return "product_form";
			
		}else {
			return "could not find any users with id " + product;
		}
		
		
		
	}
	
	//delete product
	@GetMapping("/products/delete/{id}")
	public String deleteProduct(@PathVariable("id") Integer id, Model model) {
		productService.deleteProductById(id);
		return "redirect:/products";
	}
	
	
	//view product detail
	@GetMapping("/products/view/{id}")
	public String viewProductDetail(Model model, @PathVariable("id") Integer id) {
		model.addAttribute("product", productService.getProductById(id));
		return "productDetail";
	}
}
