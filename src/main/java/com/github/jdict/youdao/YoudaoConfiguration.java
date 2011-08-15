/**
 * 
 */
package com.github.jdict.youdao;

/**
 * 有道词典配置类，单例类
 *
 * @author Yang, Song
 */
public class YoudaoConfiguration {
	
	public static YoudaoConfiguration instance() {
		return configuration;
	}
	
	// suggest请求URL
	private StringBuffer suggestRequestURL;
	// instant请求URL
	private StringBuffer instantRequestURL;
	// details请求URL
	private StringBuffer detailsRequestURL;
	
	private static YoudaoConfiguration configuration = new YoudaoConfiguration();
	
	private YoudaoConfiguration() {
		suggestRequestURL.append("http://dict.youdao.com/suggest/tbsuggest.s?type=DESKDICT&num=20&le=eng");
	}
	
}
