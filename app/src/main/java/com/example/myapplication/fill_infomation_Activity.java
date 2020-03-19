package com.example.myapplication;
import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.Nullable;
public class fill_infomation_Activity extends Activity {
        ImageView choose_photo;
        Dialog dialog ;
        int photo  = 0;
        @Override
        protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
        {
                super.onActivityResult(requestCode, resultCode, data);
                Bundle bundle = data.getExtras();
                photo = bundle.getInt("p1");
             if(resultCode==0x111)
             {
                     choose_photo.setImageResource(photo);
                     dialog.dismiss();
             }

        }
        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fill_infomation);
        TextView textView = findViewById(R.id.next_step);
        final EditText editText = findViewById(R.id.input_name);
        choose_photo = findViewById(R.id.Choose_photo);
        choose_photo.setOnClickListener(new View.OnClickListener()
        {
                @Override
                public void onClick(View v)
                {
                        showBottomDialog();
                        Log.e("AC","RRRR");
                }
                });
        textView.setOnClickListener(new View.OnClickListener()
        {
                @Override
                public void onClick(View v)
                {

                        String name  = editText.getText().toString();
                        Intent intent = new Intent(fill_infomation_Activity.this,MainActivity.class);
                        Bundle bundle = new Bundle();
                        bundle.putString("name",name);
                        if(photo==0)
                        {
                                System.out.println("请选择您的头像");
                        }
                        else {
                                bundle.putString("p1",photo+"");
                                intent.putExtras(bundle);
                                startActivity(intent);
                        }


                }
        });
        }
        //弹出照片
        private void showBottomDialog()
        {
                //使用Dialog、设置style
                dialog = new Dialog(this,R.style.DialogTheme);
                //2、设置布局
                View view = View.inflate(this,R.layout.dialog_custom_layout,null);
                dialog.setContentView(view);
                Window window = dialog.getWindow();
                //设置弹出位置
                window.setGravity(Gravity.BOTTOM);
                //设置弹出动画
                window.setWindowAnimations(R.style.main_menu_animStyle);
                //设置对话框大小
                window.setLayout(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT);
                dialog.show();
                dialog.findViewById(R.id.tv_take_photo).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view)
                        {
                                dialog.dismiss();
                        }
                });

                dialog.findViewById(R.id.tv_take_pic).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                Intent intent = new Intent(fill_infomation_Activity.this,Choose_Photo_Activity.class);
                                startActivityForResult(intent,0x111);
                        }
                });

                dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                                dialog.dismiss();
                        }
                });
        }
}
