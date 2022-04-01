package com.light.generate.service.impl;

import com.light.generate.entity.UserDO;
import com.light.generate.mapper.UserMapper;
import com.light.generate.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author wishare
 * @since 2022-04-02
 */
@Service
@RequiredArgsConstructor
public class UserServiceImp extends ServiceImpl<UserMapper, UserDO> implements UserService {

}
