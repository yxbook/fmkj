package com.fmkj.order.server.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fmkj.common.base.BaseApiService;
import com.fmkj.common.base.BaseController;
import com.fmkj.common.base.BaseResult;
import com.fmkj.order.dao.domain.HcAccount;
import com.fmkj.order.server.service.HcAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/order")
public class HcAccountController extends BaseController<HcAccount, HcAccountService> implements BaseApiService<HcAccount> {


    @Autowired
    HcAccountService hcAccountService;

    //Swagger API文档，启动类加入注解@EnableSwagger2
    //访问http://localhost:8080/swagger-ui.html即可、这里先不需要
    //@ApiOperation(value="查询HcAccount用户信息", notes="分页查询用户信息")

    @GetMapping(value = "selectPage")
    public BaseResult<Page<HcAccount>> selectPage(@RequestParam Map<String, Object> params) {


        return null;
    }

}
