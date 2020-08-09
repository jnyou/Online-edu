package org.jnyou.orderservice.service.impl;

import org.jnyou.orderservice.entity.PayLog;
import org.jnyou.orderservice.mapper.PayLogMapper;
import org.jnyou.orderservice.service.PayLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 支付日志表 服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-08-09
 */
@Service
public class PayLogServiceImpl extends ServiceImpl<PayLogMapper, PayLog> implements PayLogService {

}
