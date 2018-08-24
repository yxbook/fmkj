package com.fmkj.server.controller;

import com.alibaba.fastjson.JSON;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.fmkj.common.base.BaseApiService;
import com.fmkj.common.base.BaseController;
import com.fmkj.common.base.BaseResult;
import com.fmkj.common.base.BaseResultEnum;
import com.fmkj.dao.domain.HcAccount;
import com.fmkj.server.service.HcAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/fmkj/HcAccount")
public class HcAccountController extends BaseController<HcAccount, HcAccountService> implements BaseApiService<HcAccount> {


    @Autowired
    HcAccountService hcAccountService;
    @Override
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public BaseResult<Page<HcAccount>> selectPage(@RequestParam Map<String, Object> params) {

        Query<HcAccount> query = new Query<HcAccount>(params);

        Page<HcAccount> tPage =new Page<HcAccount>(query.getPageNo(),query.getPageSize());
        tPage.setSearchCount(true);

        Page<HcAccount> result = hcAccountService.selectPage(tPage, query.getEntityWrapper());

        /*List<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        Page<HcAccount> result = hcAccountService.selectPage(tPage, new EntityWrapper<HcAccount>().in("id", ids));*/

        return new BaseResult<Page<HcAccount>>(BaseResultEnum.SUCCESS, result);
    }

}
