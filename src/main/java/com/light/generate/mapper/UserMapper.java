package com.light.generate.mapper;

import com.light.generate.entity.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author wishare
 * @since 2022-04-02
 */
@Mapper
public interface UserMapper extends BaseMapper<UserDO> {

}
