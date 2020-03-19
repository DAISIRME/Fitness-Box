package com.example.myapplication;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;

//import com.example.new111.R;

public class Register_Activity extends Activity {
    EditText[] et = new EditText[2];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final OpenDataBase opendatabase = new OpenDataBase(Register_Activity.this,"db_table",null,1);
        TextView textView = findViewById(R.id.Regiter);
        et[0] = findViewById(R.id.account);
        et[1] = findViewById(R.id.password);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String str1 = et[0].getText().toString();
                String str2 = et[1].getText().toString();
                if(str1.equals("")||str2.equals(""))
                {
                    Toast.makeText(Register_Activity.this,"输入的账号或密码为空",Toast.LENGTH_SHORT).show();
                }
                else
                    {
                    InsertData(opendatabase.getReadableDatabase(),str1,str2);
                    Toast.makeText(Register_Activity.this,"注册成功",Toast.LENGTH_SHORT).show();
                    Cursor cursor = opendatabase.getReadableDatabase().query("db_table", new String[]{"name","password"}, "name=?", new String[]{"1"}, null, null, null);
                    if(cursor.getCount()>0)
                    {
                        Log.e("me","非空");
                    }
                    else
                        {
                        Log.e("me","空");
                        }
                    cursor.close();
                    finish();
                    }
            }
        });
    }
    public void InsertData(SQLiteDatabase sqLiteDatabase,String name,String password)
    {
        ContentValues contentValues = new ContentValues();
        contentValues.put("name",name);
        contentValues.put("password",password);
        sqLiteDatabase.insert("db_table",null,contentValues);
    }
}
