package com.example.tugas4;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rvPahlawan;
    private ArrayList<HeroModel> listPahlawan = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvPahlawan = findViewById(R.id.rv_pahlawan);
        rvPahlawan.setHasFixedSize(true);
        listPahlawan.addAll(HeroData.getHeroModel());

        rvPahlawan.setLayoutManager(new LinearLayoutManager(this));
        HeroAdapter heroAdapter = new HeroAdapter(this);
        heroAdapter.setListHero(listPahlawan);
        rvPahlawan.setAdapter(heroAdapter);

        heroAdapter.setOnItemClickCallback(new HeroAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(HeroModel hero) {
                Toast.makeText(MainActivity.this, "Memilih "+hero,Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                intent.putExtra(DetailsActivity.EXTRA_DATA,hero);
                startActivity(intent);
            }
        });

//        heroAdapter.setOnItemClickCallback(new Her.OnItemClickCallback() {
//            @Override
//            public void onItemClicked(ModelPahlawan pahlawan) {
//                Toast.makeText(MainActivity.this, "Memilih "+pahlawan.getHeroName(),Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
//                intent.putExtra(DetailActivity.EXTRA_DATA,pahlawan);
//                startActivity(intent);
//            }
//        });

    }


}