package com.volio.fragmentHome;

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.volio.bao.ILoadMore;
import com.volio.bao.R;
import com.volio.entity.ItemNews;
import com.volio.entity.ItemVideo;

import java.util.ArrayList;
import java.util.Random;


class ListVideosViewHolder extends RecyclerView.ViewHolder{

    public RecyclerView recyclerView;
    public ProgressBar progressBar;

    public ListVideosViewHolder(@NonNull View itemView) {
        super(itemView);
        recyclerView=itemView.findViewById(R.id.recyclerVideo);
        progressBar=itemView.findViewById(R.id.progressBarVideos);
    }
}

class LoadingItemNews extends RecyclerView.ViewHolder{

    public ProgressBar progressBar;

    public LoadingItemNews(@NonNull View itemView) {
        super(itemView);
        progressBar=itemView.findViewById(R.id.progressBarNews);
    }
}

class ItemNewsViewHolder extends RecyclerView.ViewHolder{

    public TextView txtContentNews,txtSpec,txtTimePostNews;
    public ImageView imgItemNews;

    public ItemNewsViewHolder(@NonNull View itemView) {
        super(itemView);
        txtContentNews=itemView.findViewById(R.id.txtContentNews);
        txtSpec=itemView.findViewById(R.id.txtSpec);
        txtTimePostNews=itemView.findViewById(R.id.txtTimePostNews);
        imgItemNews=itemView.findViewById(R.id.imgItemNews);
    }
}

public class TabAllAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    String txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake;
    Random random=new Random();
    boolean isScrolling=false;
    int currentItemsVideo, totalItemsVideo,scrollOutItemsVideo;
    LinearLayoutManager manager;

    private final int VIEW_TYPE_ITEM=0,VIEW_TYPE_ITEM_NEWS=1,VIEW_TYPE_LOADING_NEWS=2;
    ILoadMore loadMore;
    boolean isLoading=false;
    Context context;
    ArrayList<ItemVideo> itemVideos;
    ArrayList<ItemNews> itemNews;
    int visibleThreshold=4;
    int lastVisibleItem,totalItemCount;
    public TabAllAdapter(RecyclerView recyclerView, Context context, ArrayList<ItemVideo> itemVideos, ArrayList<ItemNews> itemNews){
        this.context=context;
        this.itemNews=itemNews;
        this.itemVideos=itemVideos;
        final LinearLayoutManager linearLayoutManager = (LinearLayoutManager)recyclerView.getLayoutManager();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                totalItemCount = linearLayoutManager.getItemCount();
                lastVisibleItem = linearLayoutManager.findLastVisibleItemPosition();
                if(!isLoading && totalItemCount <= (lastVisibleItem+visibleThreshold))
                {
                    if(loadMore != null)
                        loadMore.onLoadMore();
                    isLoading = true;
                }
            }
        });
    }


    @Override
    public int getItemViewType(int position) {
        if(position==0){
            return VIEW_TYPE_ITEM;
        }else if(position>=1){
            return itemNews.get(position-1)==null?VIEW_TYPE_LOADING_NEWS:VIEW_TYPE_ITEM_NEWS;
        }
        return -1;
    }

    public void setLoadMore(ILoadMore loadMore) {
        this.loadMore = loadMore;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if(viewType == VIEW_TYPE_ITEM)
        {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_news_videos,parent,false);
            return new ListVideosViewHolder(view);
        }
        else if(viewType==VIEW_TYPE_ITEM_NEWS){
            View view= LayoutInflater.from(context)
                    .inflate(R.layout.item_news,parent,false);
            return new ItemNewsViewHolder(view);
        }
        else if(viewType == VIEW_TYPE_LOADING_NEWS)
        {
            View view = LayoutInflater.from(context)
                    .inflate(R.layout.item_loading_news,parent,false);
            return new LoadingItemNews(view);
        }
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        if(holder instanceof  ListVideosViewHolder)
        {
            final ListVideosViewHolder videosViewHolder = (ListVideosViewHolder) holder;
            manager=new LinearLayoutManager(context,LinearLayoutManager.HORIZONTAL,false);
            videosViewHolder.recyclerView.setLayoutManager(manager);
            final RecyclerVideoAdapter videoAdapter = new RecyclerVideoAdapter(
                    context, itemVideos
            );
            videosViewHolder.recyclerView.setAdapter(videoAdapter);
            videosViewHolder.recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
                @Override
                public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                    super.onScrollStateChanged(recyclerView, newState);
                    if(newState== AbsListView.OnScrollListener.SCROLL_STATE_TOUCH_SCROLL){
                        isScrolling=true;
                    }
                }

                @Override
                public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                    super.onScrolled(recyclerView, dx, dy);
                    currentItemsVideo=manager.getChildCount();
                    totalItemsVideo=manager.getItemCount();
                    scrollOutItemsVideo=manager.findFirstVisibleItemPosition();
                    Log.i("xyz123456", currentItemsVideo+" "+totalItemsVideo+" "+scrollOutItemsVideo);
                    if(isScrolling && (currentItemsVideo+scrollOutItemsVideo==totalItemsVideo)){
                        isScrolling=false;
                        videosViewHolder.progressBar.setVisibility(View.VISIBLE);
                        if(itemVideos.size()<=100){
                            new Handler().postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    for (int i = 0; i < 20; i++) {
                                        int x = random.nextInt(3);
                                        if (x == 0) {
                                            txtTimeVideo = "11:11";
                                            txtTimeVideoFake = txtTimeVideo;
                                            txtNameVideo = "Mùa thu hà nội";
                                            txtAuthor = "Linh Đan -";
                                            txtView = x + "k lượt xem - ";
                                            txtTimePost = x + " tuần";
                                            ItemVideo item = new ItemVideo(R.drawable.muathuhanoi, txtNameVideo, txtAuthor, txtView, txtTimePost, txtTimeVideo, txtTimeVideoFake);
                                            itemVideos.add(item);
                                            videoAdapter.notifyDataSetChanged();
                                        }
                                        if (x == 1) {
                                            txtTimeVideo = "3:05";
                                            txtTimeVideoFake = txtTimeVideo;
                                            txtNameVideo = "Cuộc sống về thu";
                                            txtAuthor = "Linh Trần -";
                                            txtView = x + "k lượt xem - ";
                                            txtTimePost = x + " tuần";
                                            ItemVideo item = new ItemVideo(R.drawable.muathuhn, txtNameVideo, txtAuthor, txtView, txtTimePost, txtTimeVideo, txtTimeVideoFake);
                                            itemVideos.add(item);
                                            videoAdapter.notifyDataSetChanged();
                                        }
                                        if (x == 2) {
                                            txtTimeVideo = "2:30";
                                            txtTimeVideoFake = txtTimeVideo;
                                            txtNameVideo = "Thiên nhiên";
                                            txtAuthor = "Abc -";
                                            txtView = x + "k lượt xem - ";
                                            txtTimePost = x + " tuần";
                                            ItemVideo item = new ItemVideo(R.drawable.thanhhoa, txtNameVideo, txtAuthor, txtView, txtTimePost, txtTimeVideo, txtTimeVideoFake);
                                            itemVideos.add(item);
                                            videoAdapter.notifyDataSetChanged();
                                        }
                                        videosViewHolder.progressBar.setVisibility(View.GONE);
                                    }
                                }
                            },2000);
                        }else{
                            videosViewHolder.progressBar.setVisibility(View.GONE);
                            Toast.makeText(context, "Load data Videos completed", Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });
        }
        else if(holder instanceof ItemNewsViewHolder){
            ItemNews item= itemNews.get(position-1);
            ItemNewsViewHolder viewHolder= (ItemNewsViewHolder) holder;
            viewHolder.txtContentNews.setText(item.getTxtContentNews());
            viewHolder.txtSpec.setText(item.getTxtSpec());
            viewHolder.txtTimePostNews.setText(item.getTxtTimePostNews());
            Glide.with(context)
                    .load(item.getImgItemNews())
                    .into(viewHolder.imgItemNews);
        }
        else if(holder instanceof LoadingItemNews){
            LoadingItemNews loadingItemNews= (LoadingItemNews) holder;
            loadingItemNews.progressBar.setIndeterminate(true);
        }
    }

    @Override
    public int getItemCount() {
        return itemNews.size()+1;
    }

    public void setLoaded() {
        isLoading = false;
    }
}
