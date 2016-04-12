package com.amoralesu.sensationcolor;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class CamaraActivity extends ActionBarActivity {

	Button btnAbrirCamara;  
	private static final int CAMERA_PIC_REQUEST = 1337;
	ImageView image;
	Context context;
	Bitmap bitMapEvent;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.activity_camara);
		
		btnAbrirCamara =(Button)findViewById(R.id.btnMan);
		image = (ImageView) findViewById(R.id.imageViewPhoto);
		context = getApplicationContext();
		
		Bitmap bitMap = DatosImagen.getBitMap() ;
		if (bitMap !=null) {
			image.setImageBitmap(bitMap);
		}
		
		bitMapEvent=((BitmapDrawable)image.getDrawable()).getBitmap();
		image.setOnTouchListener(new OnTouchListener(){
		        @Override
		        public boolean onTouch(View v, MotionEvent event){
		        	
		        	try {
		        		int x = (int)event.getX();
			        	int y = (int)event.getY();
			        	
			        	int pixel = bitMapEvent.getPixel(x,y);

			        //then do what you want with the pixel data, e.g
			        	int redValue = Color.red(pixel);
			        	int blueValue = Color.blue(pixel);
			        	int greenValue = Color.green(pixel); 
			        	
			        	String rgb = Integer.toString(redValue)+","+Integer.toString(blueValue)+","+Integer.toString(greenValue);
			        	
			        	Toast toast = Toast.makeText(context,rgb,Toast.LENGTH_SHORT);
						toast.show();

			        	return false;
						
					} catch (Exception e) {
						Toast toast = Toast.makeText(context,e.getMessage(),Toast.LENGTH_SHORT);
						toast.show();
						
						return false;
					}
		        	
		        }
		   });
		
		
	}
	
	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.camara, menu);
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
