package com.example.sairam.notific;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

/**
 * Created by sai ram on 15-03-2017.
 */

public class NotiClass extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        NotificationManager notificationManager= (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
        Intent taketoapp=new Intent(context,NotifiAcc.class);
        taketoapp.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        /*It will ensure thaat if the
        * app is already open
        * it will open the window directed by notification*/
        PendingIntent pendingIntent=PendingIntent.getActivity(context,100,taketoapp,PendingIntent.FLAG_UPDATE_CURRENT);
        NotificationCompat.Builder builder=new NotificationCompat.Builder(context)
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentText("Hi veenu")
                .setContentText("You are so beautiful")
                .setAutoCancel(true);//to clear noti on clicking on it
        notificationManager.notify(100,builder.build());
    }
}
