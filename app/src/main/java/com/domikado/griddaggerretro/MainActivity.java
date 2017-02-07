package com.domikado.griddaggerretro;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.domikado.griddaggerretro.adapter.SongAdapter;
import com.domikado.griddaggerretro.dagger.CustomApplication;
import com.domikado.griddaggerretro.entitie.ModelSongs;
import com.domikado.griddaggerretro.network.ApiService;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private RecyclerView gridView;

    @Inject
    Retrofit retrofit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViewAndLoadJson();
    }

    private void initViewAndLoadJson(){
        gridView = (RecyclerView)findViewById(R.id.song_list);
        GridLayoutManager mGrid = new GridLayoutManager(MainActivity.this, 2);
        gridView.setLayoutManager(mGrid);
        gridView.setHasFixedSize(true);

        ((CustomApplication)getApplication()).getNetworkComponent().inject(MainActivity.this);
        ApiService apiService = retrofit.create(ApiService.class);
        Call<List<ModelSongs>> call = apiService.getModel();
        call.enqueue(new Callback<List<ModelSongs>>() {
            @Override
            public void onResponse(Call<List<ModelSongs>> call, Response<List<ModelSongs>> response) {
                SongAdapter songAdapter = new SongAdapter(MainActivity.this, response.body());
                gridView.setAdapter(songAdapter);
            }

            @Override
            public void onFailure(Call<List<ModelSongs>> call, Throwable t) {
                Log.d(TAG, "Display error code " + t.toString());
            }
        });
    }
}
