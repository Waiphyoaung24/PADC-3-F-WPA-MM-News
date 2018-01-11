package xyz.waiphyoag.news.Data.vo;

/**
 * Created by WaiPhyoAg on 12/17/17.
 */

public class SentTosVO {
    public String getSenttoID() {
        return senttoID;
    }

    public String getSentDate() {
        return sentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }

    public ActedUserVO getReceivedUser() {
        return receivedUser;
    }

    private String senttoID;
    private String sentDate;
    private ActedUserVO actedUser;
    private ActedUserVO receivedUser;
}
