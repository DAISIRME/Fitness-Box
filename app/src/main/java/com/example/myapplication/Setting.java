package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

//import com.example.new111.R;

public class Setting extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        TextView tv3 = findViewById(R.id.tv3);
        tv3.setOnClickListener(l);
}
    View.OnClickListener l = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
//            Bundle bundle = new Bundle();
//            bundle.putInt("text",2);
//            intent.putExtras(bundle);
//            setResult(0x11,intent);
            finish();
        }
    };
}
