package com.flyinghippo.simplpass;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        EditText password = (EditText) findViewById(R.id.txtPassword);
        password.setVisibility(View.INVISIBLE);
        
        Spinner spinner = (Spinner) findViewById(R.id.spnProfile);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.test_profilelist, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new OnItemSelectedListener() {
        	public void onNothingSelected(AdapterView<?> parent) 
        	{
        		EditText password = (EditText) findViewById(R.id.txtPassword);
        		password.setVisibility(View.INVISIBLE);
        	}

        	@Override
        	public void onItemSelected(AdapterView<?> arg0, View arg1, int arg2,
        			long arg3) {
        		EditText password = (EditText) findViewById(R.id.txtPassword);
        		
        		Spinner spinner = (Spinner) arg0;
        		if(((String)spinner.getSelectedItem()).equals("Two"))
        			password.setVisibility(View.VISIBLE);
        		
        	}
		});
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    
    
}


