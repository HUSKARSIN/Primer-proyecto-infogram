package com.kiton.infogramproyecto.adapter;

import android.app.Activity;
import android.app.ActivityOptions;
import android.content.Intent;
import android.media.Image;
import android.os.Build;
import android.text.Layout;
import android.transition.Explode;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.app.ActivityOptionsCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kiton.infogramproyecto.R;
import com.kiton.infogramproyecto.view.ImageDetailActivity;

import java.util.ArrayList;

public class CardViewAdapter extends RecyclerView.Adapter<CardViewAdapter.CardViewHolder> {
    //lista imagenes
    private ArrayList<Image> images;
    private  int resource;
    private Activity activity;
    private ViewGroup parent;

    public CardViewAdapter(ArrayList<Image> images, int resource,Activity activity){
        this.images = images;
        this.resource = resource;
        this.activity = activity;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType){

        View view = LayoutInflater.from(parent.getContext()).inflate(resource, parent, false);

        return new CardViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        Image image = images.get(position);
        //imagen
        // Picasso.get().load(image.getUrlImage()).into(helder.imageCardView);
        // holder.usernameCardView.setText(image.getUsername());
        // holder.cantidadDiasCardView.setText(image.getCantidadDias());
        // holder.cantidadMeGustaCarView.setText(image.getCantidadMeGusta());

        //oncliklistener

        holder.imageCarView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(activity, ImageDetailActivity.class);

                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
                    Explode explode = new Explode();
                    explode.setDuration(1000);
                    activity.getWindow().setExitTransition(explode);

                    activity.startActivity(intent, ActivityOptionsCompat.makeSceneTransitionAnimation
                            (activity, view, activity.getString(R.string.transitionName_imageCardView)).toBundle());
                }else {

                    activity.startActivity(intent);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return images.size();
    }

    public class CardViewHolder extends RecyclerView.ViewHolder {
            private ImageView imageCarView;
            private TextView usernameCardView;
            private TextView cantidadDiasCardView;
            private TextView cantidadMeGustaCarView;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            imageCarView = itemView.findViewById(R.id.imageCardView);
            usernameCardView = itemView.findViewById(R.id.usernameCardView);
            cantidadDiasCardView = itemView.findViewById(R.id.cantidadDiasCardview);
            cantidadMeGustaCarView = itemView.findViewById(R.id.cantidadMeGustaCardView);
        }
    }
}
