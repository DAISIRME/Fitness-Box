package com.example.myapplication;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
//import com.example.new111.R;
public class Choose_Photo_Activity extends AppCompatActivity {
    int[] photo = new int[100];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose__photo_);
        photo[0] = R.drawable.xunlian;
        ImageView IV = findViewById(R.id.iv_photo1);
        IV.setOnClickListener(C_P);
        }
    View.OnClickListener C_P = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = getIntent();
            Bundle bundle = new Bundle();
            bundle.putInt("p1",photo[0]);
            intent.putExtras(bundle);
            int rw = 0x111;
            setResult(rw,intent);
            finish();
        }
    };
}
