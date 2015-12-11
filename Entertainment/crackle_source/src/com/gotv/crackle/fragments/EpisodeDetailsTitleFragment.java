// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.StarRatingLayoutHelper;

public class EpisodeDetailsTitleFragment extends Fragment
{

    private TextView mAudioText;
    private TextView mDurationText;
    private TextView mExpiresText;
    private TextView mRatingText;
    private View mStarRatingView;
    private TextView mSubtitlesText;
    private TextView mTitleText;

    public EpisodeDetailsTitleFragment()
    {
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030048, viewgroup, false);
        mTitleText = (TextView)layoutinflater.findViewById(0x7f0a00e7);
        mStarRatingView = layoutinflater.findViewById(0x7f0a00e8);
        mExpiresText = (TextView)layoutinflater.findViewById(0x7f0a00e9);
        mRatingText = (TextView)layoutinflater.findViewById(0x7f0a00ea);
        mDurationText = (TextView)layoutinflater.findViewById(0x7f0a00eb);
        mAudioText = (TextView)layoutinflater.findViewById(0x7f0a00ec);
        mSubtitlesText = (TextView)layoutinflater.findViewById(0x7f0a00ed);
        return layoutinflater;
    }

    public void setEpisodeDetailsAudio(String s)
    {
        if (s == null || Application.isFanhattan())
        {
            mAudioText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mAudioText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").append(s).toString());
            return;
        } else
        {
            mAudioText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00fa)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsDuration(String s)
    {
        if (s == null)
        {
            mDurationText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mDurationText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").append(s).toString());
            return;
        } else
        {
            mDurationText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a9)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsExpires(String s)
    {
        if (s == null)
        {
            mExpiresText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mExpiresText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").append(s).toString());
            return;
        } else
        {
            mExpiresText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a7)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsRating(String s)
    {
        if (s == null)
        {
            mRatingText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mRatingText.setText((new StringBuilder()).append(getResources().getString(0x7f0b00a8)).append(" ").append(s).toString());
            return;
        } else
        {
            mRatingText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b00a8)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsStarRating(Integer integer)
    {
        if (integer == null)
        {
            mStarRatingView.setVisibility(8);
            return;
        } else
        {
            StarRatingLayoutHelper.setStarRating(mStarRatingView, integer.intValue());
            return;
        }
    }

    public void setEpisodeDetailsSubtitles(String s)
    {
        if (s == null || Application.isFanhattan())
        {
            mSubtitlesText.setVisibility(8);
            return;
        }
        if (Application.getInstance().isTablet())
        {
            mSubtitlesText.setText((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").append(s).toString());
            return;
        } else
        {
            mSubtitlesText.setText(Application.setStringColor((new StringBuilder()).append(getResources().getString(0x7f0b0106)).append(" ").toString(), s));
            return;
        }
    }

    public void setEpisodeDetailsTitle(String s)
    {
        if (s == null)
        {
            mTitleText.setVisibility(8);
            return;
        } else
        {
            mTitleText.setText(s);
            return;
        }
    }
}
