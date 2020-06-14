package org.jnyou.vodservice.service.impl;

import com.aliyun.vod.upload.impl.UploadVideoImpl;
import com.aliyun.vod.upload.req.UploadStreamRequest;
import com.aliyun.vod.upload.resp.UploadStreamResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.jnyou.servicebase.exception.IsMeException;
import org.jnyou.vodservice.service.VodService;
import org.jnyou.vodservice.utils.ConstantPropertiesUtil;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName yjn
 * @Description: 视频点播
 * @Author: 夏小颜
 * @Version: 1.0
 **/
@Service
@Slf4j
public class VodServiceImpl implements VodService {

    @Override
    public String uploadVideoAliyun(MultipartFile file) {
        try {
            // 上传文件的输入流
            InputStream inputStream = file.getInputStream();
            // 上传文件的原始名称
            String originalFilename = file.getOriginalFilename();
            // 上传之后显示的名称
            String title = originalFilename.substring(0, originalFilename.lastIndexOf("."));

            UploadStreamRequest request = new UploadStreamRequest(
                    ConstantPropertiesUtil.ACCESS_KEY_ID,
                    ConstantPropertiesUtil.ACCESS_KEY_SECRET,
                    title, originalFilename, inputStream);

            UploadVideoImpl uploader = new UploadVideoImpl();
            UploadStreamResponse response = uploader.uploadStream(request);

            //如果设置回调URL无效，不影响视频上传，可以返回VideoId同时会返回错误码。
            // 其他情况上传失败时，VideoId为空，此时需要根据返回错误码分析具体错误原因
            String videoId = response.getVideoId();
            if (!response.isSuccess()) {
                String errorMessage = "阿里云上传错误：" + "code：" + response.getCode() + ", message：" + response.getMessage();
                log.warn(errorMessage);
                if(StringUtils.isEmpty(videoId)){
                    throw new IsMeException(-1, errorMessage);
                }
            }

            return videoId;
        } catch (IOException e) {
            throw new IsMeException(-1, "online vod 服务上传失败");
        }
    }
}