package com.api.rest.api.helper;

import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpStatus;
import org.junit.Test;
import com.api.rest.api.model.RestApiHelper;
import com.api.rest.api.model.RestResponse;
import org.junit.Assert;

public class TestGetMethod {

	@Test
	public void testGetPingAlive()
	{
		String url="http://localhost:8080/laptop-bag/webapi/prompt/ping/Hello";
		RestResponse response=RestApiHelper.performGetRequest(url,null);
		System.out.println(response.toString());
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatuscode());
		Assert.assertEquals("Hi! Hello", response.getMessageBody());

	}
	
	@Test
	public void testGetAll()
	{
		String url="http://localhost:8080/laptop-bag/webapi/prompt/all";
		Map<String,String> headers=new HashMap<>();
		headers.put("accept", "application/json");
		RestResponse response=RestApiHelper.performGetRequest(url,headers);
		Assert.assertTrue("Expected status code is not present", (HttpStatus.SC_OK== response.getStatuscode())|| (HttpStatus.SC_NO_CONTENT== response.getStatuscode()));
		System.out.println(response.toString());
		
	}
	
	@Test
	public void testFindWithID()
	{
		String url="http://localhost:8080/laptop-bag/webapi/prompt/find/128";
		Map<String,String> headers=new HashMap<>();
		headers.put("accept", "application/json");
		RestResponse response=RestApiHelper.performGetRequest(url,headers);
		Assert.assertTrue("Expected status code is not present", (HttpStatus.SC_OK== response.getStatuscode())|| (HttpStatus.SC_NOT_FOUND== response.getStatuscode()));
		System.out.println(response.toString());
	}	
}
