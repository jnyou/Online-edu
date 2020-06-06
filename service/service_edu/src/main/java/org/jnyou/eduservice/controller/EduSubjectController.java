package org.jnyou.eduservice.controller;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.jnyou.commonutils.R;
import org.jnyou.eduservice.service.EduSubjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p>
 * 课程科目 前端控制器
 * </p>
 *
 * @author jnyou
 * @since 2020-06-06
 */
@RestController
@RequestMapping("eduservice/subject")
@CrossOrigin
@Api(description = "课程管理")
public class EduSubjectController {

    @Autowired
    private EduSubjectService subjectService;

    /**
     * 通过读取excel添加分类
     * @param mpf
     * @return
     */
    @PostMapping("addSubjectCategory")
    @ApiOperation(value = "添加分类")
    public R addSubjectCategory(MultipartFile file){
        subjectService.saveSubject(file,subjectService);
        return R.ok();
    }

}

