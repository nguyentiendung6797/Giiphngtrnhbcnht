package com.example.pc.giiphngtrnhbcnht;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    TextView txtKetQua;
    Button btnback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        txtKetQua = (TextView) findViewById(R.id.txtKetQua);
        btnback = (Button) findViewById(R.id.btnback);

        //get lấy intent đã gọi ResultActivity
        Intent callerIntent = getIntent();

        //get lấy bundle đã gửi
        Bundle packBundle = callerIntent.getBundleExtra("MyPackage");
        //get lấy gái trị a,b đã chuyển sang
        int a = packBundle.getInt("number1");
        int b = packBundle.getInt("number2");

        //xử lý giải phương trình bậc nhất
        giaiPTBN(a,b);

        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ResultActivity.this, MainActivity.class);
                startActivity(intent1);
            }
        });
    }


    public void giaiPTBN(int a, int b) {
        if (a == 0) {
            if (b == 0) {
                txtKetQua.setText("Phương trình vô số nghiệm!");
                return;
            } else {
                txtKetQua.setText("Phương trình vô nghiệm!");
            }
        } else txtKetQua.setText(String.valueOf((float) -b / a));
    }
}

