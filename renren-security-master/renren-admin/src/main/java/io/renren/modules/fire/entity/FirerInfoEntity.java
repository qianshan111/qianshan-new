package io.renren.modules.fire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@TableName("firer_info")
public class FirerInfoEntity {
    private Long id;
    @ApiModelProperty(value = "名字（修改时 名字不可以改）")
    private String name;
    @ApiModelProperty(value = "身份证号")
    private String idNumber;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "性别（传 男，女）")
    private String gender;
    @ApiModelProperty(value = "身高")
    private String height;
    @ApiModelProperty(value = "体重")
    private String weight;
    @ApiModelProperty(value = "家庭住址")
    private String address;
    /**
     * 学历
     */
    @ApiModelProperty(value = "学历")
    private String qualification;
    /**
     * 籍贯
     */
    @ApiModelProperty(value = "籍贯")
    private String nativePlace;
    @ApiModelProperty(value = "状态（未审核，审核通过，审核驳回）【每次修改，状态都传未审核】")
    private String state;
    @ApiModelProperty(value = "原因")
    private String reason;
    @ApiModelProperty(value = "照片")
    private String picture;
    /**
     * 录取结果
     */
    @ApiModelProperty(value = "录取结果（已录取，未录取）")
    private String enterResult;
    /**
     * 总成绩
     */
    @ApiModelProperty(value = "总成绩")
    private Integer record;
    /**
     * 排名
     */
    @ApiModelProperty(value = "成绩排名")
    private Integer sort;



}
