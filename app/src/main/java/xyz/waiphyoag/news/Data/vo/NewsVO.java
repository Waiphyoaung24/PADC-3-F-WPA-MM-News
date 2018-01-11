package xyz.waiphyoag.news.Data.vo;

import com.google.gson.annotations.SerializedName;

import java.lang.reflect.Array;
import java.util.List;

/**
 * Created by WaiPhyoAg on 12/17/17.
 */

public class NewsVO {
    @SerializedName("news-id")
    private String newsId;
    private String brief;
    private String details;
    @SerializedName("posted-date")
    private String postedDate;
    private List<String> images;

    private PublicationVO publication;
    private List<FavoriteVO> favorites;
    private List<CommentVO>  comments;
    @SerializedName("sent-tos")
    private List<SentTosVO> sentTos;

    public String getNewsId() {
        return newsId;
    }

    public String getBrief() {
        return brief;
    }

    public String getDetail() {
        return details;
    }

    public String getPostedDate() {
        return postedDate;
    }

    public List<String> getImages() {
        return images;
    }

    public PublicationVO getPublication() {
        return publication;
    }

    public List<FavoriteVO> getFavorites() {
        return favorites;
    }

    public List<CommentVO> getComment() {
        return comments;
    }


}


