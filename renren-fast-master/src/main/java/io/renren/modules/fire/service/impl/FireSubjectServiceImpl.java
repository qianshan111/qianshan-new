package io.renren.modules.fire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.renren.modules.fire.dao.FireSubjectInfoDao;
import io.renren.modules.fire.dto.FireSubjectReqDTO;
import io.renren.modules.fire.entity.FireSubjectEntity;
import io.renren.modules.fire.service.FireSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FireSubjectServiceImpl extends ServiceImpl<FireSubjectInfoDao, FireSubjectEntity> implements FireSubjectService {
  @Autowired
  private FireSubjectInfoDao fireSubjectInfoDao;

  @Override
  public IPage<FireSubjectEntity> page(FireSubjectReqDTO dto) {
    Page<FireSubjectEntity> pageReq = new Page<>(dto.getPage(), dto.getLimit());
    LambdaQueryWrapper<FireSubjectEntity> wrapper = Wrappers.lambdaQuery();
    return fireSubjectInfoDao.selectPage(pageReq, wrapper);
  }
}
