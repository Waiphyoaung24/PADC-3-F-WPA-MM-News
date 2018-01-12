package xyz.waiphyoag.news.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.viewholders.ItemSportNewsViewHolder;

/**
 * Created by WaiPhyoAg on 1/12/18.
 */

public class SportNewsAdapter extends RecyclerView.Adapter {
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context= parent.getContext();
        LayoutInflater layoutInflater= LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.item_sport_news,parent,false);
        ItemSportNewsViewHolder itemSportNewsViewHolder= new ItemSportNewsViewHolder(view);
        return  itemSportNewsViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 5;
    }
}
