package com.hhu.springboot_community.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/9
 * @version: 1.0
 */

public class JsonUtil {
    /**
     * 方法描述 对象转JSON
     * @param object
     * @return java.lang.String
     * @author huanghl
     * @date 2020/5/9
     */
    public static String objectToJson(Object object){
        String json = JSON.toJSONString(object);
        return json;
    }

    /**
     * 方法描述 json转对象
     * @param t
     * @return java.lang.Object
     * @author huanghl
     * @date 2020/5/9
     */
    public static  Object jsonTOobject(String  t ,Class c){
        Object object = JSON.parseObject(t,c);
        return object;
    }

    public static JSONObject jsonToJsonObject(String s){

        JSONObject jsonObject = JSON.parseObject(s);
        return jsonObject;
    }
}
