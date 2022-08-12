package com.example.demo.Cart;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CartController {
	@Autowired
	private ShoppingCartService cartService;
	
	
	@GetMapping("/cart")
	public String showCart(Model model, User user) {
		
		
//		List<CartItem> cartItemList = cartService.listCartItem(user);
		
		
		
		return "cart";
	}
							
	
	
}

