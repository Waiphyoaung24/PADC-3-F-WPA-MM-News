package xyz.waiphyoag.news.activities;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridLayout;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.news.Data.models.NewsModel;
import xyz.waiphyoag.news.Event.LoadedNewsEvent;
import xyz.waiphyoag.news.MMNewsApp;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.activities.*;
import xyz.waiphyoag.news.adapters.NewsAdapter;
import xyz.waiphyoag.news.delegates.NewsActionDelegates;

public class MainActivity extends AppCompatActivity implements NewsActionDelegates{

    @BindView(R.id.rv_news)
    RecyclerView rvNews;

    @BindView(R.id.toolbar)
    Toolbar toolbar;

    @BindView(R.id.fab)
    FloatingActionButton fab;

    private NewsAdapter mNewsAdapter;

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this,this);
        setSupportActionBar(toolbar);
        mNewsAdapter=new NewsAdapter(this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.VERTICAL,false  );
        rvNews.setLayoutManager(linearLayoutManager);
        rvNews.setAdapter(mNewsAdapter);

        NewsModel.getsObjInstance().loadNews();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @OnClick(R.id.fab)
    public void onTapFab(View view)
    {
        Toast.makeText(getApplicationContext(), "Replace with your own action", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onTapNewsItem() {
        Intent intent=new Intent(getApplicationContext(),NewsDetailsActivity.class);
        startActivity(intent);

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
    @Subscribe(threadMode=ThreadMode.MAIN)
    public void onNewsLoad(LoadedNewsEvent event)
    {
        Log.d(MMNewsApp.LOG_TAG,"onNewsLoaded"+event.getNews().size());
        mNewsAdapter.setNews(event.getNews());
    }
}
