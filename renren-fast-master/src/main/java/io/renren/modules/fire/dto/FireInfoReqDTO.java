package io.renren.modules.fire.dto;

import io.renren.common.BaseDTO;
import io.renren.common.constants.FireEnum;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class FireInfoReqDTO extends BaseDTO {
  @ApiModelProperty(value = "状态（传 未审核）")
  private String state = FireEnum.未审核.name();

}
