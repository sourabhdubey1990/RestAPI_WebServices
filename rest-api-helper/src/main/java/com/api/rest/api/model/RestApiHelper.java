package com.api.rest.api.model;

import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

public class RestApiHelper {
	
	public static RestResponse performGetRequest(String url)
	{
		HttpGet get=new HttpGet(url);
		try(CloseableHttpClient client= HttpClientBuilder.create().build();
				CloseableHttpResponse response=client.execute(get)) 
			{	
				ResponseHandler<String> body =new BasicResponseHandler();
				RestResponse restResponse= new RestResponse(response.getStatusLine().getStatusCode(), body.handleResponse(response) );
				/*System.out.println(restResponse.toString());*/
				return restResponse;
				
			} catch (Exception e) {
				
				throw new RuntimeException(e.getMessage(), e);
			} 
		
	}

}
