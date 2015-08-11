package com.cyf.demo.receiver;

import com.cyf.demo.service.AlarmService;

import android.app.AlarmManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReveiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		Intent i = new Intent(context, AlarmService.class);
		context.startService(i);

	}

}
