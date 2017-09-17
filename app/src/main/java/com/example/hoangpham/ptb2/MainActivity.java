package com.example.hoangpham.ptb2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Button btnKetqua;
    private EditText eda, edb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eda = (EditText) findViewById(R.id.ed_a);
        edb = (EditText) findViewById(R.id.ed_b);
        btnKetqua = (Button) findViewById(R.id.btnKetqua);
        btnKetqua.setOnClickListener (new View.OnClickListener(){
            @Override
            public void onClick(View v){
                try{
                    float a = Float.parseFloat(eda.getText().toString());
                    float b = Float.parseFloat(edb.getText().toString());
                    //Tao Intent de mo class ResultActivity
                    Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                    //Khai bao bundle dong goi du lieu
                    Bundle bundle = new Bundle();
                    bundle.putFloat("SoA", a);
                    bundle.putFloat("SoB", b);

                    //Dua bundle vao Intent
                    myIntent.putExtra("MyPackage", bundle);
                    //Mo ResultActivity thong qua Intent
                    startActivityForResult(myIntent,100);
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this, "Lỗi input", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100){
            if (resultCode == 101){
                eda.setText("0");
                edb.setText("0");
            }
        }
    }
}
