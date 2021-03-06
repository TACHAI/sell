package com.laohu.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.laohu.dataobject.OrderDetail;
import com.laohu.enums.OrderStatusEnum;
import com.laohu.enums.PayStatusEnum;
import com.laohu.util.EnumUtil;
import com.laohu.util.serializer.Date2LongSerializer;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by @Author tachai on 2018/1/12.
 *
 * @Email 1206966083@qq.com
 */
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class OrderDTO {
    /**订单id*/
    @Id
    private String orderId;
    /**买家名字*/
    private String buyerName;
    /**买家手机号*/
    private String buyerPhone;
    /**买家地址*/
    private String buyerAddress;
    /**买家微信Openid*/
    private String buyerOpenid;
    /**订单总金额*/
    private BigDecimal orderAmount;
    /**订单状态，默认为新下单*/
    private Integer orderStatus;
    /**支付状态，默认是0未支付*/
    private Integer payStatus;
    /**创建时间*/
    @JsonSerialize(using=Date2LongSerializer.class)
    private Data createTime;
    /**跟新时间*/

    @JsonSerialize(using=Date2LongSerializer.class)
    private Data updateTime;
//    //数据库里面没有service但是需要.这时可以在新建一个包dto数据传输对象
    @Transient
     List<OrderDetail> orderDetailList;
     @JsonIgnore
    public OrderStatusEnum getOrderStatusEnum(){
        return EnumUtil.getByCode(orderStatus,OrderStatusEnum.class);
    }
    @JsonIgnore
    public PayStatusEnum getPayStatusEnum(){
        return EnumUtil.getByCode(payStatus,PayStatusEnum.class);
    }
}
