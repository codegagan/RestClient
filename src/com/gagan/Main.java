package com.gagan;

import com.gagan.client.*;

public class Main {

	private static String url = "https://localhost:8443/students";
	public static void main(String[] args) {
		HttpClient client = new HttpClient();		
		System.out.println(client.get(url));
		
		
		System.out.println(client.post(url, "{\r\n" + 
				"  \"id\": \"4\",\r\n" + 
				"  \"name\": \"Gagan\",\r\n" + 
				"  \"course\": \"Javascript\"\r\n" + 
				"}"));
		
		System.out.println(client.get(url));
		
		System.out.println(client.put(url, "{\r\n" + 
				"  \"id\": \"4\",\r\n" + 
				"  \"name\": \"Gagan\",\r\n" + 
				"  \"course\": \"Angular\"\r\n" + 
				"}"));
		
		System.out.println(client.get(url + "/4"));
		
	}
}
