package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.Coupon;
import com.example.repo.CouponRepo;

@RestController
@RequestMapping("/couponapi")
public class CouponRestController {
	
	@Autowired
	CouponRepo repo;
	
	@PostMapping("/coupons")
	public Coupon create(@RequestBody Coupon coupon) {
		return repo.save(coupon);
		
	}
	
	@GetMapping("/coupons/{code}")
	public Coupon getCoupon(@PathVariable("code") String code) {
		System.out.println("Server 2");
		return repo.findByCode(code);
	}

}
