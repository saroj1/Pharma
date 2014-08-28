package com.example.pharma;

import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.os.ParcelFileDescriptor;
import android.provider.MediaStore;
import android.provider.MediaStore.Audio.Media;
import android.provider.MediaStore.MediaColumns;
import android.support.v7.app.ActionBarActivity;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {

	 private final int CAMERA_RESULT = 1;
		ImageButton ib1,ib2;
		ImageView iv;
		Intent intent;
		int cameraResults;
		final static  int cameraData=0;
		Bitmap bmp;
		EditText etxt1,etxt2,etxt3;
		boolean check;
		String mCurrentPhotoPath;
private String selectedImagePath="";
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
				
				//PackageManager pm=getPackageManager();
				//intent=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				//intent.putExtra(MediaStore.EXTRA_OUTPUT, MyFileContentProvider.CONTENT_URI);
				//startActivityForResult(i,cameraData);
				//startActivityForResult(intent, CAMERA_RESULT);
				intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				if(intent.resolveActivity(getPackageManager())!=null){
					//create the file where the photo should go
					File photoFile=null;
					try{
						photoFile=createImageFile();
					}catch(IOException e){
						e.printStackTrace();
					}
					//continue only if the file was successfully created
					if(photoFile!=null){
						intent.putExtra(android.provider.MediaStore.EXTRA_OUTPUT, Uri.fromFile(photoFile));
						 System.out.println(Uri.fromFile(photoFile));
						startActivityForResult(intent, CAMERA_RESULT);
					}
					
				}
			}

			private File createImageFile() throws IOException{
				// TODO Auto-generated method stub
				
				//creating a file name
				String timeStamp=new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
				String imageFileName="JPEG_"+timeStamp+"_";
				//creating a path to store image
				File storageDir=Environment.getExternalStoragePublicDirectory(
						Environment.DIRECTORY_PICTURES);
			
				File image=File.createTempFile(imageFileName,/*prefix*/
						".jpg"/*suffix*/
						,storageDir /*directory*/);
				
				System.out.println(image);							
				// save a file path 
				mCurrentPhotoPath="file:"+image.getAbsolutePath();
				return image;
						
			} 
		});
		
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		iv=(ImageView)findViewById(R.id.ivReturnedPic);
		if(resultCode==RESULT_OK && requestCode==CAMERA_RESULT && null!=data){
			
			/* old method 
			Bundle extras=data.getExtras();
			bmp=(Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);*/
			
			
			//iv.setImageBitmap(BitmapFactory.decodeFile(mCurrentPhotoPath));
			
			Bitmap bitmap=BitmapFactory.decodeFile(mCurrentPhotoPath);
			iv.setImageBitmap(bitmap);
			ib1.setVisibility(View.VISIBLE);
			ib2.setVisibility(View.INVISIBLE);
			submit();
		}
	}

	
	
	

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
			
			

			//checking fields are filled or not
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
		//	new ServerUploadTask().execute();
			Toast toast=Toast.makeText(getBaseContext(), "something", duration);
			toast.show();
		}
			
			
			}
		});
	}
}
