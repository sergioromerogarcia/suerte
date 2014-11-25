package com.example.suerte;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Clase principal de la aplicación. Muestra un TextView, un EditText i un
 * Button. Se introducen datos en el EditText i cuando se clica el bot��n, se
 * envian los datos a otra pantalla.
 * **/

public class Activity1 extends Activity {

	private EditText edit_text;

	// cuando se crea la Activity se llama al m��todo OnCreate()
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		Log.d("SUERTE", "onCreate()");
		// Fichero xml que define la interfaz grafica
		setContentView(R.layout.activity1);

		// Define el EditText i lo relaciona con el id del fichero activity.xml
		edit_text = (EditText) findViewById(R.id.editText1);

		// Define el Button i lo relaciona con el id del fichero activity.xml
		final Button button = (Button) findViewById(R.id.button1);

		// Cuando se clica el bot��n se llama al metodo send()
		button.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				send();
			}
		});

	}
	@Override
	protected void onStart() {
		super.onStart();
		Log.d("SUERTE","onStart()");
	};

	@Override
	protected void onPause() {
		super.onPause();
		Log.d("SUERTE","onPause()");
	};
			
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Log.d("SUERTE","onDestroy()");		
	};
	
	@Override
	protected void onStop() {
		super.onStop();
		Log.d("SUERTE","onStop()");		
	};
	
	@Override
	protected void onRestart() {
		super.onRestart();
		Log.d("SUERTE","onRestart()");
	};
	
	@Override
	protected void onResume() {
		super.onResume();
		Log.d("SUERTE", "onResume()");
	};

	/** Envia los datos del editText a la segunda pantalla (Activity2) **/
	public void send() {
		Intent i = new Intent(Activity1.this, Activity2.class);
		i.putExtra("number", edit_text.getText().toString());
		startActivity(i);
	}

	/** Define el men�� de la pantalla. En esta aplicaci��n no se usa. **/
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity1, menu);
		return true;
	}

}
