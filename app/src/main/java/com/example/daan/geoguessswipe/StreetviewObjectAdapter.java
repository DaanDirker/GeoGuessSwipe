package com.example.daan.geoguessswipe;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class StreetviewObjectAdapter extends RecyclerView.Adapter<StreetviewObjectViewHolder> {

    private Context context;
    public List<StreetviewObject> listStreetviewObjects;

    public StreetviewObjectAdapter(Context context, List<StreetviewObject> listStreetviewObjects) {
        this.context = context;
        this.listStreetviewObjects = listStreetviewObjects;
    }

    @Override
    public StreetviewObjectViewHolder onCreateViewHolder (ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_row, parent, false);
        return new StreetviewObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder (StreetviewObjectViewHolder holder, final int position) {
        // Gets a single item in the list from its position
        final StreetviewObject streetviewObject = listStreetviewObjects.get(position);
        // The holder argument is used to reference the views inside the viewHolder
        // Populate the views with the data from the list
        holder.streetviewImage.setImageResource(streetviewObject.getmImage());
    }

    @Override
    public int getItemCount() {
        return listStreetviewObjects.size();
    }
}
