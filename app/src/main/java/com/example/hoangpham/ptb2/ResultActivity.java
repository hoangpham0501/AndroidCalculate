package com.example.hoangpham.ptb2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    TextView tvKetqua;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        tvKetqua = (TextView) findViewById(R.id.tvKetqua);

        //Goi lay Intent
        Intent callerIntent = getIntent();

        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");

        int a = packBundle.getInt("SoA");
        int b = packBundle.getInt("SoB");

        giaiPTBN(a,b);
    }

    public void giaiPTBN(int a, int b){
        if(a == 0){
            if(b == 0) {
                tvKetqua.setText("Phuong trinh vo so nghiem");
                return;
            }else{
                tvKetqua.setText("Phuong trinh vo nghiem");
            }
        }else{
            tvKetqua.setText(String.valueOf((float) -b/a));
            return;
        }
    }

    public void onClickBackButton(View view){
        setResult(101);
        finish();
    }
}

