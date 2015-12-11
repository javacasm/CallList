package com.example.lt;

import android.app.ListActivity;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.CallLog.Calls;
import android.view.Menu;

public class MainActivity extends ListActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		Uri llamadas=Uri.parse("content://call_log/calls/");
		Cursor c=getContentResolver().query(llamadas, new String[] {Calls.NUMBER,Calls.DATE}, null, null, null);
		//Cursor c=getContentResolver().query(llamadas, null, null, null, null);
		
		setListAdapter(new miAdaptador(this,c));
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
