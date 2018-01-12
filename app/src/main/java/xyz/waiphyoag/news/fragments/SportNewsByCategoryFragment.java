package xyz.waiphyoag.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.adapters.SportNewsAdapter;

/**
 * Created by WaiPhyoAg on 1/7/18.
 */

public class SportNewsByCategoryFragment extends Fragment {
    @BindView(R.id.rv_sport_news)
    RecyclerView rvSportNews;
    private SportNewsAdapter mSportNewsAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_sportnews_by_category,container,false);
        ButterKnife.bind(this,view);

        mSportNewsAdapter= new SportNewsAdapter();

        LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);

        rvSportNews.setAdapter(mSportNewsAdapter);
        rvSportNews.setLayoutManager(linearLayoutManager);

        return view;

    }
}
