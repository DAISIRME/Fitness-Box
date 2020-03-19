package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.new111.R;

import java.util.Calendar;

public class StartAcitivity extends AppCompatActivity {
    Long currentTime = Calendar.getInstance().getTime().getTime();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_acitivy);
        Log.e("Time",Long.toString(currentTime));
        Log.e("Time",Long.toString(Calendar.getInstance().getTime().getTime()));
        Log.e("Time",Long.toString(Calendar.getInstance().getTime().getTime()-currentTime));
        Thread thread = new Thread(){
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    Log.e("error","失败");
                }
                Intent intent = new Intent(StartAcitivity.this,choose_sex_activity.class);
                startActivity(intent);
                StartAcitivity.this.finish();
            }
        };
        thread.start();
    }


}
