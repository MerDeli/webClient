package com.example;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class Client {
//    public static void main(String agrs[]) {
//        HelloWorldService helloservice = new HelloWorldService();
//        HelloWorld helloworld = helloservice.getHelloWorldPort();
//
//
//        String returnStr = helloworld.sayHelloWorldFrom("China");
//        System.out.print(returnStr);
//    }
//public static void main(String[] args) {
//    StringBuilder soap=new StringBuilder(); //构造请求报文
//    soap.append(" <SOAP-ENV:Envelope xmlns:SOAP-ENV=\"http://schemas.xmlsoap.org/soap/envelope/\"> ");
//    soap.append(" <SOAP-ENV:Header>");
////    soap.append(" <TransactionID xmlns=\"http://localhost:8889/dsmp/schemas/\">0001194337258</TransactionID>");
//    soap.append(" </SOAP-ENV:Header>");
//    soap.append(" <SOAP-ENV:Body>");
//    soap.append(" <from>getMsg</from>");
////    soap.append(" <SyncOrderRelationReq xmlns=\"http://localhost:8889/dsmp/schemas/\">");
////    soap.append(" <Version>2.0.0</Version>");
////    soap.append(" <MsgType>SyncOrderRelationReq</MsgType>");
////    soap.append(" <Send_Address>");
////    soap.append(" <DeviceType>0</DeviceType>");
////    soap.append(" <DeviceID>0001</DeviceID>");
////    soap.append(" </Send_Address>");
////    soap.append(" <Dest_Address>");
////    soap.append(" <DeviceType>400</DeviceType>");
////    soap.append(" <DeviceID>0</DeviceID>");
////    soap.append(" </Dest_Address>");
////    soap.append(" <FeeUser_ID>");
////    soap.append(" <UserIDType>1</UserIDType>");
////    soap.append(" <MSISDN>15210699288</MSISDN>");
////    soap.append(" <PseudoCode></PseudoCode>");
////    soap.append(" <UserIDType>1</UserIDType>>");
////    soap.append(" <MSISDN>15210699288</MSISDN>");
////    soap.append(" <PseudoCode></PseudoCode>");
////    soap.append(" </DestUser_ID>");
////    soap.append(" <ActionID>2</ActionID>");
////    soap.append(" <ActionReasonID>1</ActionReasonID>");
////    soap.append(" <SPID>901995</SPID>");
////    soap.append(" <SPServiceID>MOBILEYB</SPServiceID>");
////    soap.append(" <AccessMode>3</AccessMode>");
////    soap.append(" <FeatureStr></FeatureStr>");
//    soap.append(" </getMsg>");
//    soap.append(" </SOAP-ENV:Body>");
//    soap.append(" </SOAP-ENV:Envelope>");
//    String requestSoap=soap.toString();
//
////        String serviceAddress="http://localhost:8889/dsmp/dsmp.WSDL";   //服务地址(将XXXX替换成自己项目的地址)
//    String serviceAddress="http://localhost:9000/HelloWorld?wsdl";   //服务地址(将XXXX替换成自己项目的地址)
//    String charSet="utf-8";
//    String contentType="text/xml; charset=utf-8";
//
////               <span style="font-size:24px;"> //第一步：调用方法getResponseSoap。返回响应报文和状态码</span>
//
//    Map<String,Object> responseSoapMap= SoapUtil.getResponseSoap(requestSoap, serviceAddress, charSet, contentType);
//    Integer statusCode=(Integer)responseSoapMap.get("statusCode");
//    if(statusCode==200){
//        String responseSoap=(String)responseSoapMap.get("responseSoap");
//        String targetNodeName="isSuccess";
////                <span style="font-size:24px;">  //第二步：调用strXmlToDocument方法。
//        //将字符串类型的XML的响应报文 转化成Docunent结构文档</span>
//        Document doc= XMLUtil.strXmlToDocument(responseSoap);
////                  <span style="font-size:24px;"> //第三步：调用getValueByElementName方法。递归获得目标节点的值</span>
//        String result= XMLUtil.getValueByElementName(doc,targetNodeName);
//        if(!StringUtils.isEmpty(result)){
//            System.out.println(result);
//        }
//        else{
//            System.out.println("没有此节点或者没有值！");}
//    }
//    else{
//        System.out.println("请求失败！");
//    }
//}

    public static void main(String[] args) throws IOException {
////        String wsdl = "http://localhost:9000/SyncOrderRelation?wsdl";
////        String wsdl = "http://test.zlxue.com/front/expo-front/front/edu-interface/services/Sy";
////        String wsdl = "http://zlxue.zlxue.com//front/expo-front/front/edu-interface/services/Sy";
////        String wsdl = "http://zlxue.zlxue.com/edu-plus/Sy";
////        String wsdl = "http://test.zlxue.com/edu-plus/Sy";
//        String wsdl = "http://localhost:8891/services/Sy";
//        int timeout = 10000;
//        StringBuffer sb = new StringBuffer("");
//        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        sb.append("<soap:Envelope "
//                + "xmlns:api='http://www.monternet.com/dsmp/schemas/' "
//                + "xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' "
//                + "xmlns:xsd='http://www.w3.org/2001/XMLSchema' "
//                + "xmlns:soap='http://schemas.xmlsoap.org/soap/envelope/'>");
//        sb.append("<soap:Body>");
//        sb.append("<api:getMsg>");
//        sb.append("<api:SyncOrderRelationReq>");
//        sb.append("<accessMode>123</accessMode>");
//        sb.append("<version>123</version>");
//        sb.append("<feeUser_ID>");
//        sb.append("<userIDType>456</userIDType>");
//        sb.append("</feeUser_ID>");
//        sb.append("</api:SyncOrderRelationReq>");
//        sb.append("</api:getMsg>");
//        sb.append("</soap:Body>");
//        sb.append("</soap:Envelope>");

//        String wsdl = "http://test.zlxue.com/front/expo-front/front/edu-interface/services/Sy?wsdl";
        String wsdl = "http://localhost:8891/services/Sy";
        int timeout = 10000;
        StringBuffer sb = new StringBuffer("");
        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        sb.append("<SOAP-ENV:Envelope "
                + "xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'>");
        sb.append("<SOAP-ENV:Header>");
        sb.append("<TransactionID "
                + "xmlns='http://www.monternet.com/dsmp/schemas/'>");
        sb.append("0001194337258</TransactionID>");
        sb.append("</SOAP-ENV:Header>");
        sb.append("<SOAP-ENV:Body>");
        sb.append("<SyncOrderRelationReq xmlns='http://www.monternet.com/dsmp/schemas/'>");
        sb.append("<Version>2.0.0</Version>");
        sb.append("<MsgType>SyncOrderRelationReq</MsgType>");
        sb.append("<Send_Address>");
        sb.append("<DeviceType>0</DeviceType>");
        sb.append("<DeviceID>0001</DeviceID>");
        sb.append("</Send_Address>");
        sb.append("<Dest_Address>");
        sb.append("<DeviceType>400</DeviceType>");
        sb.append("<DeviceID>0</DeviceID>");
        sb.append("</Dest_Address>");
        sb.append("<FeeUser_ID>");
        sb.append("<UserIDType>1</UserIDType>");
        sb.append("<MSISDN>15210699288</MSISDN>");
        sb.append("<PseudoCode></PseudoCode>");
        sb.append("</FeeUser_ID>");
        sb.append("<DestUser_ID>");
        sb.append("<UserIDType>1</UserIDType>");
        sb.append("<MSISDN>15210699288</MSISDN>");
        sb.append("<PseudoCode></PseudoCode>");
        sb.append("</DestUser_ID>");
        sb.append("<ActionID>2</ActionID>");
        sb.append("<ActionReasonID>1</ActionReasonID>");
        sb.append("<SPID>901995</SPID>");
        sb.append("<SPServiceID>MOBILEYB</SPServiceID>");
        sb.append("<AccessMode>3</AccessMode>");
        sb.append("<FeatureStr></FeatureStr>");
        sb.append("</SyncOrderRelationReq>");
        sb.append("</SOAP-ENV:Body>");
        sb.append("</SOAP-ENV:Envelope>");


//        String wsdl = "http://localhost:8891/services/Sy";
//        int timeout = 10000;
//        StringBuffer sb = new StringBuffer("");
//        sb.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
//        sb.append("<SOAP-ENV:Envelope "
//                + "xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/'>");
//        sb.append("<SOAP-ENV:Body>");
////        sb.append("<getMsg>");
//        sb.append("<SyncOrderRelationReq>");
//        sb.append("<accessMode>123</accessMode>");
//        sb.append("<version>123</version>");
//        sb.append("<feeUser_ID>");
//        sb.append("<userIDType>456</userIDType>");
//        sb.append("</feeUser_ID>");
//        sb.append("</SyncOrderRelationReq>");
////        sb.append("</getMsg>");
//        sb.append("</SOAP-ENV:Body>");
//        sb.append("</SOAP-ENV:Envelope>");

        // HttpClient发送SOAP请求
        System.out.println("HttpClient 发送SOAP请求");
        HttpClient client = new HttpClient();
        PostMethod postMethod = new PostMethod(wsdl);
        // 设置连接超时
        client.getHttpConnectionManager().getParams().setConnectionTimeout(timeout);
        // 设置读取时间超时
        client.getHttpConnectionManager().getParams().setSoTimeout(timeout);
        // 然后把Soap请求数据添加到PostMethod中
        RequestEntity requestEntity = new StringRequestEntity(sb.toString(), "text/xml", "UTF-8");
        //设置请求头部，否则可能会报 “no SOAPAction header” 的错误
        postMethod.setRequestHeader("SOAPAction","");
        // 设置请求体
        postMethod.setRequestEntity(requestEntity);
        int status = client.executeMethod(postMethod);
        // 打印请求状态码
        System.out.println("status:" + status);
        // 获取响应体输入流
        InputStream is = postMethod.getResponseBodyAsStream();
        // 获取请求结果字符串
        String result = IOUtils.toString(is);
        System.out.println("result: " + result);

        // HttpURLConnection 发送SOAP请求
        System.out.println("HttpURLConnection 发送SOAP请求");
        URL url = new URL(wsdl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();

        conn.setRequestProperty("Content-Type", "text/xml; charset=utf-8");
        conn.setRequestMethod("POST");
        conn.setUseCaches(false);
        conn.setDoInput(true);
        conn.setDoOutput(true);
        conn.setConnectTimeout(timeout);
        conn.setReadTimeout(timeout);

        DataOutputStream dos = new DataOutputStream(conn.getOutputStream());
        dos.write(sb.toString().getBytes("utf-8"));
        dos.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
        String line = null;
        StringBuffer strBuf = new StringBuffer();
        while ((line = reader.readLine()) != null) {
            strBuf.append(line);
        }
        dos.close();
        reader.close();

        System.out.println(strBuf.toString());
    }
}