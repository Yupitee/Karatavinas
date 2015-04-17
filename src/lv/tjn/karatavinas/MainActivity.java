package lv.tjn.karatavinas;


import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	int pareizi;
	String vards;
	int garums;
	String minejums;
	String jaunais;
	int kludas = 0;
	String burts; //gribetos char kka godigi sakot 
	char b;
	String lieta;
	String kljudaini;
	int burtusk;
	String minetie;
	@Override
	
	
	
	
	protected void onCreate(Bundle savedInstanceState) {
		
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		minetie = "";
		kljudaini = " ";
		vards = ielasaVarduNoFaila(); 
		garums = vards.length();
		minejums = "";
		for(int simbols = 0; simbols < garums; simbols++){
			minejums = minejums + "-";
		}
		kludas = 0;
		pareizi = 0;
		burtusk = vards.length();
		
		
		TextView minamaisView = (TextView)findViewById(R.id.textVards);
		minamaisView.setText(minejums);
	}
	private String ielasaVarduNoFaila() {
		   String nolasitaisVards = "";

		   try{
		      BufferedReader lasa= new BufferedReader(
		      new InputStreamReader(getAssets().open("vardi.txt")));
		      String rinda=lasa.readLine();
		      int rinduSkaits=Integer.parseInt(rinda);
		      int n=new Random().nextInt(242)+1;
		      for( int i=0;i<n;i++ ) {
		         rinda = lasa.readLine(); 
		      }
		      nolasitaisVards = rinda;
		      lasa.close();
		   }catch(Exception e){
		      nolasitaisVards = "ERROR";
		   }
		   return nolasitaisVards;
		}

	public void mineet(View view){
		
		EditText et = (EditText)findViewById(R.id.ievade);
		if (et.getText().toString().trim().length() == 0){
			//lieta
		}else{
			burts = et.getText().toString().toUpperCase();
			et.setText("");
			burts = burts.toUpperCase();
			b = burts.charAt(0);

			if(minetie.contains(burts)){
				//huehuehue
			}else{
				if(vards.contains(burts)){
					jaunais = "";
					minetie = minetie + burts;
					pareizi++;
					for(int i = 0; i<garums ; i++){
						if(vards.charAt(i) == b){
							jaunais = jaunais + b;
						}else{
							jaunais = jaunais + minejums.charAt(i);
						}
					}
					minejums = jaunais;
					if(minejums.contains("-") == false){
						Button minet = (Button) findViewById(R.id.buttonMinet);
						minet.setClickable(false);
						minet.setText("TU UZVAREJI!");
					}
				}else{
					if(kljudaini.contains(burts)){
						//huehueheu
					}else{
						kludas++;
						kljudaini = kljudaini + " " + b;
						TextView cumba = (TextView)findViewById(R.id.textView1);
						cumba.setText(kljudaini);
						
						TextView kludinas = (TextView)findViewById(R.id.kludas);
						lieta = "" + kludas;
						kludinas.setText(lieta);
						if(kludas == 15){
							Button minet = (Button) findViewById(R.id.buttonMinet);
							minet.setClickable(false);
							minet.setText("TU MANI PIEVILI");
							TextView atbilde = (TextView)findViewById(R.id.atbilde);
							atbilde.setText(vards);
						}
					}
				}
			}
		}
		TextView minamaisView = (TextView)findViewById(R.id.textVards);
		minamaisView.setText(minejums);
	}
	
	public void reset(View view){
		Intent intent = new Intent(this.getApplicationContext(),MainActivity.class);
		startActivity(intent);
		finish();
	}
	 	


}
