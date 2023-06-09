package io.renren.modules.fire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 科目 名字
 */
@Data
@TableName("fire_subject")
public class FireSubjectEntity {
    private Long id;
    @ApiModelProperty(value = "消防科目名称")
    private String subjectName;
    @ApiModelProperty(value = "描述")
    private String describe;
}
