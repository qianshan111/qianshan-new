package io.renren.modules.fire.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 科目成绩
 */
@Data
@TableName("fire_subject_record")
public class FireSubjectRecordEntity {
    private Long id;
    /**
     * 科目
     */
    private Long subjectId;
    private String subjectName;
    /**
     * 消防员
     */
    private Long firerId;
    private String firerName;
    private Integer record;

}
