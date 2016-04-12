package com.amoralesu.sensationcolor;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SeleccionGeneroActivity extends ActionBarActivity {

	Button btnMan ;
	Button btnWomen;
	private static final int CAMERA_PIC_REQUEST = 1337;
	Context context;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_seleccion_genero);
		
		btnMan =(Button)findViewById(R.id.btnMan);
		btnWomen =(Button)findViewById(R.id.btnWomen);
		
		btnMan.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v){
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
			}
		});
		
		btnWomen.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(cameraIntent, CAMERA_PIC_REQUEST);
			}
		});
		
	}
	
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    
		try {
			
			if (requestCode == CAMERA_PIC_REQUEST) {
		    	Bitmap thumbnail = (Bitmap) data.getExtras().get("data");
		    	
		    	//image.setImageBitmap(thumbnail);
		    	DatosImagen.setBitMap(thumbnail);
		    	
		    	 Intent mainIntent = new Intent().setClass(
						 SeleccionGeneroActivity.this, CamaraActivity.class);
	                startActivity(mainIntent);
		    }
			
		} catch (Exception e) {
			Toast toast = Toast.makeText(context, e.getMessage(), Toast.LENGTH_SHORT);
			toast.show();
		} 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.seleccion_genero, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
