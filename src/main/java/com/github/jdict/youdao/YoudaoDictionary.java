/**
 * 
 */
package com.github.jdict.youdao;

import java.io.IOException;
import java.util.List;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;

import com.github.jdict.dict.AbstractDictionary;

/**
 * TODO TODO
 *
 * @author Yang, Song
 */
public class YoudaoDictionary extends AbstractDictionary {
	
	private HttpClient httpClient;
	private HttpGet httpGet;
	
	private ResponseHandler<String> descriptionResponseHanlder;
	private ResponseHandler<List<String>> suggestResponseHanlder;
	
	private static final String DETAIL_REQUEST_URL = "";
	private static final String SIMPLE_QEQUEST_URL = "";
	private static final String SUGGEST_REQUEST_URL = "";
	
	private StringBuffer detailRequestURL;
	private StringBuffer simpleRequestURL;
	private StringBuffer suggestRequestURL;
	
	public YoudaoDictionary() {
		httpClient = new DefaultHttpClient();
		
		descriptionResponseHanlder = new DescriptionResponseHandler();
		suggestResponseHanlder = new SuggestResponseHanlder();
		
		detailRequestURL = new StringBuffer();
		simpleRequestURL = new StringBuffer();
		suggestRequestURL = new StringBuffer();
	}

	@Override
	public String detailDescribe(String queryWord) throws ClientProtocolException, IOException {
		detailRequestURL.append(queryWord);
		httpGet = new HttpGet(detailRequestURL.toString());
		
		return httpClient.execute(httpGet, descriptionResponseHanlder);
	}

	@Override
	public String simpleDescribe(String queryWord) throws ClientProtocolException, IOException {
		simpleRequestURL.append(queryWord);
		httpGet = new HttpGet(simpleRequestURL.toString());
		
		return httpClient.execute(httpGet, descriptionResponseHanlder);
	}

	@Override
	public List<String> suggest(String queryWord) throws ClientProtocolException, IOException {
		suggestRequestURL.append(queryWord);
		httpGet = new HttpGet(suggestRequestURL.toString());
		
		
		return httpClient.execute(httpGet, suggestResponseHanlder);
	}

}
