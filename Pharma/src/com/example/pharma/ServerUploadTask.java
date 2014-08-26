package com.example.pharma;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.HttpMultipartMode;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.entity.mime.content.FileBody;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;

public class ServerUploadTask extends AsyncTask<Void, Void, String>{

	private String webAddressToPost=" http://192.168.2.69:8065/api/upload ";
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		
		
	}
	@Override
	protected String doInBackground(Void... params) {
		String result="";
		
		
		// TODO Auto-generated method stub
		try{
			HttpClient httpClient=new DefaultHttpClient();
			
			HttpPost httpPost=new HttpPost("http://46.137.213.164:8112/api/upload");
			
			FileBody bin=new FileBody(new File("newImage"));
			
			MultipartEntityBuilder builder= MultipartEntityBuilder.create();
			builder.setMode(HttpMultipartMode.BROWSER_COMPATIBLE);
			
			builder.addTextBody("name","name");
			builder.addTextBody("address","add");
			builder.addTextBody("phone_number","mobile");
			builder.addPart("image",bin);
			
			HttpEntity entity=builder.build();
			httpPost.setEntity(entity);
			
			HttpResponse response=httpClient.execute(httpPost);
			
			InputStream inputStream=null;
			inputStream=response.getEntity().getContent();
			
			if(inputStream!=null)
				result=convertInputStreamToStrng(inputStream);
			else
				result="Did not work";
			return result;
			
	        }
	        catch(Exception e)
	        {
	            e.printStackTrace();
	        }
		
	
		return null;
		
		
	}
	private String convertInputStreamToStrng(InputStream inputStream)throws IOException {
		// TODO Auto-generated method stub
		  BufferedReader bufferedReader = new BufferedReader(
	                new InputStreamReader(inputStream));
	        String line = "";
	        String result = "";
	        while ((line = bufferedReader.readLine()) != null)
	            result += line;

	        inputStream.close();
	        return result;
	}
	@Override
	protected void onPostExecute(String result) {
		// TODO Auto-generated method stub
		super.onPostExecute(result);
		
	}

	@Override
	protected void onProgressUpdate(Void... values) {
		// TODO Auto-generated method stub
		super.onProgressUpdate(values);
	}

	
	}
