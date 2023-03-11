package io.renren.modules.fire.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import io.renren.common.dao.BaseDao;
import io.renren.modules.fire.entity.FirerInfoEntity;
import io.renren.modules.sys.entity.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Mapper
public interface FireInfoDao extends BaseDao<FirerInfoEntity> {

}
