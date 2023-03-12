package io.renren.modules.fire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.fire.dto.FireSubjectReqDTO;
import io.renren.modules.fire.entity.FireSubjectEntity;

public interface FireSubjectService extends IService<FireSubjectEntity> {
  IPage<FireSubjectEntity> page(FireSubjectReqDTO dto);
}
