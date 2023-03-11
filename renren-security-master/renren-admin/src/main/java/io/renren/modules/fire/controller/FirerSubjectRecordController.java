package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.annotation.LogOperation;
import io.renren.common.utils.Result;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.renren.modules.fire.service.FireSubjectRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/fire/record")
@Api(tags = "消防员成绩管理")
public class FirerSubjectRecordController {
    @Autowired
    private FireSubjectRecordService fireSubjectRecordService;

    @GetMapping("list")
    @ApiOperation("列表")
    public Result<IPage<FireSubjectRecordEntity>> list(FireSubjectRecordReqDTO dto) {
        IPage<FireSubjectRecordEntity> page = fireSubjectRecordService.page(dto);
        return new Result<IPage<FireSubjectRecordEntity>>().ok(page);
    }

    @GetMapping("{id}")
    @ApiOperation("信息")
    public Result<FireSubjectRecordEntity> get(@PathVariable("id") Long id) {
        FireSubjectRecordEntity entity = fireSubjectRecordService.selectById(id);
        return new Result<FireSubjectRecordEntity>().ok(entity);
    }

    @PostMapping
    @ApiOperation("保存/修改")
    @LogOperation("保存/修改")
    public Result saveOrUpdate(@RequestBody FireSubjectRecordEntity entity) {
        if (null == entity.getId()) {
            fireSubjectRecordService.insert(entity);
        } else {
            fireSubjectRecordService.deleteById(entity.getId());
            fireSubjectRecordService.insert(entity);
        }
        return new Result();
    }
}
