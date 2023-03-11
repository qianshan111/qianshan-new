package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.annotation.LogOperation;
import io.renren.common.utils.Result;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.dto.FireSubjectReqDTO;
import io.renren.modules.fire.entity.FireSubjectEntity;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireSubjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/subject/info")
@Api(tags = "消防科目管理")
public class FireSubjectInfoController {
    @Autowired
    private FireSubjectService fireSubjectService;

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<IPage<FireSubjectEntity>> list(FireSubjectReqDTO dto) {
        IPage<FireSubjectEntity> page = fireSubjectService.page(dto);
        return new Result<IPage<FireSubjectEntity>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    @RequiresPermissions("sys:dept:info")
    public Result<FireSubjectEntity> get(@PathVariable("id") Long id) {
        FireSubjectEntity entity = fireSubjectService.selectById(id);
        return new Result<FireSubjectEntity>().ok(entity);
    }

    @PostMapping
    @ApiOperation("保存/修改")
    @LogOperation("保存/修改")
    public Result saveOrUpdate(@RequestBody FireSubjectEntity entity) {
        if (null == entity.getId()) {
            fireSubjectService.insert(entity);
        } else {
            fireSubjectService.deleteById(entity.getId());
            fireSubjectService.insert(entity);
        }
        return new Result();
    }

    @DeleteMapping("{id}")
    @ApiOperation("删除")
    @LogOperation("删除")
    public Result delete(@PathVariable("id") Long id) {
        fireSubjectService.deleteById(id);
        return new Result();
    }
    
}
