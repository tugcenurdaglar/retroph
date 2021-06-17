package com.tugcenurdaglar.retroph.client;

import com.tugcenurdaglar.retroph.models.Info;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public  interface RestInterface {

    @GET("posts/1/comments")
    Call<List<Info>> getInfo();
}
