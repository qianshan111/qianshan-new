package io.renren.modules.fire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;

public interface FireSubjectRecordService extends IService<FireSubjectRecordEntity> {
  IPage<FireSubjectRecordEntity> page(FireSubjectRecordReqDTO dto);
}
