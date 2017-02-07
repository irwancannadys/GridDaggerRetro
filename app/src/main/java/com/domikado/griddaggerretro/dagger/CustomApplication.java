package com.domikado.griddaggerretro.dagger;
// Created by irwancannady (irwancannady@gmail.com) on 2/7/17 at 2:25 PM.

import android.app.Application;

import com.domikado.griddaggerretro.network.DaggerNetworkComponent;
import com.domikado.griddaggerretro.network.Helper;
import com.domikado.griddaggerretro.network.NetworkComponent;
import com.domikado.griddaggerretro.network.NetworkModule;

public class CustomApplication extends Application{

    private NetworkComponent networkComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        networkComponent = DaggerNetworkComponent.builder()
                .networkModule(new NetworkModule(Helper.URL))
                .build();
    }

  public NetworkComponent getNetworkComponent(){
      return networkComponent;
  }
}
