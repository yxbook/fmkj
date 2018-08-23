package com.fmkj.server.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.fmkj.common.base.BaseApiService;
import com.fmkj.common.base.BaseController;
import com.fmkj.common.base.BaseResult;
import com.fmkj.dao.domain.HcAccount;
import com.fmkj.server.service.HcAccountService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/fmkj/HcAccount")
public class HcAccountController extends BaseController<HcAccount, HcAccountService> implements BaseApiService<HcAccount> {


    @Override
    // @ApiOperation(value = "查询权限信息分页",notes = "查询权限信息分页")
    @RequestMapping(value = "selectPage", method = RequestMethod.GET)
    public BaseResult<Page<HcAccount>> selectPage(@RequestParam Map<String, Object> params) {
        return super.selectPage(params);
    }

}
