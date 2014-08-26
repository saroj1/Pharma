package com.example.pharma;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.ParcelFileDescriptor;

public class MyFileContentProvider extends ContentProvider {

	public static final Uri CONTENT_URI=Uri.parse("content://com.example.pharma");
	
	 private static final HashMap<String, String> MIME_TYPES = new HashMap<String, String>();		
	static {
		MIME_TYPES.put(".jpg","image/jpeg");
		MIME_TYPES.put(".jpeg","image/jpeg");

	}
	 @Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		try{
		File mFile=new File(getContext().getFilesDir(),"newImage.jpg");
		if(!mFile.exists()){
			mFile.createNewFile();
		}
		getContext().getContentResolver().notifyChange(CONTENT_URI, null);
		return(true);
		}catch (Exception e){
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Operation not supported");
		
	}

	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		String path=uri.toString();
		for(String extension:MIME_TYPES.keySet()){
			if(path.endsWith(extension)){
				return(MIME_TYPES.get(extension));
			}
		}
		return null;
	}

	@Override
	public ParcelFileDescriptor openFile(Uri uri,String mode) throws FileNotFoundException{
		File f=new File(getContext().getFilesDir(),"newImage.jpg");
		if(f.exists()){
			return(ParcelFileDescriptor.open(f, ParcelFileDescriptor.MODE_READ_WRITE));
			
		}throw new FileNotFoundException(uri.getPath());
	}
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Operation not supported");
		
	}

	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Operation not supported");
	}

	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		throw new RuntimeException("Operation not supported");
	}

}
