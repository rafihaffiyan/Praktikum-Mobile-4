package com.example.tugas4;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HeroAdapter extends RecyclerView.Adapter<HeroAdapter.HeroViewHolder> {

    private Context context;
    private ArrayList<HeroModel> listHero;
    private OnItemClickCallback onItemClickCallback;

    public HeroAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<HeroModel> getListHero() {
        return listHero;
    }


    public void setListHero(ArrayList<HeroModel> listHero) {
        this.listHero = listHero;
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    @NonNull
    @Override
    public HeroViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_hero,parent,false);
        return new HeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final HeroViewHolder holder, int position) {
        Glide.with(context).load(getListHero().get(position).getHeroesImages()).into(holder.ivPhoto);
        holder.tvNama.setText(getListHero().get(position).getHeroNames());
        holder.tvDeskripsi.setText(getListHero().get(position).getHeroDetails());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(listHero.get(holder.getAdapterPosition()));
            }
        });

    }

    @Override
    public int getItemCount() {

        return getListHero().size();

    }


    public class HeroViewHolder extends RecyclerView.ViewHolder {
        private ImageView ivPhoto;
        private TextView tvNama, tvDeskripsi;
        public HeroViewHolder(@NonNull View itemView) {
            super(itemView);

            ivPhoto = itemView.findViewById(R.id.iv_photo);
            tvNama = itemView.findViewById(R.id.tv_nama);
            tvDeskripsi = itemView.findViewById(R.id.tv_deskripsi);
        }
    }

    public interface OnItemClickCallback{
        void onItemClicked(HeroModel hero);
    }
}