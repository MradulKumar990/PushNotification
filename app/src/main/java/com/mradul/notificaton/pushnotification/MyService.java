package com.mradul.notificaton.pushnotification;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

/**
 * Created by shekhar on 1/21/17.
 */

public class MyService extends Service {

  @Override
  public int onStartCommand(Intent intent, int flags, int startId) {
    return Service.START_NOT_STICKY;
  }

  @Override
  public IBinder onBind(Intent intent) {
    return null;
  }

  @Override
  public void onDestroy() {
    Intent intent = new Intent("com.android.shekharkg");
    Log.e(">>Service Destroy", "Called braodcast");
    sendBroadcast(intent);
  }
}