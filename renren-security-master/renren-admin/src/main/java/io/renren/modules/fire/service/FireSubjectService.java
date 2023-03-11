package io.renren.modules.fire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.service.BaseService;
import io.renren.modules.fire.dto.FireSubjectReqDTO;
import io.renren.modules.fire.entity.FireSubjectEntity;
import io.renren.modules.fire.entity.FirerInfoEntity;

public interface FireSubjectService extends BaseService<FireSubjectEntity> {
    IPage<FireSubjectEntity> page(FireSubjectReqDTO dto);
}
