package com.capgemini.serviceimpl;

import org.springframework.stereotype.Service;

import com.capgemini.service.Cart;
import com.capgemini.service.CartService;

@Service
public class CartServiceimpl implements CartService {
	@Override
	public Cart getAllCart() {
		/*
		 * String uri = URLConstants.URL + "/{id}"; System.out.println(uri); Map<String,
		 * String> params = new HashMap<String, String>(); params.put("userId", "1");
		 * RestTemplate restTemplate = new RestTemplate(); Cart result =
		 * restTemplate.getForObject(uri, Cart.class, params);
		 * System.out.println(result); System.out.println(result);
		 */
		Cart cart = new Cart();
		cart.setEducation("sdfsafas");
		cart.setUserId("1234");
		return cart;
	}

}
