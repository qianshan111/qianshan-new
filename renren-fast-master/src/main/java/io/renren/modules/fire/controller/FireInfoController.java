package io.renren.modules.fire.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import io.renren.common.exception.RRException;
import io.renren.common.utils.ExcelUtils;
import io.renren.common.utils.PageUtils;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.dto.FireInfoExcel;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

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
  public Integer saveOrUpdate(@RequestBody FirerInfoEntity entity) {
    fireInfoService.saveOrUpdate(entity);
    return 1;
  }

  @DeleteMapping("{id}")
  @ApiOperation("删除")
  public Integer delete(@PathVariable("id") Long id) {
    fireInfoService.removeById(id);
    return 1;
  }

  @GetMapping("export")
  @ApiOperation("导出")
  public void export(HttpServletResponse response) throws Exception {
    List<FirerInfoEntity> firerInfoEntities = fireInfoService.queryList(FireInfoDTO.builder().build());

    ExcelUtils.exportExcelToTarget(response, null, firerInfoEntities, FireInfoExcel.class);
  }
}
