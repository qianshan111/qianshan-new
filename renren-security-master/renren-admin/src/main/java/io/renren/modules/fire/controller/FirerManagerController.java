package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.sun.corba.se.impl.encoding.WrapperInputStream;
import io.renren.common.annotation.LogOperation;
import io.renren.common.utils.Result;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.dto.FirePassDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fire/manager")
@Api(tags = "消防员审核管理")
public class FirerManagerController {
    @Autowired
    private FireInfoService fireInfoService;

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<IPage<FirerInfoEntity>> list(FireInfoReqDTO dto) {
        IPage<FirerInfoEntity> page = fireInfoService.page(dto);
        return new Result<IPage<FirerInfoEntity>>().ok(page);
    }

    @PostMapping
    @ApiOperation("审核通过/审核驳回")
    @LogOperation("审核通过/审核驳回")
    public Result saveOrUpdate(@RequestBody FirePassDTO dto) {
        FirerInfoEntity entity = fireInfoService.selectById(dto.getId());
        entity.setState(dto.getState());
        entity.setReason(dto.getReason());
        fireInfoService.updateById(entity);
        return new Result();
    }
}
