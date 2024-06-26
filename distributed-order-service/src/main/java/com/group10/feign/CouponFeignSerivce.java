package com.group10.feign;

import com.group10.request.LockCouponRecordRequest;
import com.group10.util.JsonData;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "distributed-coupon-service")
public interface CouponFeignSerivce {

    /**
     * 查询用户的优惠券是否可用，防止水平权限
     * @param recordId
     * @return
     */
    @GetMapping("/api/coupon_record/v1/detail/{record_id}")
    JsonData findUserCouponRecordById(@PathVariable("record_id") long recordId);

    /**
     * 锁定优惠券记录
     * @param lockCouponRecordRequest
     * @return
     */
    @PostMapping("/api/coupon_record/v1/lock_records")
    JsonData lockCouponRecords(@RequestBody LockCouponRecordRequest lockCouponRecordRequest);
}
