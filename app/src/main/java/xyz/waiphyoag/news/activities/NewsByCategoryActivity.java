package xyz.waiphyoag.news.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import butterknife.BindView;
import butterknife.ButterKnife;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.adapters.NewsByCategoryAdapter;
import xyz.waiphyoag.news.fragments.InternationalNewsByCategoryFragment;
import xyz.waiphyoag.news.fragments.NewsByCategoryFragment;
import xyz.waiphyoag.news.fragments.SportNewsByCategoryFragment;

/**
 * Created by WaiPhyoAg on 1/7/18.
 */

public class NewsByCategoryActivity extends AppCompatActivity {

    private NewsByCategoryAdapter mNewsByCategoryAdapter;
    @BindView(R.id.tb_news_by_category)
    TabLayout tbNewsByCategory;
    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.vp_news_by_category)
    ViewPager vpnewsbycategory;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_by_category);


        ButterKnife.bind(this, this);

        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(R.string.title_news_by_category);
            getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_arrow_back_24dp);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);


            mNewsByCategoryAdapter = new NewsByCategoryAdapter(getSupportFragmentManager());
            vpnewsbycategory.setAdapter(mNewsByCategoryAdapter);

            mNewsByCategoryAdapter.addTab("Local News", new NewsByCategoryFragment());
            mNewsByCategoryAdapter.addTab("International News", new InternationalNewsByCategoryFragment());
            mNewsByCategoryAdapter.addTab("Sport News", new SportNewsByCategoryFragment());
            tbNewsByCategory.setupWithViewPager(vpnewsbycategory);


            vpnewsbycategory.setOffscreenPageLimit(mNewsByCategoryAdapter.getCount());

        }


    }
}
