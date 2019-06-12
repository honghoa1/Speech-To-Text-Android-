package com.example.vietha1.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.vietha1.Model.Quangcao;
import com.example.vietha1.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class BannerAdapter extends PagerAdapter {
    Context context;
    ArrayList<Quangcao> arrayListbanner;

    public BannerAdapter(Context context, ArrayList<Quangcao> arrayListbanner) {
        this.context = context;
        this.arrayListbanner = arrayListbanner;
    }

    @Override
    public int getCount() {
        return arrayListbanner.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == o;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dong_banner,null);

        ImageView imfbackgroundbanner = view.findViewById(R.id.imageviewbackgroundbanner);
        ImageView imgsongbanner = view.findViewById(R.id.imageviewbanner);
        TextView txttitlesongbanner = view.findViewById(R.id.textviewtitlebannerlichsu);
        TextView txtnoidung = view.findViewById(R.id.textviewnoidung);


        Picasso.with(context).load(arrayListbanner.get(position).getHinhanh()).into(imfbackgroundbanner);
        Picasso.with(context).load(arrayListbanner.get(position).getHinhLichsu()).into(imgsongbanner);

        txttitlesongbanner.setText(arrayListbanner.get(position).getTenLichsu());
        txtnoidung.setText(arrayListbanner.get(position).getNoidung());

        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }
}
