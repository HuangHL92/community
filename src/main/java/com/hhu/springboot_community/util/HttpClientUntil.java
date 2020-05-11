package com.hhu.springboot_community.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

/**
 * @description:
 * @author: huanghl
 * @createDate: 2020/5/8
 * @version: 1.0
 */

public class HttpClientUntil {

    /**
     * 方法描述 通过HttpClient发送post请求并返回数据
     *
     * @param url
     * @return java.lang.String
     * @author huanghl
     * @date 2020/5/9
     */
    public static String getResultByPost(String url, Object object) {
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpPost post = new HttpPost(url);
        CloseableHttpResponse response = null;
        try {
            StringEntity s = new StringEntity(JsonUtil.objectToJson(object));
            s.setContentEncoding("UTF-8");
            s.setContentType("application/json");//发送json数据需要设置contentType
            post.setEntity(s);
            response = httpClient.execute(post);
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity entity = response.getEntity();
                String result = EntityUtils.toString(entity, "UTF-8");
                System.out.println(result);
                return result;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 方法描述 HttpClient 发送get请求并返回数据
     * @param url
     * @param object
     * @return java.lang.String
     * @author huanghl
     * @date 2020/5/9
     */
    public static  String getResultByGet(String url){
        CloseableHttpClient httpClient = HttpClients.createDefault();
        HttpGet get =new HttpGet(url);
        CloseableHttpResponse response = null;
        try {
         response = httpClient.execute(get);
         int code = response.getStatusLine().getStatusCode();
            if(code == 200){
                HttpEntity entity = response.getEntity();
                String s = EntityUtils.toString(entity, "UTF-8");
                return s;
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
