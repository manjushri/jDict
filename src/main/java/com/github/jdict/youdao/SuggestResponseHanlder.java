/**
 * 
 */
package com.github.jdict.youdao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 *
 * @author Yang, Song
 */
public class SuggestResponseHanlder implements ResponseHandler<List<String>> {
	
	private Logger logger = Logger.getLogger(SuggestResponseHanlder.class);
	
	private Document document;

	/**
	 * 处理suggest请求的response，解析xml成List\<String\>
	 */
	@Override
	public List<String> handleResponse(HttpResponse response)
			throws ClientProtocolException, IOException {
		
		HttpEntity entity = response.getEntity();
		if(entity != null) {
			// 将HttpEntity转换为String
			String xmlContent = EntityUtils.toString(entity);
			
			try {
				document = DocumentHelper.parseText(xmlContent);
				List nodes = document.selectNodes("//title");
				return convert(nodes);
			} catch (DocumentException e) {
				logger.error("解析suggest的response时出现错误，返回的suggest reponse为：" + xmlContent, e);
			}
		} 
		
		logger.warn("suggest响应为null.");
		return null;
	}
	
	private List<String> convert(List<Node> nodes) {
		List<String> titles = new ArrayList<String>();
		for (Node node : nodes) {
			titles.add(node.getText());
		}
		
		return titles;
	}

}
