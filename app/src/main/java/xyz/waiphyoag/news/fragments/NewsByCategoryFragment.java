package xyz.waiphyoag.news.fragments;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.news.Data.models.NewsModel;
import xyz.waiphyoag.news.Event.LoadedNewsEvent;
import xyz.waiphyoag.news.MMNewsApp;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.adapters.NewsAdapter;
import xyz.waiphyoag.news.adapters.NewsByCategoryAdapter;
import xyz.waiphyoag.news.delegates.NewsActionDelegates;

/**
 * Created by WaiPhyoAg on 1/7/18.
 */

public class NewsByCategoryFragment extends Fragment implements NewsActionDelegates {
    @BindView(R.id.rv_news_by_category)
    RecyclerView rvNewsByCategory;

    private NewsAdapter mNewsAdapter= new NewsAdapter(this);

    @Override
    public void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    public void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_news_by_category, container, false);

        ButterKnife.bind(this, view);


            LinearLayoutManager linearLayoutManager= new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
            rvNewsByCategory.setLayoutManager(linearLayoutManager);

            rvNewsByCategory.setAdapter(mNewsAdapter);

        NewsModel.getsObjInstance().loadNews();

        return view;

    }

    @Override
    public void onTapNewsItem() {

    }

    @Override
    public void onTapCommentButton() {

    }

    @Override
    public void onTapSendToButton() {

    }

    @Override
    public void onTapFavoriteButton() {

    }
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onNewsLoaded(LoadedNewsEvent event)
    {
        Log.d(MMNewsApp.LOG_TAG,"onNewsLoaded"+event.getNews().size());
        mNewsAdapter.setNews(event.getNews());
    }
}
