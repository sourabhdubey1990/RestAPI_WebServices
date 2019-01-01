package com.api.rest.api.helper;

import java.io.File;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.FileEntity;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import com.api.rest.api.model.RestApiHelper;
import com.api.rest.api.model.RestResponse;

public class GetRequest {

	public static void main(String[] args) {
		
		/*RestResponse response=RestApiHelper.performGetRequest("http://localhost:8080/laptop-bag/webapi/prompt/ping/Hello",null);
		System.out.println(response.toString());*/
		
		String jsonBody="{"+
				"\"BrandName\": \"Asus\","+
				"\"Features\": {"+
					"\"Feature\": [\"16GB RAM\","+
					"\"1TB Hard Drive\","+
					"\"Display Blank\"]"+
				"},"+
				"\"Id\": 132,"+
				"\"LaptopName\": \"Sourabh\""+
			"}";
		/*HttpPost post= new HttpPost("http://localhost:8080/laptop-bag/webapi/prompt/add");*/
		/*try(CloseableHttpClient client=  HttpClientBuilder.create().build();) {
			post.addHeader("Content-Type", "application/json");
			post.addHeader("Accept", "application/json");
			StringEntity data=new StringEntity(jsonBody, ContentType.APPLICATION_JSON);
			post.setEntity(data);
			File file=new File("TestDataFile");
			FileEntity data=new FileEntity(file, ContentType.APPLICATION_JSON);
			post.setEntity(data);
			CloseableHttpResponse response=client.execute(post);
			ResponseHandler<String> handler=new BasicResponseHandler();
			RestResponse restResponse=new RestResponse(response.getStatusLine().getStatusCode(), handler.handleResponse(response));
			System.out.println(restResponse.toString());
			
			
		} catch (Exception e) {

			e.printStackTrace();
		}*/
		Map<String, String> headers=new LinkedHashMap<>();
		headers.put("Content-Type", "application/json");
		headers.put("Accept", "application/json");
		RestResponse response=RestApiHelper.performPostRequest("http://localhost:8080/laptop-bag/webapi/prompt/add", jsonBody, headers);
		System.out.println(response.toString());
		

	}

}
