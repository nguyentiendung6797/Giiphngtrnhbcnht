package com.example.pc.giiphngtrnhbcnht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    Button btnKetQua;
    EditText txta,txtb;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txta = (EditText) findViewById(R.id.number1);
        txtb = (EditText) findViewById(R.id.number2);
        btnKetQua = (Button) findViewById(R.id.btnKetQua);
        btnKetQua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //tạo intent để mở class ResultActivity
                Intent myIntent = new Intent(MainActivity.this, ResultActivity.class);
                int a = Integer.parseInt(txta.getText().toString());
                int b = Integer.parseInt(txtb.getText().toString());

                //khai báo bundle để đóng gói dữ liệu gửi sang ResultActivity
                Bundle bundle = new Bundle();
                bundle.putInt("number1", a);  //đưa dữ liệu riêng lẻ vào bundle
                bundle.putInt("number2", b);  //number2 là key, b là value

                //đưa bundle vào intent
                myIntent.putExtra("MyPackage", bundle);
                //mở ResultActivity thông qua intent
                startActivity(myIntent);
            }
        });
    }
}
