package org.jnyou.eduservice.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.eduservice.entity.EduTeacher;

import java.io.Serializable;

/**
 * <p>
 * 讲师 服务类
 * </p>
 *
 * @author jnyou
 * @since 2020-05-30
 */
public interface EduTeacherService extends IService<EduTeacher> {

    @Override
    public boolean removeById(Serializable id);
}
