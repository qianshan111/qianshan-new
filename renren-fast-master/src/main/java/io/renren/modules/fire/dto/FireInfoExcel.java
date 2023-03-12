package io.renren.modules.fire.dto;

import cn.afterturn.easypoi.excel.annotation.Excel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author zhoujian
 * @date 2023/3/12 18:01
 */
@Data
public class FireInfoExcel {
  @Excel(name = "主键")
  private Long id;
  @Excel(name = "姓名")
  private String fireName;
  @Excel(name = "身份证号")
  private String idNumber;
  @Excel(name = "手机号")
  private String phone;
  @Excel(name = "性别")
  private String gender;
  @Excel(name = "身高")
  private String height;
  @Excel(name = "体重")
  private String weight;
  @Excel(name = "家庭住址")
  private String address;
  /**
   * 学历
   */
  @Excel(name = "学历")
  private String qualification;
  /**
   * 籍贯
   */
  @Excel(name = "籍贯")
  private String nativePlace;
  @Excel(name = "状态")
  private String state;
  @Excel(name = "原因")
  private String reason;
  @Excel(name = "录取结果")
  private String enterResult;
  @Excel(name = "成绩")
  private Integer record;
}
