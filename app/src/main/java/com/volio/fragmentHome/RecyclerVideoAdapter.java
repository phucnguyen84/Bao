package com.volio.fragmentHome;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.volio.bao.R;
import com.volio.entity.ItemVideo;

import java.util.ArrayList;

class ItemViewHolder extends RecyclerView.ViewHolder{

    public TextView txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo, txtTimeVideoFake;
    public ImageView imgItemVideo;

    public ItemViewHolder(View itemView) {
        super(itemView);
        txtNameVideo = itemView.findViewById(R.id.txtNameVideo);

        imgItemVideo = itemView.findViewById(R.id.imgItemVideo);
        txtAuthor=itemView.findViewById(R.id.txtAuthor);
        txtView=itemView.findViewById(R.id.txtView);
        txtTimePost=itemView.findViewById(R.id.txtTimePost);
        txtTimeVideo=itemView.findViewById(R.id.txtTimeVideo);
        txtTimeVideoFake =itemView.findViewById(R.id.txtTimeVideoFake);
    }
}


public class RecyclerVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    Context context;
    ArrayList<ItemVideo> itemVideos;
    public RecyclerVideoAdapter(Context context, ArrayList<ItemVideo> itemVideos){
        this.context=context;
        this.itemVideos = itemVideos;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context)
                .inflate(R.layout.item_video,parent,false);
        return new ItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        ItemVideo item = itemVideos.get(position);
        ItemViewHolder viewHolder = (ItemViewHolder) holder;
        viewHolder.txtTimeVideo.setText(item.getTxtTimeVideo());
        viewHolder.txtTimeVideoFake.setText(item.getTxtTimeVideoFake());
        viewHolder.txtNameVideo.setText(item.getTxtNameVideo());
        viewHolder.txtAuthor.setText(item.getTxtAuthor());
        viewHolder.txtTimePost.setText(item.getTxtTimePost());
        viewHolder.txtView.setText(item.getTxtView());
        Glide.with(context)
                .load(item.getImgItemVideo())
                .into(viewHolder.imgItemVideo);
    }

    @Override
    public int getItemCount() {
        return itemVideos.size();
    }
}