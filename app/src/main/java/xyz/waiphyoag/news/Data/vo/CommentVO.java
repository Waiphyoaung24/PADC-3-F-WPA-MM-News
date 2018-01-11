package xyz.waiphyoag.news.Data.vo;

/**
 * Created by WaiPhyoAg on 12/17/17.
 */

public class CommentVO {

    private String commentID;
    private String comment;
    private String commentDate;
    private ActedUserVO actedUser;

    public String getCommentID() {
        return commentID;
    }

    public String getComment() {
        return comment;
    }

    public String getCommentDate() {
        return commentDate;
    }

    public ActedUserVO getActedUser() {
        return actedUser;
    }
}
