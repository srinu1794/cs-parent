package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bean.GiftCardCatalog;
import com.example.demo.bean.ProductCatalog;
import com.example.demo.repository.MongoRepo;
import com.example.demo.repository.MongoRepoGifts;

@RestController
public class CatalogController {
	
	@Autowired
	MongoRepo mongoRepo;
	
	@Autowired
	MongoRepoGifts mongoRepoGifts;
	
	@RequestMapping(value="getAllProds",method = RequestMethod.GET)
	public List<ProductCatalog> getAll() {
		return mongoRepo.findAll();
		
	}
	@RequestMapping(value="add",method=RequestMethod.POST)
	public void addProduct(@RequestBody ProductCatalog pc){
	    mongoRepo.save(pc);
	}
	/*@RequestMapping(value="update/{id}",method=RequestMethod.POST)
	public void updateProduct(@PathVariable("id") String id){
	    mongoRepo.();
	}*/
	@RequestMapping(value="delete/{id}",method=RequestMethod.POST)
	public void delete(@PathVariable("id") String id){
		mongoRepo.delete(id);
	}
	
	@GetMapping("getGiftCards")
	public List<GiftCardCatalog> getAllGifts() {
		return mongoRepoGifts.findAll();
	}

	

}
