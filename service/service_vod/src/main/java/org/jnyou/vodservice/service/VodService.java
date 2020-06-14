package org.jnyou.vodservice.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * @ClassName yjn
 * @Description: Aliyun视频点播
 * @Author: 夏小颜
 * @Version: 1.0
 **/
public interface VodService {
    /**
     * 上传视频到Aliyun
     * @param file
     * @return
     */
    public String uploadVideoAliyun(MultipartFile file);
}