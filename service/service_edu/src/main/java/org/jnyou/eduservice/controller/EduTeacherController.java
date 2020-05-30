package org.jnyou.eduservice.controller;


import org.jnyou.eduservice.entity.EduTeacher;
import org.jnyou.eduservice.service.EduTeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 讲师 前端控制器
 * </p>
 *
 * @author jnyou
 * @since 2020-05-30
 */
@RestController
@RequestMapping("/eduservice/teacher")
public class EduTeacherController {

    @Autowired
    private EduTeacherService teacherService;

    /**
     * 查询所有讲师  测试整体集成 rest风格
     * @return
     */
    @GetMapping("findAll")
    public List<EduTeacher> findAllTeacher(){
        return teacherService.list(null);
    }

    /**
     * 逻辑删除讲师信息
     * @param id
     * @return
     */
    @DeleteMapping({"id"})
    public boolean logicDel(@PathVariable Long id){
        return teacherService.removeById(id);
    }


}

