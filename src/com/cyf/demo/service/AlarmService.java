package com.cyf.demo.service;

import java.util.Date;

import com.cyf.demo.receiver.AlarmReveiver;

import android.annotation.SuppressLint;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;

public class AlarmService extends Service {

	@Override
	public IBinder onBind(Intent intent) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void onCreate() {
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@SuppressLint("NewApi") @Override
	public int onStartCommand(Intent intent, int flags, int startId) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Log.e("TAG", new Date().toString());
				
			}
		}).start();
		//alarm的使用
		AlarmManager alarmManager = (AlarmManager) getSystemService(ALARM_SERVICE);//获得AlarmManager
//		int ahour = 60*60*1000;//一小时
		int ahour = 10*1000;//10s
		long attime = SystemClock.elapsedRealtimeNanos()+ahour;//开机到现在的时间+1小时
		Intent intent2 = new Intent(this,AlarmReveiver.class);
		PendingIntent pi = PendingIntent.getBroadcast(this, 0, intent2, 0);
		alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, attime, pi);
		
		
		return super.onStartCommand(intent, flags, startId);
	}

	@Override
	public void onDestroy() {
		Log.e("TAG", "AlarmService_Destroy");
		super.onDestroy();
	}

}
