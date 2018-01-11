package xyz.waiphyoag.news.Data.models;


import xyz.waiphyoag.news.network.HttpUrlConnectionDataAgent;
import xyz.waiphyoag.news.network.NewsDataAgent;
import xyz.waiphyoag.news.network.OkHttpDataAgent;
import xyz.waiphyoag.news.network.RetrofitDataAgent;

/**
 * Created by WaiPhyoAg on 12/23/17.
 */

public class NewsModel {

    private static NewsModel sObjInstance;
    private NewsDataAgent mDataAgent;


    private NewsModel() {

//        /*mDataAgent= HttpUrlConnectionDataAgent.getsObjinstance();*/
//        mDataAgent = OkHttpDataAgent.getsObjInstance();
      mDataAgent= RetrofitDataAgent.getsObjInstance();
    }

    public static NewsModel getsObjInstance() {
        if (sObjInstance == null) {
            sObjInstance = new NewsModel();
        }
        return sObjInstance;
    }

    /**
     * Load news from network api.
     */
    public void loadNews()
    {
        mDataAgent.loadNews();
    }

}
