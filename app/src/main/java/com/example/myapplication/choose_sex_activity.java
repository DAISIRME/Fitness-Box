package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.datepicker.CustomDatePicker;

//import com.example.new111.R;

public class choose_sex_activity extends AppCompatActivity {
    private TextView mTvSelectedDate, mTvSelectedTime;
    private CustomDatePicker mDatePicker, mTimerPicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_sex_activity);
//        findViewById(R.id.ll_date).setOnClickListener(choose);
//        mTvSelectedDate = findViewById(R.id.tv_selected_date);
//        initDatePicker();
//        findViewById(R.id.ll_time).setOnClickListener(choose);
//        mTvSelectedTime = findViewById(R.id.tv_selected_time);
//        initTimerPicker();
        findViewById(R.id.sex_button).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(choose_sex_activity.this,fill_infomation_Activity.class);
                startActivity(intent);
            }
        });
    }
//    View.OnClickListener choose = new View.OnClickListener(){
//        @Override
//        public void onClick(View v) {
//            switch (v.getId()) {
//                case R.id.ll_date:
//                    // 日期格式为yyyy-MM-dd
//                    mDatePicker.show(mTvSelectedDate.getText().toString());
//                    break;
//                case R.id.ll_time:
//                    // 日期格式为yyyy-MM-dd HH:mm
//                    mTimerPicker.show(mTvSelectedTime.getText().toString());
//                    break;
//            }
//        }
//    };
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        mDatePicker.onDestroy();
//    }
//
//    private void initDatePicker() {
//        long beginTimestamp = DateFormatUtils.str2Long("2009-05-01", false);
//        long endTimestamp = System.currentTimeMillis();
//        mTvSelectedDate.setText(DateFormatUtils.long2Str(endTimestamp, false));
//        // 通过时间戳初始化日期，毫秒级别
//        mDatePicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
//            @Override
//            public void onTimeSelected(long timestamp) {
//                mTvSelectedDate.setText(DateFormatUtils.long2Str(timestamp, false));
//            }
//        }, beginTimestamp, endTimestamp);
//        // 不允许点击屏幕或物理返回键关闭
//        mDatePicker.setCancelable(false);
//        // 不显示时和分
//        mDatePicker.setCanShowPreciseTime(false);
//        // 不允许循环滚动
//        mDatePicker.setScrollLoop(false);
//        // 不允许滚动动画
//        mDatePicker.setCanShowAnim(false);
//    }
//    private void initTimerPicker() {
//        String beginTime = "2018-10-17 18:00";
//        String endTime = DateFormatUtils.long2Str(System.currentTimeMillis(), true);
//        mTvSelectedTime.setText(endTime);
//        // 通过日期字符串初始化日期，格式请用：yyyy-MM-dd HH:mm
//        mTimerPicker = new CustomDatePicker(this, new CustomDatePicker.Callback() {
//            @Override
//            public void onTimeSelected(long timestamp) {
//                mTvSelectedTime.setText(DateFormatUtils.long2Str(timestamp, true));
//            }
//        }, beginTime, endTime);
//        // 允许点击屏幕或物理返回键关闭
//        mTimerPicker.setCancelable(true);
//        // 显示时和分
//        mTimerPicker.setCanShowPreciseTime(true);
//        // 允许循环滚动
//        mTimerPicker.setScrollLoop(true);
//        // 允许滚动动画
//        mTimerPicker.setCanShowAnim(true);
//    }

}
