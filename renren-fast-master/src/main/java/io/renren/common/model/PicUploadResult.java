package io.renren.common.model;

import lombok.Data;

import java.util.List;

/**
 * @author zhoujian
 * @date 2023/3/12 17:03
 */
@Data
public class PicUploadResult {
  private boolean isLegal;

  private String imgPath;

  private List<String> imgPahts;
}
