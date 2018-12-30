package com.api.rest.api.model;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.apache.http.client.HttpResponseException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestApiHelper {
	
	public static RestResponse performGetRequest(String url,Map<String,String> headers)
	{
		try {
			return performGetRequest(new URI(url),headers);
		} catch (URISyntaxException e) {

			throw new RuntimeException(e.getMessage(), e);
		}
		
	}
	
	public static RestResponse performGetRequest(URI uri,Map<String,String> headers)
	{
		HttpGet get = new HttpGet(uri);
		if(headers!=null) {
			for(String str:headers.keySet())
				get.addHeader(str, headers.get(str));
		}
		
		CloseableHttpResponse response=null;
		
		try (CloseableHttpClient client = HttpClientBuilder.create().build();
				) {
			response = client.execute(get);
			ResponseHandler<String> body = new BasicResponseHandler();
			return new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response));
		} catch (Exception e) {
			if(e instanceof HttpResponseException)
				return new RestResponse(response.getStatusLine().getStatusCode(), e.getMessage());
			throw new RuntimeException(e.getMessage(), e);
		}
	}
}
