package xyz.waiphyoag.news.viewholders;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

import org.w3c.dom.Text;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import xyz.waiphyoag.news.Data.vo.NewsVO;
import xyz.waiphyoag.news.R;
import xyz.waiphyoag.news.delegates.NewsActionDelegates;

/**
 * Created by WaiPhyoAg on 12/3/17.
 */

public class ItemNewsViewsHolder extends RecyclerView.ViewHolder {
    @BindView(R.id.iv_publication_logo)
    ImageView publicationlogo;
    @BindView(R.id.tv_publication_time)
    TextView publicationTime;
    @BindView(R.id.tv_news)
    TextView publicationNews;
    @BindView(R.id.tv_publication_title)
    TextView publicationTitle;
    @BindView(R.id.iv_news_pic)
    ImageView newspic;

    private NewsActionDelegates mnewNewsActionDelegates;
    public ItemNewsViewsHolder(View itemView, NewsActionDelegates newsActionDelegates) {
        super(itemView);
        ButterKnife.bind(this,itemView);
        mnewNewsActionDelegates=newsActionDelegates;

    }

    @OnClick(R.id.cv_news_item_root)
    public void onNewsItemTap()
    {
        mnewNewsActionDelegates.onTapNewsItem();

    }
    public void setNews(NewsVO news)
    {
        publicationTitle.setText(news.getPublication().getTitle());
        publicationTime.setText(news.getPostedDate());
        publicationNews.setText(news.getBrief());



        Glide.with(publicationlogo.getContext())
                .load(news.getPublication().getLogo())
                .into(publicationlogo);
        if(news.getImages()!=null)
        {
            newspic.setVisibility(View.VISIBLE);
            Glide.with(newspic.getContext())
                    .load(news.getImages().get(0))
                    .into(newspic);
        }
        else
        {
            newspic.setVisibility(View.GONE);
        }

    }


}

/*
Glide.with(ivPublicationLogo.getContext())
        .load(news.getPublication().getLogo())
        .into(ivPublicationLogo);

        if (news.getImages() != null) {
        ivPublicationImage.setVisibility(View.VISIBLE);
        Glide.with(ivPublicationImage.getContext())
        .load(news.getImages().get(0))
        .into(ivPublicationImage);
        } else {
        ivPublicationImage.setVisibility(View.GONE);
        }*/
