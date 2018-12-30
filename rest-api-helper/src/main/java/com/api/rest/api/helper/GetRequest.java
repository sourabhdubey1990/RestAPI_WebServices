package com.api.rest.api.helper;

import java.io.IOException;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.api.rest.api.model.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class GetRequest {

	public static void main(String[] args) {
		
		RestResponse response=RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/prompt/ping/Hello");
		response.toString();
		

	}

}
