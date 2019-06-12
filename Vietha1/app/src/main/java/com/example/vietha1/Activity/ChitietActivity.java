package com.example.vietha1.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.Adapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vietha1.Adapter.ChitietAdapter;
import com.example.vietha1.Model.Lichsu;
import com.example.vietha1.Model.Quangcao;
import com.example.vietha1.R;
import com.example.vietha1.Service.APIService;
import com.example.vietha1.Service.Dataservice;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ChitietActivity extends AppCompatActivity {
    Toolbar toolbarchitiet;

    ImageView imgViewchitiet;
    TextView textviewtenchitietlichsu,txtmota;
    ChitietAdapter chitietAdapter;
    public static ArrayList<Lichsu> manglichsu = new ArrayList<>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chi_tiet_lich_su);
        init();
        GetDataFromIntent();
        GetDataChitiet();

    }

    private void GetDataChitiet() {
        Dataservice dataservice = APIService.getService();
        Call<List<Lichsu>> callback = dataservice.GetDataChitiet();
        callback.enqueue(new Callback<List<Lichsu>>() {
            @Override
            public void onResponse(Call<List<Lichsu>> call, Response<List<Lichsu>> response) {
                ArrayList<Lichsu> banners = (ArrayList<Lichsu>) response.body();

            }

            @Override
            public void onFailure(Call<List<Lichsu>> call, Throwable t) {

            }
        });}

    private void GetDataFromIntent() {
        Intent intent = getIntent();
        manglichsu.clear();
        if(intent != null) {
            if (intent.hasExtra("TenLichsu")) {
                Lichsu lichsu = intent.getParcelableExtra("TenLichsu");
                manglichsu.add(lichsu);

            }
        }
        String TenLichsu = " ";
        String Hinhanhlichsu = " ";
        String Mota = " ";
        Lichsu lichsu = (Lichsu) getIntent().getSerializableExtra("TenLichsu");
        TenLichsu = lichsu.getTenLichsu();
        Hinhanhlichsu = lichsu.getHinhLichsu();
        Mota = lichsu.getMoTa();
        textviewtenchitietlichsu.setText(TenLichsu);
        txtmota.setText(Mota);
        Picasso.with(getApplicationContext()).load(Hinhanhlichsu).placeholder(R.drawable.ic_local_florist_black_24dp)
                .error(R.drawable.ic_error_black_24dp)
                        .into(imgViewchitiet);
    }

    private void init() {
        toolbarchitiet = findViewById(R.id.toolbarchitiet);
        imgViewchitiet = findViewById(R.id.imgViewchitiet);
        textviewtenchitietlichsu = findViewById(R.id.textviewtenchitietlichsu);
        txtmota = findViewById(R.id.textviewmotachitiet);
    }
}


