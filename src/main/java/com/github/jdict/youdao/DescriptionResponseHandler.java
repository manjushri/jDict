/**
 * 
 */
package com.github.jdict.youdao;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.log4j.Logger;

/**
 * TODO TODO
 *
 * @author Yang, Song
 */
public class DescriptionResponseHandler implements ResponseHandler<String> {
	
	private Logger log = Logger.getLogger(DescriptionResponseHandler.class);

	@Override
	public String handleResponse(HttpResponse arg0)
			throws ClientProtocolException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

}
