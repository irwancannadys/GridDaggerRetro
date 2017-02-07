package com.domikado.griddaggerretro.adapter;
// Created by irwancannady (irwancannady@gmail.com) on 2/7/17 at 2:08 PM.

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.domikado.griddaggerretro.R;
import com.domikado.griddaggerretro.entitie.ModelSongs;
import com.domikado.griddaggerretro.network.Helper;

import java.util.List;

public class SongAdapter extends RecyclerView.Adapter<SongAdapter.ViewHolder> {

    private Context context;
    private List<ModelSongs> modelSongses;

    public SongAdapter(Context context, List<ModelSongs> modelSongses) {
        this.context = context;
        this.modelSongses = modelSongses;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.song_layout, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ModelSongs mSong = modelSongses.get(position);
        holder.songTitle.setText(mSong.getSongTitle());
        holder.songAuthor.setText(mSong.getSongAuthor());
        String imagePath = Helper.URL + "images/" + mSong.getSongImage();
        Glide.with(context).load(imagePath)
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .fitCenter()
                .into(holder.songImage);
    }

    @Override
    public int getItemCount() {
        return modelSongses.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        TextView songTitle;
        TextView songAuthor;
        ImageView songImage;

        public ViewHolder(View itemView) {
            super(itemView);

            songTitle = (TextView)itemView.findViewById(R.id.song_name);
            songAuthor = (TextView)itemView.findViewById(R.id.song_author);
            songImage = (ImageView)itemView.findViewById(R.id.song_image);
        }
    }
}
