package org.jnyou.eduservice.service.impl;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.jnyou.eduservice.entity.EduTeacher;
import org.jnyou.eduservice.mapper.EduTeacherMapper;
import org.jnyou.eduservice.service.EduTeacherService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

/**
 * <p>
 * 讲师 服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-05-30
 */
@Service
public class EduTeacherServiceImpl extends ServiceImpl<EduTeacherMapper, EduTeacher> implements EduTeacherService {

    @Autowired
    private BaseMapper<EduTeacher> baseMapper;

    @Override
    public boolean removeById(Serializable id) {
        Integer result = baseMapper.deleteById(id);
        return null != result && result > 0;
    }

}
