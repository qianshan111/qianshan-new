package io.renren.modules.fire.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.modules.fire.dto.FireInfoDTO;
import io.renren.modules.fire.dto.FireInfoReqDTO;
import io.renren.modules.fire.entity.FirerInfoEntity;

import java.util.List;

public interface FireInfoService extends IService<FirerInfoEntity> {

    IPage<FirerInfoEntity> page(FireInfoReqDTO dto);

    List<FirerInfoEntity> queryList(FireInfoDTO reqDTO);
}
