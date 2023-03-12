package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.renren.common.exception.RRException;
import io.renren.common.utils.PageUtils;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
  public PageUtils list(FireInfoReqDTO dto) {
    IPage<FirerInfoEntity> page = fireInfoService.page(dto);

    return new PageUtils(page);
  }

  @GetMapping("{id}")
  @ApiOperation("信息")
  public FirerInfoEntity get(@PathVariable("id") Long id) {
    return fireInfoService.getById(id);
  }

  @PostMapping
  @ApiOperation("保存/修改")
  public void saveOrUpdate(@RequestBody FirerInfoEntity entity) {
    if (null == entity.getId()) {
      List<FirerInfoEntity> firerInfoEntities = fireInfoService.queryList(FireInfoDTO.builder().name(entity.getName()).build());
      if (CollectionUtils.isNotEmpty(firerInfoEntities)) {
        throw new RRException("名字重复");
      }
      fireInfoService.save(entity);
    } else {
      fireInfoService.removeById(entity.getId());
      fireInfoService.save(entity);
    }
  }

  @DeleteMapping("{id}")
  @ApiOperation("删除")
  public void delete(@PathVariable("id") Long id) {
    fireInfoService.removeById(id);
  }


}
