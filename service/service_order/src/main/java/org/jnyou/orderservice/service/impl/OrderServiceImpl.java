package org.jnyou.orderservice.service.impl;

import org.jnyou.orderservice.entity.Order;
import org.jnyou.orderservice.mapper.OrderMapper;
import org.jnyou.orderservice.service.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 订单 服务实现类
 * </p>
 *
 * @author jnyou
 * @since 2020-08-09
 */
@Service
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

}
