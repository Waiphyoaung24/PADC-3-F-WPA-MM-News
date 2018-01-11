package xyz.waiphyoag.news.adapters;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by WaiPhyoAg on 1/7/18.
 */

public class NewsByCategoryAdapter extends FragmentStatePagerAdapter {

    private List<Fragment> mFragments;
    private List<String> mTabTitles;

    public NewsByCategoryAdapter(FragmentManager fm) {
        super(fm);
        mFragments = new ArrayList<>();
        mTabTitles = new ArrayList<>();
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }


    public void addTab(String tabTitles, Fragment fragment) {
        mTabTitles.add(tabTitles);
        mFragments.add(fragment);
        notifyDataSetChanged();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTabTitles.get(position) ;
    }
}
