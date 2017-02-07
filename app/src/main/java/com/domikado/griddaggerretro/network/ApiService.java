package com.domikado.griddaggerretro.network;
// Created by irwancannady (irwancannady@gmail.com) on 2/7/17 at 2:30 PM.

import com.domikado.griddaggerretro.entitie.ModelSongs;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/dagger")
    Call<List<ModelSongs>> getModel();
}
