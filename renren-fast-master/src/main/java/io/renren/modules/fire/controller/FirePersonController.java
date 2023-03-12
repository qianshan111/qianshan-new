package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/fire/person")
@Api(tags = "消防员考生个人页面")
public class FirePersonController {
    @Autowired
    private FireInfoService fireInfoService;

    @GetMapping("{name}")
    @ApiOperation("信息")
    public FirerInfoEntity get(@PathVariable("name") String name) {
        LambdaQueryWrapper<FirerInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNotBlank(name), FirerInfoEntity::getFireName, name);
        List<FirerInfoEntity> list = fireInfoService.queryList(FireInfoDTO.builder().name(name).build());
        if (CollectionUtils.isEmpty(list)) {
            return new FirerInfoEntity();
        }
        return list.iterator().next();
    }
}
