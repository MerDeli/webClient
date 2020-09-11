package com.example.util;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.xml.sax.InputSource;

import java.io.IOException;
import java.io.StringReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 解析返回soap报文，获取目标节点值
 * @author Wtao
 * @date 2019-06-04
 */
public class XMLUtil {

    /**
     * 将字符串类型的XML 转化成Docunent文档结构
     * @param parseStrXml 待转换的XML字符串
     * @return
     */
    public static Document strXmlToDocument(String parseStrXml) {
        StringReader read = new StringReader(parseStrXml);
        //创建新的输入源SAX 解析器将使用 InputSource 对象来确定如何读取 XML 输入
        InputSource source = new InputSource(read);
        //创建一个新的SAXBuilder
        // 新建立构造器
        SAXBuilder sb = new SAXBuilder();
        Document doc = null;
        try {
            doc = sb.build(source);
        } catch (JDOMException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return doc;

    }

    /**
     * 根据目标节点名获取值
     * @param doc 文档结构
     * @param finalNodeName 节点名
     * @return
     */
    public static String getValueByElementName(Document doc, String finalNodeName) {
        Element root = doc.getRootElement();
        HashMap<String, Object> map = new HashMap<String, Object>();
        Map<String, Object> resultmap = getChildAllText(doc, root, map);
        String result = (String) resultmap.get(finalNodeName);
        return result;
    }

    /**
     * 递归获得子节点的值
     * @param doc 文档结构
     * @param e 节点元素
     * @param resultmap 递归将值存入map中
     * @return
     */
    public static Map<String, Object> getChildAllText(Document doc, Element e, HashMap<String, Object> resultmap) {
        if (e != null) {
            //如果存在子节点
            if (e.getChildren() != null) {
                List<Element> list = e.getChildren();
                //循环输出
                for (Element el : list) {
                    //如果子节点还存在子节点，则递归获取
                    if (el.getChildren().size() > 0) {
                        getChildAllText(doc, el, resultmap);
                    } else {
                        //将叶子节点值压入map
                        resultmap.put(el.getName(), el.getTextTrim());
                    }
                }
            }
        }
        return resultmap;
    }

    public static void main(String[] args) {
        String str = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns2:sendtransactioninformationResponse xmlns:ns2=\"http://webservice.information.xqx.com/\"><response></response></ns2:sendtransactioninformationResponse></soap:Body></soap:Envelope>";
        Document document = strXmlToDocument(str);
        String response = getValueByElementName(document, "response");
        System.out.println("---->"+response);
    }
}
