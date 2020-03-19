package com.example.myapplication;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;
//import com.example.new111.R;
public class Hand_muscle_1_Activity extends Activity {
    int judge_sort = 0 ;//用于判断是否已经进行过排序 0——未排序 1——升序 -1——降序
    LinearLayout detailed_action;
    ImageView[] nandu_triange = new ImageView[2];
    TextView check;
    TextView all;
    LinearLayout tool;
    RelativeLayout z;
    RelativeLayout[] action = new RelativeLayout[7];
    TextView  nandu;
    LinearLayout xiala_tool;
    ImageView check_icon;
    TextView[] detailed_tool = new TextView[3];
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState)
     {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hand_muscle_1_activity);
        detailed_action = findViewById(R.id.Detailed_Action);
        check = findViewById(R.id.check_amount);
        tool = findViewById(R.id.tool);
        nandu = findViewById(R.id.nandu);
        z  = findViewById(R.id.action_rl1);
        detailed_tool[0] = findViewById(R.id.tushou);
        detailed_tool[1] = findViewById(R.id.yaling);
        detailed_tool[2] = findViewById(R.id.gangling);
        all = findViewById(R.id.all);
        check_icon = findViewById(R.id.check_icon);
        action[0] = findViewById(R.id.action_rl1);
        action[1] = findViewById(R.id.action_rl2);
        action[2] = findViewById(R.id.action_rl3);
        action[3] = findViewById(R.id.action_rl4);
        action[4] = findViewById(R.id.action_rl5);
        action[5] = findViewById(R.id.action_rl6);
        action[6] = findViewById(R.id.action_rl7);
        xiala_tool = findViewById(R.id.xiala_tool);
        nandu_triange[0] = findViewById(R.id.nandu_up_triangle);
        nandu_triange[1] = findViewById(R.id.nandu_down_triangle);
        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                for(int i = 0 ;i<detailed_action.getChildCount();i++)
                    {
                    RelativeLayout rl  = (RelativeLayout) detailed_action.getChildAt(i);
                    for (int j =0;j<rl.getChildCount();j++)
                    {
                        LinearLayout ll;
                        TextView tv;
                        if(rl.getChildAt(j) instanceof LinearLayout)
                        {
                        ll = (LinearLayout) rl.getChildAt(j);
                            for(int k =0;k<ll.getChildCount();k++)
                            {
                            tv = (TextView) ll.getChildAt(k);
                            String s = tv.getText().toString();
                            if(!s.equals("中级"))
                            {
                                rl.setVisibility(View.GONE);
                            }
                            else if(s.equals("中级"))
                            {
                                rl.setVisibility(View.VISIBLE);
                                break;
                            }
                            }
                        }
                        else
                            {
                            continue;
                            }
                    }
                }
            }
        });
        //默认
        all.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {

                nandu_triange[0].setImageResource(R.drawable.up_triangle_unchecked);
                nandu_triange[1].setImageResource(R.drawable.down_triangle_unchecked);
                all.setTypeface(
                        Typeface.DEFAULT_BOLD
                );
                xiala_tool.setVisibility(View.GONE);
                for (int i =0;i<7;i++)
                {
                    if (action[i] != null)
                    {
                        ViewGroup parent = (ViewGroup) action[i].getParent();
                        action[i].setVisibility(View.VISIBLE);
                        if (parent != null)
                        {
                            parent.removeView(action[i]);
                        }
                    }
                    detailed_action.addView(action[i]);
                }
            }
        });
        //器械
        tool.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(xiala_tool.getVisibility()==View.GONE)
                {
                check_icon.setImageResource(R.drawable.down_triangle_checked);
                xiala_tool.setVisibility(View.VISIBLE);
                }
                else if(xiala_tool.getVisibility()==View.VISIBLE)
                {
                    check_icon.setImageResource(R.drawable.up_triangle_checked);
                    xiala_tool.setVisibility(View.GONE);
                }
            }
        });
        action[0].setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Hand_muscle_1_Activity.this,detailed_action_rl1.class);
                startActivity(intent);
            }
        });
        detailed_tool[0].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                all.setTypeface(
                        Typeface.DEFAULT
                );
                for(int i = 0 ;i<detailed_action.getChildCount();i++)
                {
                    RelativeLayout rl  = (RelativeLayout) detailed_action.getChildAt(i);
                    for (int j =0;j<rl.getChildCount();j++)
                    {
                        LinearLayout ll;
                        TextView tv;
                        if(rl.getChildAt(j) instanceof LinearLayout)
                        {
                            ll = (LinearLayout) rl.getChildAt(j);
                            for(int k =0;k<ll.getChildCount();k++)
                            {
                                tv = (TextView) ll.getChildAt(k);
                                String s = tv.getText().toString();
                                if(!s.equals("徒手"))
                                {
                                    rl.setVisibility(View.GONE);
                                }
                                else if(s.equals("徒手"))
                                {
                                    rl.setVisibility(View.VISIBLE);
                                    break;
                                }
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
            }
        });
        detailed_tool[1].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                all.setTypeface(
                        Typeface.DEFAULT
                );
                for(int i = 0 ;i<detailed_action.getChildCount();i++)
                {
                    RelativeLayout rl  = (RelativeLayout) detailed_action.getChildAt(i);
                    for (int j =0;j<rl.getChildCount();j++)
                    {
                        LinearLayout ll;
                        TextView tv;
                        if(rl.getChildAt(j) instanceof LinearLayout)
                        {
                            ll = (LinearLayout) rl.getChildAt(j);
                            for(int k =0;k<ll.getChildCount();k++)
                            {
                                tv = (TextView) ll.getChildAt(k);
                                String s = tv.getText().toString();
                                if(!s.equals("哑铃"))
                                {
                                    rl.setVisibility(View.GONE);
                                }
                                else if(s.equals("哑铃"))
                                {
                                    rl.setVisibility(View.VISIBLE);
                                    break;
                                }
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
            }
        });
        detailed_tool[2].setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                all.setTypeface(
                        Typeface.DEFAULT
                );
                for(int i = 0 ;i<detailed_action.getChildCount();i++)
                {
                    RelativeLayout rl  = (RelativeLayout) detailed_action.getChildAt(i);
                    for (int j =0;j<rl.getChildCount();j++)
                    {
                        LinearLayout ll;
                        TextView tv;
                        if(rl.getChildAt(j) instanceof LinearLayout)
                        {
                            ll = (LinearLayout) rl.getChildAt(j);
                            for(int k =0;k<ll.getChildCount();k++)
                            {
                                tv = (TextView) ll.getChildAt(k);
                                String s = tv.getText().toString();
                                if(!s.equals("杠铃"))
                                {
                                    rl.setVisibility(View.GONE);
                                }
                                else if(s.equals("杠铃"))
                                {
                                    rl.setVisibility(View.VISIBLE);
                                    break;
                                }
                            }
                        }
                        else
                        {
                            continue;
                        }
                    }
                }
            }
        });
       // 难度部分
        nandu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                all.setTypeface(
                        Typeface.DEFAULT
                );
                switch (judge_sort)
                {
                    case 0:
                        nandu_triange[0].setImageResource(R.drawable.up_triangle_checked);
                        break;
                    case 1:
                        nandu_triange[0].setImageResource(R.drawable.up_triangle_unchecked);
                        nandu_triange[1].setImageResource(R.drawable.down_triangle_checked);
                        break;
                    case -1:
                        nandu_triange[0].setImageResource(R.drawable.up_triangle_checked);
                        nandu_triange[1].setImageResource(R.drawable.down_triangle_unchecked);
                        break;
                }
                String[] record = new String[7];
                LayoutInflater inflater = getLayoutInflater();
                ((ViewGroup) detailed_action).setLayoutTransition(null);
                ((ViewGroup) detailed_action).removeAllViews();
                //记录当前排序情况
                for (int i = 0; i < 7; i++) {
                    for (int j = 0; j < 3; j++)
                    {
                        LinearLayout ll;
                        TextView tv;
                        if (action[i].getChildAt(j) instanceof LinearLayout)
                        {
                            int insert = 0;
                            ll = (LinearLayout) action[i].getChildAt(j);
                            tv = (TextView) ll.getChildAt(2);
                            String s = tv.getText().toString();
                            record[i] = s;
                        }
                        else
                            {
                            continue;
                            }
                    }
                }
                //冒泡排序 确定大小
                for (int m = 0; m < record.length-1; m++) {
                    int p = 0;
                    for (int n = 0; n < record.length - m - 1; n++) {
                        switch (judge_sort) {
                            case 0:
                            if (record[n].compareTo(record[n + 1]) > 0) {
                                String o = record[n];
                                record[n] = record[n + 1];
                                record[n + 1] = o;
                                p = 1;
                            }
                            break;
                            case -1:
                                if (record[n].compareTo(record[n + 1]) > 0) {
                                    String o = record[n];
                                    record[n] = record[n + 1];
                                    record[n + 1] = o;
                                    p = 1;
                                }
                            break;
                            case 1:
                                if (record[n].compareTo(record[n + 1]) < 0) {
                                    String o = record[n];
                                    record[n] = record[n + 1];
                                    record[n + 1] = o;
                                    p = 1;
                                }
                            break;
                        }
                    }
                    if (p == 0)
                        break;
                }
                // 将删除的动作重新添加进入视图中
                // 循环五次，将五个动作入视图
                    for (int k = 0; k < 7; k++) {
                        //找到需要的字符串
                        for (int i = 0; i < 7; i++) {
                            for (int j = 0; j < 3; j++)
                            {
                                LinearLayout ll;
                                TextView tv;
                                if (action[i].getChildAt(j) instanceof LinearLayout)
                                {
                                    ll = (LinearLayout) action[i].getChildAt(j);
                                    tv = (TextView) ll.getChildAt(2);
                                    String s = tv.getText().toString();
                                    if (s.equals(record[k]))
                                    {
                                        if (action[i] != null)
                                        {
                                            ViewGroup parent = (ViewGroup) action[i].getParent();
                                            if (parent != null)
                                            {
                                                parent.removeView(action[i]);
                                            }
                                        }
                                        detailed_action.addView(action[i]);
                                    }
                                }
                                else
                                    {
                                    continue;
                                    }
                            }
                        }
                    }
                switch (judge_sort)
                {
                    case 0:
                        judge_sort=1;
                        break;
                    case 1:
                        judge_sort=-1;
                        break;
                    case -1:
                        judge_sort=1;
                        break;
                }
            }
        });
    }
}

