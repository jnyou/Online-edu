package org.jnyou.statisticsservice.service;

import org.jnyou.statisticsservice.entity.StatisticsDaily;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 网站统计日数据 服务类
 * </p>
 *
 * @author jnyou
 * @since 2020-08-22
 */
public interface StatisticsDailyService extends IService<StatisticsDaily> {

    /**
     * 统计某天的注册人数
     * @param date
     * @return
     * @Author jnyou
     * @Date 2020/8/22
     */
    void createStatisticsByDay(String date);
}
