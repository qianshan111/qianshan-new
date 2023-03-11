package io.renren.modules.fire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.modules.fire.dao.FireInfoDao;
import io.renren.modules.fire.dao.FireSubjectRecordDao;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import io.renren.modules.fire.service.FireSubjectRecordService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireSubjectRecordServiceImpl extends BaseServiceImpl<FireSubjectRecordDao, FireSubjectRecordEntity> implements FireSubjectRecordService {
    @Autowired
    private FireSubjectRecordDao fireSubjectRecordDao;


    @Override
    public IPage<FireSubjectRecordEntity> page(FireSubjectRecordReqDTO dto) {
        Page<FireSubjectRecordEntity> pageReq = new Page<>(dto.getPage(), dto.getLimit());
        LambdaQueryWrapper<FireSubjectRecordEntity> wrapper = Wrappers.lambdaQuery();
        return fireSubjectRecordDao.selectPage(pageReq, wrapper);
    }
}
