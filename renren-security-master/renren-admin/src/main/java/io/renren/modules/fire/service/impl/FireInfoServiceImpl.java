package io.renren.modules.fire.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.renren.common.page.PageData;
import io.renren.common.service.impl.BaseServiceImpl;
import io.renren.modules.fire.dao.FireInfoDao;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.fire.service.FireInfoService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FireInfoServiceImpl extends BaseServiceImpl<FireInfoDao, FirerInfoEntity> implements FireInfoService {
    @Autowired
    private FireInfoDao fireInfoDao;

    @Override
    public IPage<FirerInfoEntity> page(FireInfoReqDTO dto) {
        Page<FirerInfoEntity> pageReq = new Page<>(dto.getPage(), dto.getLimit());
        LambdaQueryWrapper<FirerInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNoneBlank(dto.getState()),FirerInfoEntity::getState,dto.getState());
        return fireInfoDao.selectPage(pageReq, wrapper);
    }

    @Override
    public List<FirerInfoEntity> queryList(FireInfoDTO reqDTO) {
        LambdaQueryWrapper<FirerInfoEntity> wrapper = Wrappers.lambdaQuery();
        wrapper.eq(StringUtils.isNoneBlank(reqDTO.getName()),FirerInfoEntity::getName,reqDTO.getName());
        return fireInfoDao.selectList(wrapper);

    }
}
