package com.example.study1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class SubActivity extends AppCompatActivity {

    private ListView list;
    private TextView tv_sub;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sub);

        tv_sub = findViewById(R.id.tv_sub);

        list = (ListView)findViewById(R.id.list);
        List<String> data = new ArrayList<>();

        //list와 data를 담은, 중간다리 역할을 하는 어댑터 만듬
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, data);
        list.setAdapter(adapter); //리스트뷰에 어댑터 생성
        //adapter라는 이름으로 선언한 어댑터를 list에 세팅해줌

        //연결완료. 아이템 추가
        data.add("아이템1");
        data.add("아이템2");
        data.add("아이템3");
        adapter.notifyDataSetChanged(); //저장완료.


        Intent intent = getIntent();
        String str = intent.getStringExtra("str");

        tv_sub.setText(str);


    }
}