package xyz.waiphyoag.news.Data.vo;

/**
 * Created by WaiPhyoAg on 12/17/17.
 */

public class FavoriteVO {
    private String favoriteID;
    private String favoriteDate;
    private ActedUserVO actedUser;

    public String getFavoriteID() {
        return favoriteID;
    }

    public String getFavoriteDate() {
        return favoriteDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
