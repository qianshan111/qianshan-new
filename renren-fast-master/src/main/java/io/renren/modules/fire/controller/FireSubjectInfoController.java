package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.utils.PageUtils;
import io.renren.modules.fire.dto.FireSubjectReqDTO;
import io.renren.modules.fire.entity.FireSubjectEntity;
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
  public PageUtils list(FireSubjectReqDTO dto) {
    IPage<FireSubjectEntity> page = fireSubjectService.page(dto);
    return new PageUtils(page);
  }

  @GetMapping("{id}")
  @ApiOperation("信息")
  @RequiresPermissions("sys:dept:info")
  public FireSubjectEntity get(@PathVariable("id") Long id) {
    return fireSubjectService.getById(id);
  }

  @PostMapping
  @ApiOperation("保存/修改")
  public void saveOrUpdate(@RequestBody FireSubjectEntity entity) {
    fireSubjectService.saveOrUpdate(entity);
  }

  @DeleteMapping("{id}")
  @ApiOperation("删除")
  public void delete(@PathVariable("id") Long id) {
    fireSubjectService.removeById(id);
  }

}
