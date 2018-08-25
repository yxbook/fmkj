package com.fmkj.order.server.controller;

import com.fmkj.common.base.BaseApiService;
import com.fmkj.common.base.BaseController;
import com.fmkj.order.dao.domain.UserInfo;
import com.fmkj.order.server.service.HistryService;
import com.fmkj.race.client.RaceClient;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class HyistyController extends BaseController<UserInfo, HistryService> implements BaseApiService<UserInfo> {


    @Autowired
    HistryService hcAccountService;

    @Autowired
    private RaceClient raceClient;

    //Swagger API文档，启动类加入注解@EnableSwagger2
    //访问http://localhost:8080/swagger-ui.html即可、这里先不需要
    //@ApiOperation(value="查询HcAccount用户信息", notes="分页查询用户信息")

    //服务降级测试

    @GetMapping(value = "selectUserInfo")
    public String selectUserInfo(@RequestParam String id) {

        String result1 = raceClient.findUserPost("1");
        System.out.println("result1result1====：" + result1);

        String result2 = raceClient.findUserGet("1");

        System.out.println("result2result2====：" + result2);

        return result1 + result2;
    }

}
