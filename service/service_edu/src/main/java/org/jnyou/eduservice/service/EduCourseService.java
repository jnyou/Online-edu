package org.jnyou.eduservice.service;

import org.jnyou.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.eduservice.entity.vo.CourseInfoVo;

/**
 * <p>
 * 课程 服务类
 * </p>
 *
 * @author jnyou
 * @since 2020-06-07
 */
public interface EduCourseService extends IService<EduCourse> {

    /**
     * 添加课程信息
     * @param courseInfoVo
     * @return
     */
    String saveCourseInfo(CourseInfoVo courseInfoVo);
}
