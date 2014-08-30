package com.example.hackathon;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class quizactivity extends Activity implements OnClickListener{
	
	char[][] opt = new char[5][100];
    
	
	 int ans;
	int[] len = new int[5];
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.quizact);
	
		 TextView helloTxt = (TextView)findViewById(R.id.hellotxt);
	        helloTxt.setText(readTxt());
	        
	     Button option1 = (Button)  findViewById(R.id.opt1); 
	     Button option2 = (Button)  findViewById(R.id.opt2); 
	     Button option3 = (Button)  findViewById(R.id.opt3); 
	     Button option4 = (Button)  findViewById(R.id.opt4);
	
	  	     
	   
	     
	     option1.setText(opt[0], 0, len[1]);
	     option2.setText(opt[1], 0, len[2]);
	     option3.setText(opt[2], 0, len[3]);
	     option4.setText(opt[3], 0, len[4]);
	     
	     option1.setOnClickListener(this);
	     option2.setOnClickListener(this);
	     option3.setOnClickListener(this);
	     option4.setOnClickListener(this);
	     
	}
	
	private String readTxt(){

	     InputStream inputStream = getResources().openRawResource(R.raw.hello);
	     
	     ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
	     
	     int i;
	     int count = 0;
	     int size = 0;
	     
	     
	 
	     
	  try {
	   i = inputStream.read();
	   while (i != -1)
	      {
		   if(count == 0 && i!='$'){
		   byteArrayOutputStream.write(i);
	       i = inputStream.read();
		   }
		   
		   else if(i == '$'){
	    	   
	    	count = count+1;
	    	len[count-1] = size;
	    	size = 0;
	    	//byteArrayOutputStream.write('\n');
	    	i = inputStream.read();
	       }
	       
		   
	     
	       
	       else if(i == '#'){
	    	   
		    	count = count+1;
		    	len[count-1] = size;
		    	size = 0;
		//    	byteArrayOutputStream.write('\n');
		    	i = inputStream.read();
		    	ans = count;
		       }
		   
	       else{
	    	   opt[count-1][size]=(char)i;
	    	   size = size+1;
	    	   i = inputStream.read();
	       }
	    	
	        
	       
	      }
	      inputStream.close();
	  } catch (IOException e) {
	   // TODO Auto-generated catch block
	   e.printStackTrace();
	  }
	  
	     return byteArrayOutputStream.toString();
	    }

	@Override
	public void onClick(View view) {
		// TODO Auto-generated method stub
		TextView status = (TextView) findViewById(R.id.result);
		
		switch(view.getId()) {

		
        case R.id.opt1:
        	if(ans == 1)
        	
        		status.setText("Right");
        	else
        		status.setText("Wrong");
        	
        	break;
        	
        case R.id.opt2:
        	if(ans == 2)
            	
        		status.setText("Right");
        	else
        		status.setText("Wrong");
        	break;
        	
        case R.id.opt3:
        	if(ans == 3)
            	
        		status.setText("Right");
        	else
        		status.setText("Wrong");
        	break;
 	
 	
        case R.id.opt4:
        	if(ans == 4)
            	
        		status.setText("Right");
        	else
        		status.setText("Wrong");
        	break;
 	
        	
        	
	}

}
}
