package com.example.lab3_rec;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView mList = findViewById(R.id.recview);
        //Данные
        List<Band> bands = new ArrayList<>();
        bands.add(new Band("Ночные Снайпера", "1993/8/19", "Рок", "Long", R.drawable.ns));
        bands.add(new Band("Кино", "1981", "Рок", "Long", R.drawable.kinof));
        bands.add(new Band("Scorpions", "1965", "Рок", "Long", R.drawable.scorpions));
        bands.add(new Band("Noize MC", "2003", "Хип-хоп", "Long", R.drawable.nm));
        bands.add(new Band("Канцлер Ги", "2002", "менестрельская песня", "Long", R.drawable.kg));
        bands.add(new Band("АнимациЯ", "2000", "Рок", "Long", R.drawable.an));
        bands.add(new Band("Любэ", "1989/1/14", "Фолк", "Long", R.drawable.lb));
        //создание менеджера, привязка его и адаптера к Листу
        LinearLayoutManager manager = new LinearLayoutManager(this, RecyclerView.VERTICAL, false);
        mList.setLayoutManager(manager);
        mList.setAdapter(new MyAdapter(bands));

    }

    //описание моего адаптера
    class MyAdapter extends RecyclerView.Adapter<MyAdapter.BandViewHolder>{

        private List<Band> bands;

        public MyAdapter(List<Band> bands) {
            this.bands = bands;
        }

        //Создание Холдеров
        @NonNull
        @Override
        public BandViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view, parent, false);
            BandViewHolder holder = new BandViewHolder(v);
            return holder;
        }
        //Привязка данных к элементам
        @Override
        public void onBindViewHolder(@NonNull BandViewHolder holder, int position) {
            holder.avatar.setImageResource(bands.get(position).getAvatarID());
            holder.name.setText(bands.get(position).getName());
            holder.ganre.setText(bands.get(position).getGanre());
            //Обработчик нажатий (только на картинку)
            holder.avatar.setOnClickListener(v->{
                Intent intent = new Intent(MainActivity.this, InfoPageActivity.class);
                intent.putExtra("name", bands.get(position).getName());
                intent.putExtra("ganre", bands.get(position).getGanre());
                intent.putExtra("date", bands.get(position).getDate());
                intent.putExtra("info", bands.get(position).getLong_info());
                intent.putExtra("avatar", bands.get(position).getAvatarID());
                startActivity(intent);
            });

        }

        @Override
        public int getItemCount() {
            return bands.size();
        }

        public class BandViewHolder extends RecyclerView.ViewHolder{

            public ImageView avatar;
            public TextView name;
            public TextView ganre;

            public BandViewHolder(@NonNull View itemView) {
                super(itemView);
                avatar = itemView.findViewById(R.id.imageView);
                name = itemView.findViewById(R.id.bandname);
                ganre = itemView.findViewById(R.id.shortInfo);
            }


        }
    }
}
