package com.example.pharma;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.mime.MultipartEntityBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
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
		
		// TODO Auto-generated method stub
		try{
			CloseableHttpClient httpClient=HttpClients.createDefault();
			
			HttpPost httpPost=new HttpPost("http://192.168.2.69:8065/api/upload");
			
			MultipartEntityBuilder builder= MultipartEntityBuilder.create();
			builder.addTextBody
		}
	
		return null;
		
		
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
