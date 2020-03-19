package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;

//import com.example.new111.R;

public class New_Log_in_Activity extends Activity {
    Button log_in_button;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_log_in);
        log_in_button = findViewById(R.id.log_in_button);
        log_in_button.setOnClickListener(log_in);

    }
    View.OnClickListener log_in = new View.OnClickListener()
    {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(New_Log_in_Activity.this,choose_sex_activity.class);
            startActivity(intent);
        }
    };
}
