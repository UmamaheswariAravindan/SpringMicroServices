package com.example.rests;

import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Coupon;

@FeignClient("COUPON-SERVICE")
@LoadBalancerClient("COUPON-SERVICE")
public interface CouponClient {

	@GetMapping("/couponapi/coupons/{code}")
			Coupon getCoupon(@PathVariable("code") String code);
}
