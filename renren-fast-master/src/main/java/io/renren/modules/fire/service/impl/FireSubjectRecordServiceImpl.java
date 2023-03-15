package io.renren.modules.fire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.fire.dao.FireSubjectRecordDao;
import io.renren.modules.fire.dto.FireSubjectRecordReqDTO;
import io.renren.modules.fire.entity.FireSubjectRecordEntity;
import io.renren.modules.fire.service.FireSubjectRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireSubjectRecordServiceImpl extends ServiceImpl<FireSubjectRecordDao, FireSubjectRecordEntity> implements FireSubjectRecordService {
  @Autowired
  private FireSubjectRecordDao fireSubjectRecordDao;


  @Override
  public IPage<FireSubjectRecordEntity> page(FireSubjectRecordReqDTO dto) {
    Page<FireSubjectRecordEntity> pageReq = new Page<>(dto.getPage(), dto.getLimit());
    LambdaQueryWrapper<FireSubjectRecordEntity> wrapper = Wrappers.lambdaQuery();
    return fireSubjectRecordDao.selectPage(pageReq, wrapper);
  }
}
