package org.jnyou.eduservice.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jnyou.eduservice.entity.EduCourse;
import org.jnyou.eduservice.entity.EduCourseDescription;
import org.jnyou.eduservice.entity.vo.CourseInfoVo;
import org.jnyou.eduservice.mapper.EduCourseDescriptionMapper;
import org.jnyou.eduservice.mapper.EduCourseMapper;
import org.jnyou.eduservice.service.EduCourseService;
import org.jnyou.servicebase.exception.IsMeException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 课程 服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-06-07
 */
@Service
public class EduCourseServiceImpl extends ServiceImpl<EduCourseMapper, EduCourse> implements EduCourseService {

    @Autowired
    private EduCourseDescriptionMapper descriptionMapper;

    /**
     * 添加课程基本info
     * @param courseInfoVo
     */
    @Override
    public String saveCourseInfo(CourseInfoVo courseInfoVo) {

        // 1、向课程表添加基本信息
        EduCourse course = new EduCourse();
        BeanUtils.copyProperties(courseInfoVo,course);
        int insert = this.baseMapper.insert(course);
        if(insert == 0){
            // 添加失败
            throw new IsMeException(-1,"添加课程信息失败");
        }

        // 获取添加成功之后的课程id
        String cid = course.getId();

        // 2、向课程简介表添加简介信息
        EduCourseDescription description = new EduCourseDescription();
        description.setDescription(courseInfoVo.getDescription());
        // 课程id和课程简介的id应该一致，他们是一对一的关系
        description.setId(cid);
        int insert1 = descriptionMapper.insert(description);
        if(insert1 == 0){
            throw new IsMeException(-1,"课程简介信息保存失败");
        }
        return cid;
    }
}
