package io.renren.common.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class BaseDTO {
    @ApiModelProperty(value = "页码（默认1）")
    private Integer page;
    @ApiModelProperty(value = "分页条数")
    private Integer limit;
}
