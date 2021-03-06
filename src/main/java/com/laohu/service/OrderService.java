package com.laohu.service;

import com.laohu.dataobject.OrderMaster;
import com.laohu.dto.OrderDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 * Created by @Author tachai on 2018/1/12.
 *
 * @Email 1206966083@qq.com
 */
public interface OrderService {
    /**创建订单*/
    OrderDTO create(OrderDTO orderDTO);
    /**查询单个订单*/
   OrderDTO findOne(String orderId);
    /**查询订单列表*/
    Page<OrderDTO> findList(String buyerOpenid, Pageable pageable);
    /**取消钉弹*/
    OrderDTO cancel(OrderDTO orderDTO);
    /**完结订单*/
    OrderDTO finish(OrderDTO orderDTO);
    /**支付订单*/
    OrderDTO paid(OrderDTO orderDTO);
    /**查询订单列表*/
    Page<OrderDTO> findList( Pageable pageable);


}
