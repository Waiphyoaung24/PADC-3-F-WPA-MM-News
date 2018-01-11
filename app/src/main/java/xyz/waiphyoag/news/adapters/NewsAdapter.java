package xyz.waiphyoag.news.adapters;

import android.content.Context;
import android.support.v7.view.menu.MenuView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


import java.util.ArrayList;
import java.util.List;

import xyz.waiphyoag.news.Data.vo.NewsVO;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.delegates.NewsActionDelegates;
import xyz.waiphyoag.news.viewholders.ItemNewsViewsHolder;

/**
 * Created by WaiPhyoAg on 12/3/17.
 */

public class NewsAdapter extends RecyclerView.Adapter<ItemNewsViewsHolder> {
    private List<NewsVO>news;
    private NewsActionDelegates mnewNewsActionDelegates;

    public NewsAdapter(NewsActionDelegates newsActionDelegates) {
        mnewNewsActionDelegates=newsActionDelegates;
        news=new ArrayList<>();
    }

    @Override
    public ItemNewsViewsHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context =parent.getContext();
        LayoutInflater inflater=LayoutInflater.from(context);
        View newsItemView=inflater.inflate(R.layout.item_news,parent,false);
        ItemNewsViewsHolder itemNewsViewsHolder=new ItemNewsViewsHolder(newsItemView,mnewNewsActionDelegates);

        return itemNewsViewsHolder;
    }

    @Override
    public void onBindViewHolder(ItemNewsViewsHolder holder, int position) {
        holder.setNews(news.get(position));

    }



    @Override
    public int getItemCount() {

        return news.size();
    }
    public void setNews(List<NewsVO>newsList)
    {
        news=newsList;
        notifyDataSetChanged();
    }
}
