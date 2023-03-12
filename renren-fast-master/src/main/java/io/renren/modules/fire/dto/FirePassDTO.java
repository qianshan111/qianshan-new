package io.renren.modules.fire.dto;

import io.renren.common.constants.FireEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FirePassDTO {
  @ApiModelProperty(value = "消防员主键id")
  private Long id;
  @ApiModelProperty(value = "状态（传 审核通过，审核驳回）")
  private String state = FireEnum.审核通过.name();
  @ApiModelProperty(value = "原因")
  private String reason;
}
