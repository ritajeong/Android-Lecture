package com.example.study1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button btn_move;
    private EditText et_test;
    private String str;
    ImageView test;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_test = findViewById(R.id.et_test);
        btn_move=findViewById(R.id.btn_move);
        btn_move.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                str = et_test.getText().toString(); //EditText 입력폼에서 받아온 텍스트가 Sub화면에 출력됨
                Intent intent = new Intent(MainActivity.this , SubActivity.class ); //첫번째 인자는 현재 액티비티, 두번째는 이동하고 싶은 액티비
                intent.putExtra("str", str);
                startActivity(intent); //액티비티 이동
            }
        });

        test = (ImageView)findViewById(R.id.test); //test id를 찾아오는 과정
        test.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "This is toast message", Toast.LENGTH_SHORT).show();
            }
        });

    }

}