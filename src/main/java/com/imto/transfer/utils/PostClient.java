package com.imto.transfer.utils;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.Map;

import org.json.JSONObject;

import com.imto.transfer.dto.Headers;
import com.imto.transfer.response.ResponseHttp;


public class PostClient {

	public static ResponseHttp doPost(String method, String url,  Headers headers, String postData) throws Exception {
		
      	ResponseHttp  rsp = new ResponseHttp();

		
		String result = "";
      try {
    	  
      	  URL obj = new URL(url);
          HttpURLConnection con = (HttpURLConnection) obj.openConnection();

          con.setRequestMethod(method);
          con.setRequestProperty("Content-Type", "application/json");
          if(headers.getAuthorization()!=null)
        	  con.setRequestProperty("signature", headers.getAuthorization());

          // Send post request
          con.setDoOutput(true);
          DataOutputStream wr = new DataOutputStream(con.getOutputStream());
          wr.writeBytes(postData);
          wr.flush();
          wr.close();
          

          int responseCode = con.getResponseCode();
          
          BufferedReader in = null;
          
          System.out.println("responsein headers:: "+con.getHeaderFields());
          
          System.out.println();

          
          if(responseCode == 200) {
          	in = new BufferedReader(
                      new InputStreamReader(con.getInputStream()));
              
          }else{
          	in = new BufferedReader(
                      new InputStreamReader(con.getErrorStream()));
          }
          
          String inputLine;
          StringBuffer response = new StringBuffer();

          while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
          }
          in.close();
          
          
          JSONObject json=new JSONObject();
          Map<String, List<String>> map = con.getHeaderFields();
          for (Map.Entry<String, List<String>> entry : map.entrySet()) {
          	//System.out.println("Key : " + entry.getKey() +
        	  if(entry.getKey()!=null) {
        		  json.put(entry.getKey(),entry.getValue());
        	  }
          }

          //get header by 'key'
         // String server = conn.getHeaderField("Server");
          
          
          result = response.toString()+"####"+json;
      	
	      	rsp.setResponseData(result);
	      	rsp.setResponseCode(responseCode);
	      	
          return rsp;
      }catch(Exception e) {
      	e.printStackTrace();
      }
      
      return rsp;
   }
	
	public static ResponseHttp doGet(String url, String authorization) throws Exception {
		String result = "";
		ResponseHttp rsp = new ResponseHttp();
      try {
      	  URL obj = new URL(url);
          HttpURLConnection con = (HttpURLConnection) obj.openConnection();

          con.setRequestMethod("GET");
          //con.setRequestProperty("access-key", apiKey);
          if(!authorization.isEmpty())
        	  con.setRequestProperty("Authorization", "Bearer " + authorization);
          
          // Send post request
          con.setDoOutput(true);

          int responseCode = con.getResponseCode();
          BufferedReader in = null;
          
          if(responseCode == 200) {
          	in = new BufferedReader(
                      new InputStreamReader(con.getInputStream()));
              
          }else{
          	in = new BufferedReader(
                      new InputStreamReader(con.getErrorStream()));
          }
          
          String inputLine;
          StringBuffer response = new StringBuffer();

          while ((inputLine = in.readLine()) != null) {
              response.append(inputLine);
          }
          in.close();
          
          result = response.toString();
          
          rsp.setResponseCode(responseCode);
          rsp.setResponseData(result);
          return rsp;
      }catch(Exception e) {
      	e.printStackTrace();
      }
      
      return rsp;
   }
	
	
    public static ResponseHttp makePostRequest(String method, String url, Headers headers, String payload) {
    	
    	ResponseHttp result;
		  
		  try {
			  result = PostClient.doPost(method, url, headers, payload);
			 
			  return result;
		  }catch(Exception e) {
			  e.printStackTrace();
			  return null;
		  }
	  }
  
    public static ResponseHttp makeGetRequest(String url, String apiKey) {
    	ResponseHttp result;
		  System.out.println("URL:: " + url);
		  try {
			  result = PostClient.doGet(url, apiKey);
			  
			  return result;
		  }catch(Exception e) {
			  e.printStackTrace();
			  return null;
		  }
	  }
	
}
