package org.jnyou.eduservice.service.impl;

import com.alibaba.excel.EasyExcel;
import org.jnyou.eduservice.entity.EduSubject;
import org.jnyou.eduservice.entity.excel.SubjectData;
import org.jnyou.eduservice.listener.SubjectListener;
import org.jnyou.eduservice.mapper.EduSubjectMapper;
import org.jnyou.eduservice.service.EduSubjectService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.jnyou.servicebase.exception.IsMeException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;

/**
 * <p>
 * 课程科目 服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-06-06
 */
@Service
public class EduSubjectServiceImpl extends ServiceImpl<EduSubjectMapper, EduSubject> implements EduSubjectService {

    @Override
    public void saveSubject(MultipartFile file,EduSubjectService subjectService) {
        try {
            // 获取上传文件的文件流
            InputStream inputStream = file.getInputStream();
            // 调用方法读取
            EasyExcel.read(inputStream, SubjectData.class,new SubjectListener(subjectService)).sheet().doRead();
        }catch (Exception e){
            e.printStackTrace();
            throw new IsMeException(-1,"添加课程分类失败");
        }
    }
}
