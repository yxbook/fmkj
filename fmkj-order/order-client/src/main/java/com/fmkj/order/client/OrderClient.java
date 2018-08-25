package com.fmkj.order.client;

import com.fmkj.common.base.BaseApiService;
import com.fmkj.order.dao.domain.UserInfo;
import org.springframework.cloud.openfeign.FeignClient;

/**
 * @Auther: youxun
 * @Date: 2018/8/25 15:53
 * @Description:
 */
@FeignClient(name="fmkj-order")
public interface OrderClient extends BaseApiService<UserInfo>{
}
