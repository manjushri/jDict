/**
 * 
 */
package com.github.jdict.dict;

/**
 * 观察者类
 *
 * @author Yang, Song
 */
public interface Observer {
	
	/**
	 * 更新内容
	 * @param content
	 */
	public void updateContent(String content);
	
	/**
	 * 刷新
	 */
	public void refresh();
}
