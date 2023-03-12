package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.utils.PageUtils;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;
import io.renren.modules.fire.service.FireSubjectRecordService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
  public PageUtils list(FireSubjectRecordReqDTO dto) {
    IPage<FireSubjectRecordEntity> page = fireSubjectRecordService.page(dto);
    return new PageUtils(page);
  }

  @GetMapping("{id}")
  @ApiOperation("信息")
  public FireSubjectRecordEntity get(@PathVariable("id") Long id) {
    return fireSubjectRecordService.getById(id);
  }

  @PostMapping
  @ApiOperation("保存/修改")
  public Integer saveOrUpdate(@RequestBody FireSubjectRecordEntity entity) {
    fireSubjectRecordService.saveOrUpdate(entity);
    return 1;
  }
}
