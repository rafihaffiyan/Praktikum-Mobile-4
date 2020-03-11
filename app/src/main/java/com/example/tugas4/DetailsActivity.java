package com.example.tugas4;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import androidx.appcompat.app.AppCompatActivity;

public class DetailsActivity extends AppCompatActivity {

    public static String EXTRA_DATA = "extra_data";
    private ImageView ivPhoto;
    private TextView tvName, tvDescription;
    private Button btShare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        ivPhoto = findViewById(R.id.iv_photoDetail);
        tvName = findViewById(R.id.tv_namaDetail);
        tvDescription = findViewById(R.id.tv_deskripsiDetail);

        HeroModel pahlawan = getIntent().getParcelableExtra(EXTRA_DATA);
        int image = pahlawan.getHeroesImages();
        final String name = pahlawan.getHeroNames();
        final String description = pahlawan.getHeroDetails();

        if (pahlawan!=null){
            Glide.with(this).load(image).into(ivPhoto);
            tvName.setText(name);
            tvDescription.setText(description);
        }

        btShare = findViewById(R.id.btn_share);
        btShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent myIntent = new Intent(Intent.ACTION_SEND);
                myIntent.setType("text/plain");
                myIntent.putExtra(Intent.EXTRA_TEXT,description);
                Intent shareIntent = Intent.createChooser(myIntent, null);
                startActivity(shareIntent);
            }
        });
//
    }
}