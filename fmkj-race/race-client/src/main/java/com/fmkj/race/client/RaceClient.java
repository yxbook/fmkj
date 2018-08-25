package com.fmkj.race.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Auther: youxun
 * @Date: 2018/8/25 14:38
 * @Description: 如果产生服务降级、访问到的实际方法是RaceClientFallback类里面的内容
 */

@FeignClient(name = "fmkj-race", fallback = RaceClient.RaceClientFallback.class)
public interface RaceClient {

    @PostMapping(value = "/race/findUserPost")
    String findUserPost(@RequestBody String message);

    @GetMapping(value = "/race/findUserGet")
    String findUserGet(@RequestParam String message);

    @Component
    public static class RaceClientFallback implements RaceClient {

        @Override
        public String findUserPost(String message) {
            return "POST========findUserPost";
        }

        @Override
        public String findUserGet(String message) {
            return "GET+++++++++++findUserGet";
        }
    }
}
