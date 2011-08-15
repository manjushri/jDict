/**
 * 
 */
package com.github.jdict.youdao;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpVersion;
import org.apache.http.ProtocolVersion;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.entity.FileEntity;
import org.apache.http.message.BasicHttpResponse;
import org.apache.http.message.BasicStatusLine;
import org.jmock.Mockery;
import org.jmock.integration.junit4.JMock;
import org.jmock.integration.junit4.JUnit4Mockery;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * TODO TODO
 *
 * @author Yang, Song
 */
public class SuggestResponseHanlderTest {

	
	private HttpEntity entity;
	private HttpResponse httpResponse;
	
	@Before
	public void setUp() {
		entity = new FileEntity(new File("E:\\programming\\myjavafile\\eclipse\\jDict\\src\\test\\resources\\suggest.xml"), "xml");
		StatusLine line = new BasicStatusLine(HttpVersion.HTTP_1_1, 200, "OK");
		httpResponse = new BasicHttpResponse(line);
		httpResponse.setEntity(entity);
	}
	
	
	@Test
	public void testHandleResponse() throws ClientProtocolException, IOException {
		SuggestResponseHanlder responseHanlder = new SuggestResponseHanlder();
		List<String> titles = responseHanlder.handleResponse(httpResponse);
		
		assertEquals(18, titles.size());
		assertEquals("query", titles.get(0));
		assertEquals("query optimize", titles.get(17));
	}

}
