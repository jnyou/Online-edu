package org.jnyou.eduservice.service;

import org.jnyou.eduservice.entity.EduCourse;
import com.baomidou.mybatisplus.extension.service.IService;
import org.jnyou.eduservice.entity.vo.CourseInfoVo;
import org.jnyou.eduservice.entity.vo.CoursePublishVo;

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

    /**
     * 根据课程ID查询课程信息
     * @param courseId
     * @return
     */
    CourseInfoVo getCourseInfoByCourseId(String courseId);

    /**
     * 修改课程信息
     * @param courseInfoVo
     * @return
     */
    void updateCourseInfo(CourseInfoVo courseInfoVo);

    /**
     * 根据课程ID查询发布的课程信息
     * @param courseId
     * @return
     */
    CoursePublishVo queryCoursePublishInfo(String courseId);

    /**
     * 根据课程ID发布课程
      * @param id
     * @return
     */
    boolean publishCourseById(String id);
}
