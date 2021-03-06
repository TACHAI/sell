package com.laohu.util;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by @Author tachai on 2018/1/24.
 *
 * @Email 1206966083@qq.com
 */
public class CookieUtil {
    /**
     * 设置cookie
     * @param response
     * @param name
     * @param value
     * @param maxAge
     */
    public static void set(HttpServletResponse response,String name,String value,int maxAge){
        Cookie cookie=new Cookie(name,value);
        cookie.setPath("/");
        cookie.setMaxAge(maxAge);
        response.addCookie(cookie);
    }

    /**
     * 返回cookie
     * @param request
     * @param taken
     * @return
     */
    public static Cookie get(HttpServletRequest request, String taken){
        Map<String,Cookie> cookieMap= readCookieMap(request);
        if(cookieMap.containsKey(taken)){
            return cookieMap.get(taken);
        }else{
            return null;
        }

    }

    /**
     * 将cookie封装成map
     * @param request
     * @return
     */
    private static Map<String,Cookie> readCookieMap(HttpServletRequest request){
        Map<String,Cookie> cookieMap=new HashMap<>();
        Cookie[] cookies=request.getCookies();
        if(cookies!=null){
            for(Cookie cookie:cookies){
                cookieMap.put(cookie.getName(),cookie);
            }
        }
        return cookieMap;
    }
}
