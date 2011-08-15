/**
 * 
 */
package com.github.jdict.dict;

import java.io.IOException;
import java.util.List;
import java.util.Observable;

import org.apache.http.client.ClientProtocolException;

/**
 * TODO TODO
 *
 * @author Yang, Song
 */
public abstract class AbstractDictionary extends Observable {
	
	// 渐进提示词
	private List<String> suggestWords;
	// 词描述
	private String description;
	/**
	 * 查询渐进提示词汇
	 * @param queryWord
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public abstract List<String> suggest(String queryWord) throws ClientProtocolException, IOException;
	/**
	 * 词的简单信息
	 * @param queryWord
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public abstract String simpleDescribe(String queryWord) throws ClientProtocolException, IOException;
	/**
	 * 词的详细信息
	 * @param queryWord
	 * @return
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 */
	public abstract String detailDescribe(String queryWord) throws ClientProtocolException, IOException;
	
	public void instant(String queryWord) {
		try {
			suggestWords = suggest(queryWord);
			description = simpleDescribe(queryWord);
			this.setChanged();
			this.notifyObservers();
		} catch (ClientProtocolException cpe) {
			
		} catch (IOException ioe) {
			
		}
		
	}
	public void detail(String queryWord) throws ClientProtocolException, IOException {
		description = detailDescribe(queryWord);
		
		this.setChanged();
		this.notifyObservers();
	}
}
