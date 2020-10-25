package com.example.study1;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
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
    //SharedPreferences
    EditText et_save;
    String shared = "file";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_save = (EditText) findViewById(R.id.et_save);
        //SharePreferences
        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        String value = sharedPreferences.getString("savedValue","");
        et_save.setText(value);

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

    //이 액티비티를 벗어날 때 액티비티가 파괴됨. 그 때 호출되는 함수
    //SharedPreferences로 저장시키면서 나갈 수 있게 함
    @Override
    protected void onDestroy() {
        super.onDestroy();

        SharedPreferences sharedPreferences = getSharedPreferences(shared, 0);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //SharePreferences안에 에디터를 연결함
        String value = et_save.getText().toString(); //getText는 현재 써져있는 값을 받아와서 스트링으로 씀
        editor.putString("savedValue", value);
        editor.commit();
    }
}