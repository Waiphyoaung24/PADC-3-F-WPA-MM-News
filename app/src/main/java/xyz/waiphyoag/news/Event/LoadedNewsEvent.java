package xyz.waiphyoag.news.Event;

import java.util.List;

import xyz.waiphyoag.news.Data.vo.NewsVO;

/**
 * Created by WaiPhyoAg on 1/6/18.
 */

public class LoadedNewsEvent {
    private List<NewsVO>news;
    public LoadedNewsEvent(List<NewsVO>news)
    {
        this.news=news ;
    }

    public List<NewsVO> getNews() {
        return news;
    }
}
