package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.renren.common.annotation.LogOperation;
import io.renren.common.exception.RenException;
import io.renren.common.utils.Result;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fire/info")
@Api(tags = "消防员报名管理")
public class FireInfoController {
    @Autowired
    private FireInfoService fireInfoService;

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<IPage<FirerInfoEntity>> list(FireInfoReqDTO dto) {
        IPage<FirerInfoEntity> page = fireInfoService.page(dto);
        return new Result<IPage<FirerInfoEntity>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<FirerInfoEntity> get(@PathVariable("id") Long id) {
        FirerInfoEntity entity = fireInfoService.selectById(id);
        return new Result<FirerInfoEntity>().ok(entity);
    }

    @PostMapping
    @ApiOperation("保存/修改")
    @LogOperation("保存/修改")
    public Result saveOrUpdate(@RequestBody FirerInfoEntity entity) {
        if (null == entity.getId()) {
            List<FirerInfoEntity> firerInfoEntities = fireInfoService.queryList(FireInfoDTO.builder().name(entity.getName()).build());
            if(CollectionUtils.isNotEmpty(firerInfoEntities)){
                throw new RenException("名字重复");
            }
            fireInfoService.insert(entity);
        } else {
            fireInfoService.deleteById(entity.getId());
            fireInfoService.insert(entity);
        }
        return new Result();
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@PathVariable("id") Long id) {
        fireInfoService.deleteById(id);
        return new Result();
    }


}
