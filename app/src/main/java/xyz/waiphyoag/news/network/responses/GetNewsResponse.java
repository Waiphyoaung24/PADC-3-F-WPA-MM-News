package xyz.waiphyoag.news.network.responses;

import java.util.List;

import xyz.waiphyoag.news.Data.vo.NewsVO;

/**
 * Created by WaiPhyoAg on 1/4/18.
 */

public class GetNewsResponse {
    private int code;
    private String message;
    private String apiVersion;
    private String page;
    private List<NewsVO>mmNews;

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getPage() {
        return page;
    }

    public List<NewsVO> getNews() {
        return mmNews;
    }
}
