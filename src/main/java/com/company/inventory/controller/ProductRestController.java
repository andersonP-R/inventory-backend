package com.company.inventory.controller;

import java.io.IOException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.company.inventory.model.Product;
import com.company.inventory.response.ProductResponseRest;
import com.company.inventory.services.IProductService;
import com.company.inventory.utils.InventoryUtils;

@CrossOrigin(origins = {"http://localhost:4200"})
@RestController
@RequestMapping("/api/v1")
public class ProductRestController {
	
	private IProductService productService;
		
	public ProductRestController(IProductService productService) {
		super();
		this.productService = productService;
	}

	/**
	 * save product
	 * @param picture
	 * @param name
	 * @param price
	 * @param quantity
	 * @param categoryID
	 * @return
	 * @throws IOException
	 */
	@PostMapping("/products")
	public ResponseEntity<ProductResponseRest> save(
			@RequestParam("picture") MultipartFile picture,
			@RequestParam("name") String name,
			@RequestParam("price") int price,
			@RequestParam("quantity") int quantity,
			@RequestParam("categoryId") Long categoryID ) throws IOException
	{
		Product product = new Product();
		product.setName(name);
		product.setQuantity(quantity);
		product.setPrice(price);
		// compress the picture to can saved in base64 format.
		// we use InventoryUtils methods that previously create (compressLib method)
		product.setPicture(InventoryUtils.compressZLib(picture.getBytes()));
		
		ResponseEntity<ProductResponseRest> response = productService.save(product, categoryID);		
		return response;
	}
}
