package com.basic;

import android.app.Activity;
import android.app.job.JobParameters;
import android.app.job.JobService;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Looper;
import android.util.Log;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class ExampleService extends JobService {

    public static final String TAG ="ExampleService";
    private boolean jobCancelled = false;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public boolean onStartJob(JobParameters params) {
        Log.d(TAG, "onStartJob: ");

        Thread thread = new Thread(){
            public void run(){
                doBackgroundWork(params);
            }
        };

        thread.start();


        jobFinished(params, false);
        return true;
    }

    private void doBackgroundWork(JobParameters params) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String time =  formatter.format(date);

        SharedPreferences.Editor editor = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE).edit();
        editor.putString(MainActivity.TIME, time);

        System.out.print("doBackgroundWork    " +time);
        editor.commit();


    }

    @Override
    public boolean onStopJob(JobParameters params) {
        jobCancelled = true;
        return false;
    }
}
