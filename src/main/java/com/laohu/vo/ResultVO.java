package com.laohu.vo;

import lombok.Data;

/**
 * Created by @Author tachai on 2018/1/11.
 *
 * @Email 1206966083@qq.com
 */

/**
 * http请求返回的最外层对象
 */
@Data
public class ResultVO<T> {
    /**错误码*/
    private Integer code;
    /**提示的信息*/
    private String msg;
    /**返回的数据*/
    private T data;
}
