package com.volio.fragmentHome;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.volio.bao.ILoadMore;
import com.volio.bao.R;
import com.volio.entity.ItemNews;
import com.volio.entity.ItemVideo;

import java.util.ArrayList;
import java.util.Random;

public class Fragment1 extends Fragment {

    RecyclerView recyclerNews;
    TabAllAdapter newsAdapter;
    ArrayList<ItemVideo> itemVideos;
    ArrayList<ItemNews> itemNews;
    String txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake;
    String txtContentNews,txtSpec,txtTimePostNews;
    Random random=new Random();
    Context context;

    public Fragment1(Context context) {
        this.context=context;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_home1, container, false);
        itemVideos =new ArrayList<>();
        itemNews =new ArrayList<>();
        recyclerNews=view.findViewById(R.id.recyclerNews);

        recyclerNews.setLayoutManager(new LinearLayoutManager(context));
        newsAdapter =new TabAllAdapter(recyclerNews,context,itemVideos,itemNews);
        randomDataVideo();

        randomDataNews();
        newsAdapter.setLoadMore(new ILoadMore() {
            @Override
            public void onLoadMore() {
                if(itemNews.size()<=100){
                    itemNews.add(null);
                    newsAdapter.notifyItemInserted(itemNews.size()-1);
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            itemNews.remove(itemNews.size()-1);
                            newsAdapter.notifyItemRemoved(itemNews.size());
                            int index=itemNews.size();
                            int end=index+20;
                            for (int i = index; i < end; i++) {
                                int x=random.nextInt(3);
                                if(x==0){
                                    txtContentNews="Denis Đặng: Là “giám đốc sáng tạo“ hay “đạo cụ sân khấu“ cũng được, chỉ abc xyz 123456 vậy thôi";
                                    txtSpec="Sta";
                                    txtTimePostNews="10 giờ trước";
                                    ItemNews item=new ItemNews(R.drawable.news1,txtContentNews,txtSpec,txtTimePostNews);
                                    itemNews.add(item);
                                }
                                if(x==1){
                                    txtContentNews="Mỗi mùa Tết về: Để ta thấy mình trưởng thành hơn từ những áp lực";
                                    txtSpec="Đời sống";
                                    txtTimePostNews="1 tuần trước";
                                    ItemNews item=new ItemNews(R.drawable.news2,txtContentNews,txtSpec,txtTimePostNews);
                                    itemNews.add(item);
                                }
                                if(x==2){
                                    txtContentNews="Có cái gì đó ở đây";
                                    txtSpec="Showbiz";
                                    txtTimePostNews="1 tháng trước";
                                    ItemNews item=new ItemNews(R.drawable.news3,txtContentNews,txtSpec,txtTimePostNews);
                                    itemNews.add(item);
                                }
                            }
                            newsAdapter.notifyDataSetChanged();
                            newsAdapter.setLoaded();
                        }
                    },2000);
                }else {
                    Toast.makeText(context, "Load data News completed", Toast.LENGTH_SHORT).show();
                }
            }
        });
        recyclerNews.setAdapter(newsAdapter);
        return view;
    }

    private void randomDataNews() {
        for (int i =0; i < 3; i++) {
            int x=random.nextInt(3);
            if(x==0){
                txtContentNews="Denis Đặng: Là “giám đốc sáng tạo“ hay “đạo cụ sân khấu“ cũng được, chỉ abc xyz 123456 vậy thôi";
                txtSpec="Sta";
                txtTimePostNews="10 giờ trước";
                ItemNews item=new ItemNews(R.drawable.news1,txtContentNews,txtSpec,txtTimePostNews);
                itemNews.add(item);
            }
            if(x==1){
                txtContentNews="Mỗi mùa Tết về: Để ta thấy mình trưởng thành hơn từ những áp lực";
                txtSpec="Đời sống";
                txtTimePostNews="1 tuần trước";
                ItemNews item=new ItemNews(R.drawable.news2,txtContentNews,txtSpec,txtTimePostNews);
                itemNews.add(item);
            }
            if(x==2){
                txtContentNews="Có cái gì đó ở đây";
                txtSpec="Showbiz";
                txtTimePostNews="1 tháng trước";
                ItemNews item=new ItemNews(R.drawable.news3,txtContentNews,txtSpec,txtTimePostNews);
                itemNews.add(item);
            }
        }
    }

    private void randomDataVideo(){
        for (int i = 0; i < 3; i++) {
            int x=random.nextInt(3);
            if(x==0){
                txtTimeVideo="11:11";
                txtTimeVideoFake=txtTimeVideo;
                txtNameVideo="Mùa thu hà nội";
                txtAuthor="Linh Đan -";
                txtView=x+"k lượt xem - ";
                txtTimePost=x+" tuần";
                ItemVideo item=new ItemVideo(R.drawable.muathuhanoi,txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake);
                itemVideos.add(item);
            }
            if(x==1){
                txtTimeVideo="3:05";
                txtTimeVideoFake=txtTimeVideo;
                txtNameVideo="Cuộc sống về thu";
                txtAuthor="Linh Trần -";
                txtView=x+"k lượt xem - ";
                txtTimePost=x+" tuần";
                ItemVideo item=new ItemVideo(R.drawable.muathuhn,txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake);
                itemVideos.add(item);
            }
            if(x==2){
                txtTimeVideo="2:30";
                txtTimeVideoFake=txtTimeVideo;
                txtNameVideo="Thiên nhiên";
                txtAuthor="Abc -";
                txtView=x+"k lượt xem - ";
                txtTimePost=x+" tuần";
                ItemVideo item=new ItemVideo(R.drawable.thanhhoa,txtNameVideo,txtAuthor,txtView,txtTimePost,txtTimeVideo,txtTimeVideoFake);
                itemVideos.add(item);
            }
        }
    }
}
