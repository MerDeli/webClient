package com.example.util;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.InputStreamRequestEntity;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

public class SoapUtil {
    /**
     * <p>Description: 根据请求报文，请求服务地址获取 响应报文
     *
     * @param requestSoap    请求报文
     * @param serviceAddress 响应报文
     * @param charSet        字符集
     * @param contentType    类型
     * @return map封装的 服务器响应参数和返回报文.PS:statusCode :200正常响应。responseSoap：响应报文
     * <p>thinking: </p>
     * @author huoge
     * </span>
     */

    public static Map<String, Object> getResponseSoap(String requestSoap, String serviceAddress, String charSet, String contentType) {
        String responseSoap = "";
        Map<String, Object> resultmap = new HashMap<String, Object>();
        PostMethod postMethod = new PostMethod(serviceAddress);
        byte[] b = new byte[0];
        try {
            b = requestSoap.getBytes(charSet);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        InputStream is = new ByteArrayInputStream(b, 0, b.length);
        RequestEntity re = new InputStreamRequestEntity(is, b.length, contentType);
        postMethod.setRequestEntity(re);
        HttpClient httpClient = new HttpClient();
        int statusCode = 0;
        try {
            statusCode = httpClient.executeMethod(postMethod);
            resultmap.put("statusCode", statusCode);
        } catch (IOException e) {
            throw new RuntimeException("执行http请求失败", e);
        }
        if (statusCode == 200) {
            try {
                responseSoap = postMethod.getResponseBodyAsString();
                resultmap.put("responseSoap", responseSoap);
            } catch (IOException e) {
                throw new RuntimeException("获取请求返回报文失败", e);
            }
        } else {
            throw new RuntimeException("请求失败：" + statusCode);
        }
        return resultmap;
    }
}
