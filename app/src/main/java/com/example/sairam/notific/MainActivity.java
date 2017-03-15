package com.example.sairam.notific;

import android.annotation.TargetApi;
import android.app.AlarmManager;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.NotificationCompat;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TimePicker;

public class MainActivity extends AppCompatActivity {
    //  Button b=(Button)findViewById(R.id.b2);
    public final static String mn="My notification";
    public final static String hw="Hello World!";
    public DatePicker dp;
    public TimePicker tp;
    public int HR,MIN,DAY,DATE,YEAR,MONTH;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button b=(Button)findViewById(R.id.b2);
        b.setOnClickListener(new View.OnClickListener() {

            @TargetApi(Build.VERSION_CODES.N)
            @RequiresApi(api = Build.VERSION_CODES.M)
            @Override
            public void onClick(View v) {
                dp=(DatePicker)findViewById(R.id.datePicker);
                tp=(TimePicker)findViewById(R.id.timePicker);
                DAY=dp.getDayOfMonth();
                MONTH=dp.getMonth();
                YEAR=dp.getYear();
                HR=tp.getHour();
                MIN=tp.getMinute();
                Calendar calendar= null;
                if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.N) {
                    calendar = Calendar.getInstance();
                }
                calendar.set(YEAR,MONTH,DAY,HR,MIN);
                Intent intent=new Intent(getApplicationContext(),NotiClass.class);
                PendingIntent pendingIntent=PendingIntent
                        .getBroadcast(getApplicationContext(),100,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                AlarmManager alarmManager=(AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.setRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis()
                        ,alarmManager.INTERVAL_DAY,pendingIntent);
                //RTC_WAKEUP ensureto wake up device it it is in sleep mode
            }
        });

    }

}
