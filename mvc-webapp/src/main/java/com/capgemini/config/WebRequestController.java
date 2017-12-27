package com.capgemini.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.capgemini.service.Cart;
import com.capgemini.serviceimpl.CartServiceimpl;

@Controller
public class WebRequestController {
	@Autowired
	public CartServiceimpl cartServiceimpl;
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String showIndexPage(ModelMap model) {
		Cart cart = cartServiceimpl.getAllCart();
		System.out.println("^^^^^^^^^^^^^^^^^^^^^^");
		model.addAttribute("cartinfo", cart);
		System.out.println(cart);
		return "show";
	}

}
