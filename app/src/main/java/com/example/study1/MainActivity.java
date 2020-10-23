package com.example.study1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    EditText et_id;
    Button btn_test;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_id = findViewById(R.id.et_id);
        btn_test = findViewById(R.id.btn_test);

        btn_test.setOnClickListener(new View.OnClickListener() { //Alt Enter로 implement methods
            @Override
            public void onClick(View v) {
                et_id.setText("app study2"); //버튼을 클릭했을 때 텍스트박스에 텍스트가 뜨게 함
            }
        });

    }
}