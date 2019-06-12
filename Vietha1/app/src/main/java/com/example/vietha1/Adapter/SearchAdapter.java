package com.example.vietha1.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;
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

public class SearchAdapter extends RecyclerView.Adapter<SearchAdapter.ViewHodler>{
    Context context;
    ArrayList<Lichsu> manglichsu;

    public SearchAdapter(Context context) {
        this.context = context;
        manglichsu = new ArrayList<>();
    }

    public void setNewList(ArrayList<Lichsu> manglichsu){
        this.manglichsu = manglichsu;
        notifyDataSetChanged();
    }

    public void setClearList(){
        manglichsu.clear();
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHodler onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
        View view = inflater.inflate(R.layout.dong_search,viewGroup,false);

        return new ViewHodler(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHodler viewHodler, int i) {
        Lichsu lichsu = manglichsu.get(i);
        viewHodler.txttenlichsu.setText(lichsu.getTenLichsu());
        Picasso.with(context).load(lichsu.getHinhLichsu()).into(viewHodler.imglichsu);

    }

    @Override
    public int getItemCount() {
        return manglichsu.size();
    }

    public class ViewHodler extends RecyclerView.ViewHolder{
        TextView txttenlichsu;
        ImageView imglichsu;
        public ViewHodler(@NonNull View itemView) {
            super(itemView);
            txttenlichsu = itemView.findViewById(R.id.textviewsearchten);
            imglichsu = itemView.findViewById(R.id.imageviewSearchlichsu);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent (context, ChitietActivity.class);
                    intent.putExtra("TenLichsu",manglichsu.get(getPosition()));
                    context.startActivity(intent);
                }
            });





        }
    }
}
