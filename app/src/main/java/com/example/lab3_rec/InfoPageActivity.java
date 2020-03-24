package com.example.lab3_rec;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class InfoPageActivity extends AppCompatActivity {
    //Привязка элементов ЮИ
    @BindView(R.id.infoDate)
    TextView date;
    @BindView(R.id.infoName)
    TextView name;
    @BindView(R.id.infoGanre)
    TextView ganre;
    @BindView(R.id.infoInfo)
    TextView info;
    @BindView(R.id.imageView2)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info_page);
        ButterKnife.bind(this);
        //Получение данных и наполнение элементов ими
        name.setText(getIntent().getStringExtra("name"));
        ganre.setText("Жанр: " + getIntent().getStringExtra("ganre"));
        date.setText("Создание группы: " + getIntent().getStringExtra("date"));
        info.setText(getIntent().getStringExtra("info"));
        image.setImageResource(getIntent().getIntExtra("avatar", 0));
    }
}
