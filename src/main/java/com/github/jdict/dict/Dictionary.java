/**
 * 
 */
package com.github.jdict.dict;

/**
 * TODO TODO
 *
 * @author Yang, Song
 */
public interface Dictionary {

	/**
	 * 渐进提示
	 * @param keyWord
	 * @return
	 */
	public String suggest(String keyWord);
	
	/**
	 * 即时搜索
	 * @param keyWord
	 * @return
	 */
	public String instant(String keyWord);
	
	/**
	 * 详细信息
	 * @param keyWord
	 * @return
	 */
	public String details(String keyWord);
	
	/**
	 * 设置观察者
	 * @param observer
	 */
	public void setObserver(Observer observer);
}
