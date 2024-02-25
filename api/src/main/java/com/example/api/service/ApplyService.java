package com.example.api.service;

import com.example.api.domain.Coupon;
import com.example.api.repository.CouponCountRepository;
import com.example.api.repository.CouponRepository;
import org.springframework.stereotype.Service;

@Service
public class ApplyService {
    private final CouponRepository couponRepository;
    private final CouponCountRepository couponCountRepository;

    public ApplyService(CouponRepository couponRepository, CouponCountRepository couponCountRepository) {
        this.couponRepository = couponRepository;
        this.couponCountRepository = couponCountRepository;
    }

    public void apply(Long userId) {
        // redis incr key:value 1씩 증가 시킴
        long count = couponCountRepository.increment();
        System.out.println("count = " + count);
        if (count > 100) {
            return;
        }

        couponRepository.save(new Coupon(userId));
    }
}
