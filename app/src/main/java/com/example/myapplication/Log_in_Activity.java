package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

//import com.example.new111.R;

public class Log_in_Activity extends Activity {
    EditText[] et = new EditText[2];
    TextView tv;
    final OpenDataBase opendatabase = new OpenDataBase(Log_in_Activity.this, "db_table", null, 1);
    String name1;
    String password1;
    TextView name;
    TextView password;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_log_in);
            et[0] = findViewById(R.id.account);
            et[1] = findViewById(R.id.password);
            et[0].setOnClickListener(click);
            et[1].setOnClickListener(click);
            tv = findViewById(R.id.Regiter);
            ImageView Log_in = findViewById(R.id.log_in);
            name = findViewById(R.id.account);
            password = findViewById(R.id.password);

            tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Log_in_Activity.this, Register_Activity.class);
                startActivityForResult(intent, 0x111);
                }
        });
            Log_in.setOnClickListener(log_in);
    }
    //登录
    View.OnClickListener log_in = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            name1 = name.getText().toString();
            password1 = password.getText().toString();
            Cursor cursor = opendatabase.getReadableDatabase().query("db_table" ,null,"name=?", new String[]{name1}, null, null, null);
            cursor.moveToNext();
            if( cursor != null && cursor.getCount()>0 ){
                Log.e("aa","正常");
                if (password1.equals(cursor.getString(cursor.getColumnIndex("password")))) {
                    Toast.makeText(Log_in_Activity.this, "登录成功", Toast.LENGTH_SHORT).show();
                    Log.e("aa","正常");
                    Intent intent = getIntent();
                    Bundle bundle = new Bundle();
                    bundle.putString("name",name1);
                    bundle.putString("password",password1);
                    intent.putExtras(bundle);
                    int rw = 0x112;
                    setResult(rw,intent);
                    finish();
                } else {
                    Toast.makeText(Log_in_Activity.this, "账号或密码错误", Toast.LENGTH_SHORT).show();
                }
           }
            else {
                Log.e("me","error");
            }
        }
    };
             View.OnClickListener click = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText t = (EditText) v;
                t.setText("");
            }
        };


}