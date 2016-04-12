package com.amoralesu.sensationcolor;

import android.graphics.Bitmap;

/*
 * Clase static para almacenar datos de manera 
 * temporal en la aplicacion 
 * */
 public class DatosImagen {
	 
	private static Bitmap bitMap ;
	
	public static Bitmap getBitMap() {
		return bitMap;
	}
	public static void setBitMap(Bitmap paramBitMap) {
		bitMap = paramBitMap;
	}
	 
}
 