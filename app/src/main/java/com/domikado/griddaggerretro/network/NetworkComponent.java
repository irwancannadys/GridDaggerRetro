package com.domikado.griddaggerretro.network;
// Created by irwancannady (irwancannady@gmail.com) on 2/7/17 at 2:19 PM.


import com.domikado.griddaggerretro.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface NetworkComponent {

    void inject(MainActivity activity);
}
