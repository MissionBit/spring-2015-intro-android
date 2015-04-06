package com.missionbit.spring2015introandroid;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.missionbit.spring2015introandroid.models.InstagramPhoto;
import com.squareup.picasso.Picasso;

import java.util.List;

public class InstagramPhotoAdapter extends RecyclerView.Adapter<InstagramPhotoAdapter.ViewHolder> {

    private final List<InstagramPhoto> items;
    Context context;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        // each data item is just a string in this case
        public ImageView ivPhoto;
        public ViewHolder(View v) {
            super(v);
            ivPhoto = (ImageView)v.findViewById(R.id.photo);
        }
    }

    public InstagramPhotoAdapter(Context context, List<InstagramPhoto> items) {
        this.items = items;
        this.context = context;
    }

    @Override
    public InstagramPhotoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int i) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.instagram_photo, parent, false);

        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(InstagramPhotoAdapter.ViewHolder viewHolder, int i) {
        Picasso.with(context).load(items.get(i).url).placeholder(R.mipmap.placeholder).into(viewHolder.ivPhoto);

    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}
