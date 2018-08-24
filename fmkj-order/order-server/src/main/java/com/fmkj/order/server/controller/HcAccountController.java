package com.fmkj.order.server.controller;

import com.baidu.unbiz.fluentvalidator.ComplexResult;
import com.baidu.unbiz.fluentvalidator.FluentValidator;
import com.baidu.unbiz.fluentvalidator.ResultCollectors;
import com.baomidou.mybatisplus.plugins.Page;
import com.fmkj.common.base.BaseApiService;
import com.fmkj.common.base.BaseController;
import com.fmkj.common.base.BaseResult;
import com.fmkj.common.base.BaseResultEnum;
import com.fmkj.common.validator.LengthValidator;
import com.fmkj.common.validator.NotNullValidator;
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
        Query<HcAccount> query = new Query<HcAccount>(params);
        // 参数校验
        ComplexResult validatResult = FluentValidator.checkAll()
                .on((String) params.get("telephone"), new LengthValidator(1, 13, "电话号码"))
                .on((String) params.get("email"), new NotNullValidator("邮箱"))
                .doValidate()
                .result(ResultCollectors.toComplex());
        if (!validatResult.isSuccess()) {
            return new BaseResult(BaseResultEnum.ERROR, validatResult.getErrors().get(0).getErrorMsg());
        }

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
