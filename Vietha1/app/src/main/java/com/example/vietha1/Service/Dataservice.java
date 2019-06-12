package com.example.vietha1.Service;

import com.example.vietha1.Model.Lichsu;
import com.example.vietha1.Model.Quangcao;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface Dataservice {

    @GET("songbanner1.php")
    Call<List<Quangcao>> GetDataBanner();
    @FormUrlEncoded
    @POST("lichsu.php")
    Call<List<Lichsu>> GetSearchLichsu(@Field("search") String search);
    @GET("lichsu.php")
    Call<List<Lichsu>> GetDataChitiet();


}
