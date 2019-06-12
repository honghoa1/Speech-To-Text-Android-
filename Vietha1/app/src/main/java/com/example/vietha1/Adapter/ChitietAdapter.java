package com.example.vietha1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vietha1.Activity.ChitietActivity;
import com.example.vietha1.Model.Lichsu;
import com.example.vietha1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ChitietAdapter extends RecyclerView.Adapter<ChitietAdapter.ViewHolder> {
    Context context;
    ArrayList<Lichsu> manglichsu;

    public ChitietAdapter(Context context, ArrayList<Lichsu> manglichsu) {
        this.context = context;
        this.manglichsu = manglichsu;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.activity_chi_tiet_lich_su,viewGroup,false);

        return new ChitietAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChitietAdapter.ViewHolder viewHolder, int i) {
        Lichsu lichsu = manglichsu.get(i);
        viewHolder.txttenlichsu.setText(lichsu.getTenLichsu());
        viewHolder.txtmota.setText(lichsu.getMoTa());
        Picasso.with(context).load(lichsu.getHinhLichsu()).into(viewHolder.imageViewlichsu);
    }

    @Override
    public int getItemCount() {
        return manglichsu.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public ImageView imageViewlichsu;
        public TextView txttenlichsu,txtmota;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageViewlichsu = itemView.findViewById(R.id.imgViewchitiet);
            txttenlichsu = itemView.findViewById(R.id.textviewtenchitietlichsu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(context, ChitietActivity.class);
                    intent.putExtra("TenLichsu",manglichsu.get(getPosition()));
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    context.startActivity(intent);
                }
            });
        }


    }
}
