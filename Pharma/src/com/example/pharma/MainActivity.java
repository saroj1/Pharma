package com.example.pharma;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

		
		ImageButton ib1,ib2;
		ImageView iv;
		Intent i;
		int cameraResults;
		final static  int cameraData=0;
		Bitmap bmp;
		EditText etxt1,etxt2,etxt3;
		boolean check;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		ib1=(ImageButton)findViewById(R.id.ibSubmit);
		ib1.setVisibility(View.INVISIBLE);
		iv=(ImageView)findViewById(R.id.ivReturnedPic);
		etxt1=(EditText)findViewById(R.id.et1);
		etxt2=(EditText)findViewById(R.id.et2);
		etxt3=(EditText)findViewById(R.id.et3);
		
		
		//ib2.setOnClickListener(View new.);
		btnClick();
		
//		TakeImage camera=new TakeImage();
//		camera.takePhoto();
	}

	private void btnClick() {
		// TODO Auto-generated method stub
		ib2=(ImageButton)findViewById(R.id.ibTakePic);
		ib2.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(i,cameraData);
			}
		});
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras();
			bmp=(Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
			ib1.setVisibility(View.VISIBLE);
			ib2.setVisibility(View.INVISIBLE);
			submit();
		}
	}
//	@Override
//	public boolean onCreateOptionsMenu(Menu menu) {
//		// Inflate the menu; this adds items to the action bar if it is present.
//		getMenuInflater().inflate(R.menu.main, menu);
//		return true;
//	}
//
//	@Override
//	public boolean onOptionsItemSelected(MenuItem item) {
//		// Handle action bar item clicks here. The action bar will
//		// automatically handle clicks on the Home/Up button, so long
//		// as you specify a parent activity in AndroidManifest.xml.
//		int id = item.getItemId();
//		if (id == R.id.action_settings) {
//			return true;
//		}
//		return super.onOptionsItemSelected(item);
//	}

	private void submit() {
		
		// TODO Auto-generated method stub
		ib1=(ImageButton)findViewById(R.id.ibSubmit);
		ib1.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				int duration=Toast.LENGTH_LONG;
				// TODO Auto-generated method stub
				etxt1=(EditText)findViewById(R.id.et1);
			String	name=etxt1.getText().toString();
			etxt2=(EditText)findViewById(R.id.et2);
			String add=etxt2.getText().toString();
			etxt3=(EditText)findViewById(R.id.et3);
			String mobile=etxt3.getText().toString();
			
			
//			if(name.trim().endsWith("")){
//				Toast toast=Toast.makeText(getBaseContext(), "Please enter your name", duration);
//				toast.show();} 
			if(TextUtils.isEmpty(name)) {
			  Toast toast=  Toast.makeText(getBaseContext(), "Please enter your Name ", duration);
			  toast.show();
			    return;
			}else if(TextUtils.isEmpty(add)){
				 Toast toast=  Toast.makeText(getBaseContext(), "Please enter your Address ", duration);
				  toast.show();
				return;
			}
		else if(mobile.length()<10 || mobile.length()>10){
				check=false;
				 Toast toast=  Toast.makeText(getBaseContext(), "Please enter valid Mobile No ", duration);
				  toast.show();
				return;
			}
		else {
			new ServerUploadTask().execute();
//			Toast toast=Toast.makeText(getBaseContext(), "something", duration);
//			toast.show();
		}
			
			
			}
		});
	}
}
