package com.domikado.griddaggerretro.network;
// Created by irwancannady (irwancannady@gmail.com) on 2/7/17 at 2:16 PM.


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetworkModule {

    private String urlPath;

    public NetworkModule(String urlPath) {
        this.urlPath = urlPath;
    }

    @Singleton
    @Provides
    public Gson provideGson(){
        GsonBuilder builder = new GsonBuilder();
        return builder.create();
    }

    @Singleton
    @Provides
    public Retrofit provideRetrofit(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(urlPath)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
