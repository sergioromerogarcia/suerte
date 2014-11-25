package com.example.suerte;

import java.util.Random;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

/** Classe que define la Activity que recibe los datos de la primera pantalla.
 * Cuando recibe los datos, compara el valor introducido por el usuario con un random generado 
 * de forma aleatoria. 
 * **/

public class Activity2 extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//Fichero xml que define la interfaz grafica
		setContentView(R.layout.activity2);
		
		//Define los TextView i los relaciona con el id del fichero activity2.xml
	    TextView text = (TextView) findViewById(R.id.textView1);
	    TextView text2 = (TextView) findViewById(R.id.textView2);	
	    
		//Recuperar los parametros que vienen de la Activity1 
		Bundle bundle = getIntent().getExtras();
	    String number_string = bundle.getString("number");
	    
	    //Parsea el valor a int
	    int number = Integer.parseInt(number_string);
	    
	    //Genera un valor aleatorio entre 1 i 10
	    int random = randInt(1,10);
	    
	    //Compara el valor introducido por el usuario con el aleatorio
	    boolean lucky = compare(number, random);
	    
	    //Muestra un texto u otro según el resultado
	    if (lucky == true){
	    	text.setText("Bien!! Acertado!!!!!");
	    	text.setTextColor(Color.GREEN);
	    }   else {
	    	text.setText("Fallo! ");
	    	text.setTextColor(Color.RED);
	    }
	   
	    StringBuilder str = new StringBuilder();
	    str.append("El numero correcto era: " + random + "\n\n");
	    
	    str.append("El numero introducido fue: " + number);
	    
        text2.setText(str);
        
	}
	
	
	
	/** Compara dos numeros enteros **/
	private boolean compare(int user_number, int random_num){
		
		if (user_number == random_num){
			return true;
		} else {
			return false;
		}
		
	}

	/** Genera numeros aleatorios enteros entre dos valores pasados por parametro **/
	public static int randInt(int min, int max) {

	    Random rand = new Random();
	    int randomNum = rand.nextInt((max - min) + 1) + min;

	    return randomNum;
	}
	
	


}
