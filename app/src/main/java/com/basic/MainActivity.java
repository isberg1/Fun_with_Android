package com.basic;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String DATABASE_NAME = "countries";
    private MyAsyncHelperClass db;
    private Handler mainHandler = new Handler();

    public static String TIME = "time";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);



        // start a toast
        Button btn = findViewById(R.id.onCreate_Button);
        btn.setOnClickListener((view) -> {
            Toast.makeText(getBaseContext(),"from onCreate Function", Toast.LENGTH_SHORT).show();
        });

        // set floating action button to open browser
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener((view)-> {

            String url = "http://www.vg.no";
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setData(Uri.parse(url));
            startActivity(intent);

                }

        );

        startDB();
        updateUI();

    }

    private void startDB() {
        db = new MyAsyncHelperClass(this, DATABASE_NAME);
        final Country a = new Country(1,"someCountry", "someCapital", 1984);
        //db.dropTable();
        db.insert(a);

        TextView te = findViewById(R.id.textView);
        te.setText(db.get1ByID(1).toString());
    }

    public void function_Button(View view) {
        // make snackbar
        Snackbar snackbar = Snackbar.make(view,"snackbar text", Snackbar.LENGTH_LONG);
        // make button in snackbar
        snackbar.setAction("explode", (view1)-> {
            Snackbar snackbar1 = Snackbar.make(view1, "aaaaa",Snackbar.LENGTH_SHORT);
            snackbar1.show();
        });
        snackbar.setActionTextColor(Color.YELLOW);
        snackbar.show();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void startService(View view) {

        ComponentName componentName = new ComponentName(this, ExampleService.class);
        JobInfo info = new JobInfo.Builder(123, componentName)
                .setPersisted(true)
                .setPeriodic(15 * 60 * 1000).build();


        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        int result = jobScheduler.schedule(info);

        if (result == JobScheduler.RESULT_SUCCESS){
            Log.d("startService", "startService: " + "jobScheduler sucs");
        }
        else {
            Log.d("startService", "startService: " + "jobScheduler failed");
        }

        

        updateUI();


    }

    public void stopService(View view) {
        Intent stop = new Intent(this, ExampleService.class);
        stopService(stop);
        JobScheduler jobScheduler = (JobScheduler) getSystemService(JOB_SCHEDULER_SERVICE);
        jobScheduler.cancel(123);
        Log.d("stopService", "stopService: ");

    }


    public void updateUI(){
        SharedPreferences prefs = getSharedPreferences("MY_PREFS_NAME", MODE_PRIVATE);
        String restoredText = prefs.getString(MainActivity.TIME, "00000000000");


        TextView tv = findViewById(R.id.serviceTextView);
        tv.setText(restoredText);
    }


}
