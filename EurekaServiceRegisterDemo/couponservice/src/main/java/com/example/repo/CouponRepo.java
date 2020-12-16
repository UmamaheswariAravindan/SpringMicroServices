package com.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Coupon;

public interface CouponRepo extends JpaRepository<Coupon, Long> {

	Coupon findByCode(String code);
	

}
