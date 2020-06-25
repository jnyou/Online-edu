package org.jnyou.cmsservice.service;

import org.jnyou.cmsservice.entity.CrmBanner;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 首页banner表 服务类
 * </p>
 *
 * @author jnyou
 * @since 2020-06-25
 */
public interface CrmBannerService extends IService<CrmBanner> {

    /**
     * 查询所有的轮播图
     * @return
     */
    List<CrmBanner> getAllBanner();

}
