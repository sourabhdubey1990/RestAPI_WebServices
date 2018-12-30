package com.api.rest.api.helper;

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
		RestResponse response=RestApiHelper.performGetRequest(url);
		System.out.println(response.toString());
		Assert.assertEquals(HttpStatus.SC_OK, response.getStatuscode());
		Assert.assertEquals("Hi! Hello", response.getMessageBody());

	}
	
	@Test
	public void testGetAll()
	{
		String url="http://localhost:8080/laptop-bag/webapi/prompt/all";
		RestResponse response=RestApiHelper.performGetRequest(url);
		Assert.assertTrue("Expected status code is not present", (HttpStatus.SC_OK== response.getStatuscode())|| (HttpStatus.SC_NO_CONTENT== response.getStatuscode()));
		System.out.println(response.toString());
		
	}
	
	@Test
	public void testFindWithID()
	{
		String url="http://localhost:8080/laptop-bag/webapi/prompt/find/128";
		RestResponse response=RestApiHelper.performGetRequest(url);
		Assert.assertTrue("Expected status code is not present", (HttpStatus.SC_OK== response.getStatuscode())|| (HttpStatus.SC_NOT_FOUND== response.getStatuscode()));
		System.out.println(response.toString());
	}	
}
