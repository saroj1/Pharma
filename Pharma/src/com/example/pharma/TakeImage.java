package com.example.pharma;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class TakeImage extends Activity implements  View.OnClickListener {

	ImageButton ib;
	ImageView iv;
	Intent i;
	int cameraResults;
	final static  int cameraData=0;
	Bitmap bmp;

	public void takePhoto() {
		// TODO Auto-generated method stub
		ib=(ImageButton)findViewById(R.id.ibTakePic);
		iv=(ImageView)findViewById(R.id.ivReturnedPic);
		ib.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		i=new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
		startActivityForResult(i,cameraData);
	}
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if(resultCode==RESULT_OK){
			Bundle extras=data.getExtras();
			bmp=(Bitmap)extras.get("data");
			iv.setImageBitmap(bmp);
		}
	}
}
