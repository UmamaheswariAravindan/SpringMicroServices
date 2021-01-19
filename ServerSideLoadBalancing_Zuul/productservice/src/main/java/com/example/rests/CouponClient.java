package com.example.rests;

//import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.example.model.Coupon;

@FeignClient("zuul-api-gateway")
//@LoadBalancerClient("COUPON-SERVICE")
public interface CouponClient {

	@GetMapping("/coupon-service/couponapi/coupons/{code}")
			Coupon getCoupon(@PathVariable("code") String code);
}
