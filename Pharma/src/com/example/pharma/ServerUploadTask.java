package com.example.pharma;

import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.widget.Toast;

public class ServerUploadTask extends AsyncTask<Void, Void, String>{

	private String webAddressToPost=" http://192.168.2.69:8065/api/upload ";
	//ProgressDialog progress;
	//private ProgressDialog dialog=new ProgressDialog();
	
	
	@Override
	protected void onPreExecute() {
		// TODO Auto-generated method stub
		super.onPreExecute();
		
		//dialog.setMessage("Uploading....");
		
	}
	@Override
	protected String doInBackground(Void... params) {
		
		// TODO Auto-generated method stub
//		try{
//			HttpClient httpClient=new DefaultHttpClient();
//			HttpContext localContext=new BasicHttpContext();
//			HttpPost httpPost=new HttpPost(webAddressToPost);
//			
//			MultipartEntity entity=new MultipartEntity(HttpMultipartMode.B)
//		}
//		
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
