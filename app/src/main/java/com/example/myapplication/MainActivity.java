package com.example.myapplication;
import android.app.Dialog;
import android.content.Intent;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
//import com.example.new111.R;
public class MainActivity extends AppCompatActivity {
    int[] idA = new int[3];
    int[] id = new int[3];
    ImageView iv2;
    TextView back ;
    ImageView[] iv = new ImageView[3];
    TextView[] tv_setting = new TextView[4];
    RelativeLayout[] rl = new RelativeLayout[3];
    boolean[] judge = new boolean[3];
    RadioButton[] rb = new RadioButton[2];
    Fragment f1 = null;
    Fragment f2 = null;
    TextView tv4;
    RelativeLayout jilu;
    RadioGroup rg;
    String t = "234";
    LinearLayout ll;
    RelativeLayout id_rl;
    ImageView choose_photo;
    ImageView whole_person;
    TextView login_tv;
    TextView name1;
    ImageView[] muscle_man = new ImageView[10];
    ImageView[] muscle_woman = new ImageView[10];
    RelativeLayout rl_2;
    Fragment[] fragment = new Fragment[5];
    LinearLayout linearLayout;
    RelativeLayout Wode_bottom;
    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data)
    {
          super.onActivityResult(requestCode, resultCode, data);
          try
        {
          Bundle bundle = data.getExtras();
          if(resultCode==0x111)
            {
              int  re = bundle.getInt("p1");
              choose_photo.setImageResource(re);
            }
            if(resultCode==0x112)
            {
                String name = bundle.getString("name");
                name1.setText(name);
            }
        }
          catch(NullPointerException e)
            {
            Log.e("error", "返回信息为空");
            }
          muscle_man[0].setImageResource(R.drawable.hand_muscle_11);
    }
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        Bundle bundle = getIntent().getExtras();
        String name =  bundle.getString("name");
        int photoid = Integer.parseInt(bundle.getString("p1"));
        choose_photo = findViewById(R.id.IV_PHOTO);
        choose_photo.setImageResource(photoid);
        Log.e("name","123");
        LinearLayout choose_sex = findViewById(R.id.choose_sex);
        back = findViewById(R.id.back);
        iv2 = findViewById(R.id.setting);
        jilu = findViewById(R.id.Jilu);
        ll = findViewById(R.id.LL1);
        whole_person = findViewById(R.id.whole_person_front);
        id_rl = findViewById(R.id.Choose_RL);
        back.setOnClickListener(back_button);
        rg = findViewById(R.id.rg);
        judge[0] = true;
        judge[1] = false;
        judge[2] = false;
        Wode_bottom = findViewById(R.id.Wode_bottom);
        muscle_man[0] = findViewById(R.id.hand_muscle_1);
        muscle_man[1] = findViewById(R.id.whole_person_front);
        muscle_woman[0] = findViewById(R.id.whole_person_woman_front);
        iv[0] = findViewById(R.id.image1);
        iv[1] = findViewById(R.id.image2);
        iv[2] = findViewById(R.id.image3);
        tv_setting[0] = findViewById(R.id.rl_tv1);
        tv_setting[1] = findViewById(R.id.rl_tv2);
        tv_setting[2] = findViewById(R.id.rl_tv3);
        tv_setting[3] = findViewById(R.id.rl_tv4);
        FragmentManager manager = this.getSupportFragmentManager();
        rl[0] = findViewById(R.id.RL1);
        rl[1] = findViewById(R.id.RL2);
        rl[2] = findViewById(R.id.RL3);
        idA[0] = R.drawable.xunlian_click;
        idA[1] = R.drawable.jilu_click;
        idA[2] = R.drawable.wo_click;
        id[0] = R.drawable.xunlian;
        id[1] = R.drawable.jiludanzilishijilu;
        id[2] = R.drawable.wo;
        rb[0] = findViewById(R.id.RB1);
        rb[1] = findViewById(R.id.RB2);
        name1 = findViewById(R.id.log_in_tv);
        login_tv = findViewById(R.id.log_in_tv);
        linearLayout = findViewById(R.id.LL1);
        rl_2 = findViewById(R.id.Choose_RL);
        login_tv.setText("Name");
        login_tv.setText(name);
        for (int i = 0; i < 3; i++)
            rl[i].setOnClickListener(o);
        for (int i = 0; i < 4; i++)
            tv_setting[i].setOnClickListener(setting);
        if (rg == null)
            Log.e("ERROR", "rg为空");
        else
            rg.setOnCheckedChangeListener(new MyButtonListener());
        iv2.setOnClickListener(p);
        muscle_man[0].setOnClickListener(muscle1);
        choose_photo.setOnClickListener(Bottom);
        GLSurfaceView glSurfaceView = new GLSurfaceView(MainActivity.this);
        //设置登录
        back.setOnClickListener(back_button);
    }
    View.OnClickListener p = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, OpenGlActivity.class);
            startActivity(intent);
        }
    };
    //弹出照片
    private void showBottomDialog(){
        //使用Dialog、设置style
        final Dialog dialog = new Dialog(this,R.style.DialogTheme);
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
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
        dialog.findViewById(R.id.tv_take_pic).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });

        dialog.findViewById(R.id.tv_cancel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();
            }
        });
    }
    //底部栏的onClickListener实现页面(fragment)的切换
    View.OnClickListener o = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            //利用swithch—case语句实现当点击时自动将相关页面中的组件显示或者隐藏，并且切换fragment
            switch (v.getId()) {
                case R.id.RL1:
                    Wode_bottom.setVisibility(View.GONE);
                    back.setVisibility(View.VISIBLE);
                    judge[0] = true;
                    judge[1] = false;
                    judge[2] = false;
                    if (rb[0].isChecked())
                    {
                        muscle_man[0].setVisibility(View.VISIBLE);
                        muscle_man[1].setVisibility(View.VISIBLE);
                        muscle_woman[0].setVisibility(View.GONE);
                    }
                    else if (rb[1].isChecked())
                    {
                        muscle_man[0].setVisibility(View.GONE);
                        muscle_man[1].setVisibility(View.GONE);
                        muscle_woman[0].setVisibility(View.VISIBLE);
                    }
                    rb[0].setVisibility(View.VISIBLE);
                    rb[1].setVisibility(View.VISIBLE);
                    iv2.setVisibility(View.GONE);
                    id_rl.setVisibility(View.GONE);
                    jilu.setVisibility(View.GONE);
                    rl_2.setVisibility(View.GONE);
                    rg.setVisibility(View.VISIBLE);
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.RL2:
                    Wode_bottom.setVisibility(View.GONE);
                    judge[0] = false;
                    judge[1] = true;
                    back.setVisibility(View.GONE);
                    judge[2] = false;
                    muscle_man[0].setVisibility(View.GONE);
                    muscle_man[1].setVisibility(View.GONE);
                    muscle_woman[0].setVisibility(View.GONE);
                    jilu.setVisibility(View.VISIBLE);
                    if(f1==null)
                    f1= new Jilu_Fragment();
                    rb[0].setVisibility(View.GONE);
                    rb[1].setVisibility(View.GONE);
                    id_rl.setVisibility(View.GONE);
                    rl_2.setVisibility(View.GONE);
                    back.setVisibility(View.GONE);
                    rg.setVisibility(View.GONE);
                    linearLayout.setVisibility(View.GONE);
                    break;
                case R.id.RL3:
                    Wode_bottom.setVisibility(View.VISIBLE);
                    judge[0] = false;
                    judge[1] = false;
                    judge[2] = true;
                    rg.setVisibility(View.GONE);
                    back.setVisibility(View.GONE);
                    jilu.setVisibility(View.GONE);
                    muscle_man[0].setVisibility(View.GONE);
                    muscle_man[1].setVisibility(View.GONE);
                    muscle_woman[0].setVisibility(View.GONE);
                    rl_2.setVisibility(View.VISIBLE);
                    rb[0].setVisibility(View.GONE);
                    rb[1].setVisibility(View.GONE);
                    iv2.setVisibility(View.VISIBLE);
                    id_rl.setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
            for (int i = 0; i < 3; i++) {
                if (judge[i])
                    iv[i].setImageResource(idA[i]);
                else
                    iv[i].setImageResource(id[i]);
            }
        }
    };
    public void HideFragment(FragmentTransaction ft){
        if(f1!=null)
            ft.hide(f1);
        if(f2!=null)
            ft.hide(f2);
    }
    //选择男性还是女性的buttonlistener
    class MyButtonListener implements OnCheckedChangeListener {
        @Override
        public void onCheckedChanged(RadioGroup group, int checkedId) {
            switch (checkedId)
            {
                case R.id.RB1:
                    whole_person.setVisibility(View.VISIBLE);
                    muscle_woman[0].setVisibility(View.GONE);
                    break;
                case R.id.RB2:
                    whole_person.setVisibility(View.GONE);
                    muscle_woman[0].setVisibility(View.VISIBLE);
                    break;
                default:
                    break;
            }
        }
    }
    //设置肌肉部分的跳转界面
    //设置部分的onClickListener
    View.OnClickListener setting = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = null;
            switch (v.getId()) {
                case R.id.rl_tv1:
                    intent = new Intent(MainActivity.this, Data_center_Activity.class);
                    break;
                case R.id.rl_tv2:
                    intent = new Intent(MainActivity.this, Message_Activity.class);
                    break;
                case R.id.rl_tv3:
                    intent = new Intent(MainActivity.this, Footprint_Activity.class);
                    break;
                case R.id.rl_tv4:
                    intent = new Intent(MainActivity.this, Feedback_Activity.class);
                    break;
            }
            startActivity(intent);
        }
    };
    //选择照片
    View.OnClickListener L_P = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, Choose_Photo_Activity.class);
            int pw = 0x111;
            startActivityForResult(intent, pw);
        }
    };
    //选择投降按钮
    View.OnClickListener Bottom = new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            showBottomDialog();
        }
    };
    //点击肌肉实现页面跳转
    View.OnClickListener muscle1 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.e("check","已点击");
            Intent intent = new Intent(MainActivity.this,Hand_muscle_1_Activity.class);
            muscle_man[0].setImageResource(R.drawable.hand_muscle_1);
            startActivityForResult(intent,0x111);
            //            muscle_man[0].setImageResource(R.drawable.hand_muscle_unchanged_1);
        }
    };
    View.OnClickListener muscle2 = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this,Hand_muscle_2_Acitivity.class);
            startActivity(intent);
        }
    };
    //查看背部肌肉
    View.OnClickListener back_button = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (back.getText().toString().equals("背部")) {
                whole_person.setImageResource(R.drawable.whole_person_back);
                muscle_woman[0].setImageResource(R.drawable.whole_person_woman_back);
                back.setText("正面");
            }
            else if (back.getText().toString().equals("正面"))
            {
                    whole_person.setImageResource(R.drawable.whole_person_front);
                    muscle_woman[0].setImageResource(R.drawable.whole_person_woman_front);
                    back.setText("背部");
            }
            }
        };
    View.OnClickListener wode_bottom = new View.OnClickListener(){
        @Override
        public void onClick(View v) {

        }
    };
    };

