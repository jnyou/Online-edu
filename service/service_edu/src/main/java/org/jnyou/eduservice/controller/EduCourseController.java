package org.jnyou.eduservice.controller;


import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.jnyou.commonutils.R;
import org.jnyou.eduservice.entity.vo.CourseInfoVo;
import org.jnyou.eduservice.service.EduCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 课程 前端控制器
 * </p>
 *
 * @author jnyou
 * @since 2020-06-07
 */
@RestController
@RequestMapping("eduservice/course")
@CrossOrigin
public class EduCourseController {

    @Autowired
    private EduCourseService courseService;

    @PostMapping("addCourseInfo")
    public R addCourseInfo(@ApiParam(name = "courseInfoVo", value = "课程基本信息", required = true) @RequestBody CourseInfoVo courseInfoVo){
        String courseId = courseService.saveCourseInfo(courseInfoVo);
        if(!StringUtils.isEmpty(courseId)){
            return R.ok().message("添加课程信息成功").put("courseId", courseId);
        }else{
            return R.error().message("添加课程信息失败");
        }

    }

}

