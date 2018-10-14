package com.example.daan.geoguessswipe;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

public class StreetviewObjectViewHolder extends RecyclerView.ViewHolder {

    public ImageView streetviewImage;
    public View view;

    public StreetviewObjectViewHolder(View itemView) {
        super(itemView);
        this.streetviewImage = itemView.findViewById(R.id.streetviewImageView);
        this.view = itemView;
    }
}
