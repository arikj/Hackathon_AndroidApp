package com.example.hackathon;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity implements OnClickListener{

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	Button btn1 = (Button) findViewById(R.id.wordbtn);
	Button btn2 = (Button) findViewById(R.id.jumblebtn);
	Button btn3 = (Button) findViewById(R.id.quizbtn);

	 btn1.setOnClickListener(this);
	 btn2.setOnClickListener(this);
	 btn3.setOnClickListener(this);
	 
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}
	
	@Override

	public void onClick(View view) {
		// TODO Auto-generated method stub
		
		 Intent i;

	        switch(view.getId()) {

	        case R.id.wordbtn:

	            i = new Intent(getApplicationContext(), wordactivity.class);
	                    startActivity(i);   
	            break;

	        case R.id.jumblebtn:

	            i = new Intent(getApplicationContext(), jumbleactivity.class);
	                    startActivity(i);   
	            break;
	            
	        case R.id.quizbtn:
	            i = new Intent(getApplicationContext(), quizactivity.class);
	                    startActivity(i);   
	            break;    
	        }
		
	}

}
