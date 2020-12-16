package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coupon;
import com.example.model.Product;
import com.example.repos.ProductRepo;
import com.example.rests.CouponClient;

@RestController
@RequestMapping("/productapi")
public class ProductRestController {
	
	@Autowired
	private CouponClient couponClient;
	
	@Autowired
	private ProductRepo repo;
	
	@RequestMapping(value="/products",method=RequestMethod.POST)
	public Product create(@RequestBody Product product)
	{
		Coupon coupon = couponClient.getCoupon(product.getCouponCode());
		product.setPrice(product.getPrice().subtract(coupon.getDiscount()));
		
		return repo.save(product);
		
	}

}
