package org.jnyou.cmsservice.controller;


import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.jnyou.cmsservice.entity.CrmBanner;
import org.jnyou.cmsservice.service.CrmBannerService;
import org.jnyou.commonutils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 首页banner表 前端控制器
 * 后台管理banner
 * </p>
 *
 * @author jnyou
 * @since 2020-06-25
 */
@RestController
@RequestMapping("cmsservice/adminbanner")
@CrossOrigin
public class BannerAdminController {

    @Autowired
    private CrmBannerService bannerService;

    @GetMapping("pageBanner/{page}/{limit}")
    @ApiOperation(value = "获取Banner分页列表")
    public R pageBanner(@ApiParam(name = "page", value = "当前页码", required = true) @PathVariable long page,@ApiParam(name = "limit", value = "每页记录数", required = true) @PathVariable long limit){
        Page<CrmBanner> bannerPage = new Page<>(page,limit);
        bannerService.page(bannerPage,null);
        return R.ok().put("data",bannerPage.getRecords()).put("total",bannerPage.getTotal());
    }

    @ApiOperation(value = "获取Banner")
    @GetMapping("getBannerById/{id}")
    public R get(@PathVariable String id) {
        CrmBanner banner = bannerService.getById(id);
        return R.ok().put("data", banner);
    }

    @ApiOperation(value = "新增Banner")
    @PostMapping("saveBanner")
    public R save(@RequestBody CrmBanner banner) {
        bannerService.save(banner);
        return R.ok();
    }

    @ApiOperation(value = "修改Banner")
    @PutMapping("updateBanner")
    public R updateById(@RequestBody CrmBanner banner) {
        bannerService.updateById(banner);
        return R.ok();
    }

    @ApiOperation(value = "删除Banner")
    @DeleteMapping("removeBannerById/{id}")
    public R remove(@PathVariable String id) {
        bannerService.removeById(id);
        return R.ok();
    }

}

