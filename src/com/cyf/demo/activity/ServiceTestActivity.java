package com.cyf.demo.activity;

import com.cyf.demo.R;
import com.cyf.demo.service.AlarmService;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class ServiceTestActivity extends Activity implements OnClickListener {
	
	private Intent i;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.servicetest_layout);
		
		initview();
		
	}
	
	private void initview() {
		findViewById(R.id.servicetest_startservice).setOnClickListener(this);
		
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
	}
	
	@Override
	protected void onDestroy() {
		try {
			stopService(i);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		super.onDestroy();
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.servicetest_startservice:
			i = new Intent(this, AlarmService.class);
			startService(i);
			
			
			break;

		default:
			break;
		}
		
	}

}
