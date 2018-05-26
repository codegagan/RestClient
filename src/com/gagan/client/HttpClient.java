package com.gagan.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.util.stream.Collectors;

public class HttpClient {
	
	
private URLConnection connect(String path) {
	URLConnection connection = null;
	try {
		URL url = new URL(path);
		connection = url.openConnection();
		return connection;
	} catch (MalformedURLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	return connection;
}

	public String get(String url) {
		URLConnection connection = connect(url);
		String response = null;
		try {
			HttpURLConnection httpConnection = ((HttpURLConnection)connection);
			httpConnection.setRequestMethod("GET");
			
			try (BufferedReader br = new BufferedReader(new InputStreamReader(httpConnection.getInputStream()))) {
				 response = br.lines().collect(Collectors.joining(System.lineSeparator()));
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return response;
	}
	
	public int post(String url, String body) {
		URLConnection connection = connect(url);
		try {
			HttpURLConnection httpConnection = ((HttpURLConnection)connection);
			httpConnection.setRequestMethod("POST");
			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.setDoOutput(true);
			try (OutputStream out = httpConnection.getOutputStream()){
				out.write(body.getBytes());
				return httpConnection.getResponseCode();
			}catch(IOException e) {
				e.printStackTrace();
			}
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}
	
	public int put(String url, String body) {
		URLConnection connection = connect(url);
		try {
			HttpURLConnection httpConnection = ((HttpURLConnection)connection);
			httpConnection.setRequestMethod("PUT");
			httpConnection.setRequestProperty("Content-Type", "application/json");
			httpConnection.setDoOutput(true);
			try (OutputStream out = httpConnection.getOutputStream()){
				out.write(body.getBytes());
				return httpConnection.getResponseCode();
			}catch(IOException e) {
				e.printStackTrace();
			}
			
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		return 0;
	}
	
}
