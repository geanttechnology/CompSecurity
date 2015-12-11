// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.gotv.crackle.data.DetailsProvider;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.gotv.crackle.helpers.StarRatingLayoutHelper;

// Referenced classes of package com.gotv.crackle:
//            BaseMediaDetailsActivity, Application, ApplicationConstants

public class MovieDetailsActivity extends BaseMediaDetailsActivity
{

    private TextView mAudioText;
    private TextView mDurationText;
    private TextView mExpiresText;
    private ProgressBar mProgressView;
    private View mStarRatingView;
    private TextView mSubtitlesText;

    public MovieDetailsActivity()
    {
    }

    public void fillData()
    {
        super.fillData();
        int i = SharedPrefsManager.getPlayProgressForItem(mDetailsProvider.getMediaId());
        if (i > 0 && mDetailsProvider.getDurationInSeconds() != null)
        {
            i = (int)Math.round(((double)i / (double)(Integer.parseInt(mDetailsProvider.getDurationInSeconds()) * 1000)) * 100D);
            mProgressView.setProgress(i);
        }
        if (mDetailsProvider.getStarRating() == null)
        {
            mStarRatingView.setVisibility(8);
        } else
        {
            StarRatingLayoutHelper.setStarRating(mStarRatingView, mDetailsProvider.getStarRating().intValue());
        }
        if (mDetailsProvider.getExpires() == null)
        {
            mExpiresText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mExpiresText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").append(mDetailsProvider.getExpires()).toString());
        } else
        {
            mExpiresText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").toString(), mDetailsProvider.getExpires()));
        }
        if (mDetailsProvider.getDuration() == null)
        {
            mDurationText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mDurationText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").append(mDetailsProvider.getDuration()).toString());
        } else
        {
            mDurationText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").toString(), mDetailsProvider.getDuration()));
        }
        if (mDetailsProvider.getAudio() == null || Application.isFanhattan())
        {
            mAudioText.setVisibility(8);
        } else
        if (Application.getInstance().isTablet())
        {
            mAudioText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").append(mDetailsProvider.getAudio()).toString());
        } else
        {
            mAudioText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").toString(), mDetailsProvider.getAudio()));
        }
        if (mDetailsProvider.getSubtitles() == null || Application.isFanhattan())
        {
            mSubtitlesText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mSubtitlesText.setText((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").append(mDetailsProvider.getSubtitles()).toString());
            return;
        } else
        {
            mSubtitlesText.setText(setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").toString(), mDetailsProvider.getSubtitles()));
            return;
        }
    }

    public String getSectionName()
    {
        return ApplicationConstants.getFreeWheelMoviesSiteSection();
    }

    public void initViews()
    {
        super.initViews();
        mProgressView = (ProgressBar)findViewById(0x7f0a00ee);
        mStarRatingView = findViewById(0x7f0a00ff);
        mExpiresText = (TextView)findViewById(0x7f0a007d);
        mDurationText = (TextView)findViewById(0x7f0a0101);
        mAudioText = (TextView)findViewById(0x7f0a0102);
        mSubtitlesText = (TextView)findViewById(0x7f0a0103);
    }

    protected void onChannelDataSuccess()
    {
        runOnUiThread(new Runnable() {

            final MovieDetailsActivity this$0;

            public void run()
            {
                fillData();
            }

            
            {
                this$0 = MovieDetailsActivity.this;
                super();
            }
        });
    }

    protected void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        setContentView(0x7f030056);
        getIntentExtras();
        initViews();
    }

    protected void onResume()
    {
        if (mDetailsProvider != null && mDetailsProvider.getRequestState() == com.gotv.crackle.data.DataRequest.RequestState.COMPLETE)
        {
            fillData();
        }
        super.onResume();
    }
}
