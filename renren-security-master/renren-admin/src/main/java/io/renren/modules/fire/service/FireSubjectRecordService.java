package io.renren.modules.fire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.service.BaseService;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;
import io.renren.modules.fire.entity.FirerInfoEntity;

public interface FireSubjectRecordService extends BaseService<FireSubjectRecordEntity> {
    IPage<FireSubjectRecordEntity> page(FireSubjectRecordReqDTO dto);
}
