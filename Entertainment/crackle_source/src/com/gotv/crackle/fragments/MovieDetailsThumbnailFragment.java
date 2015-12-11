// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.gotv.crackle.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ProgressBar;
import com.gotv.crackle.Application;
import com.gotv.crackle.helpers.SharedPrefsManager;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;

public class MovieDetailsThumbnailFragment extends Fragment
{
    public static interface MovieDetailsThumbnailListener
    {

        public abstract void onMovieDetailsPlayClick();
    }


    private MovieDetailsThumbnailListener mListener;
    private ProgressBar mProgressView;
    private ImageView mThumbnailView;

    public MovieDetailsThumbnailFragment()
    {
    }

    private void setThumbnailSize()
    {
        int i;
        if (Application.getInstance().isTablet())
        {
            if (Application.getInstance().isLandscape())
            {
                i = (Application.getScreenWidth() / 50) * 11;
            } else
            {
                i = (Application.getScreenWidth() / 5) * 2;
            }
        } else
        if (Application.getInstance().isLandscape())
        {
            i = Application.getScreenWidth() / 4;
        } else
        {
            i = Application.getScreenWidth() / 3;
        }
        mThumbnailView.getLayoutParams().width = i;
        mThumbnailView.getLayoutParams().height = Application.getHeightFromAspectRatio(i);
    }

    public void onAttach(Activity activity)
    {
        super.onAttach(activity);
        try
        {
            mListener = (MovieDetailsThumbnailListener)activity;
            return;
        }
        catch (ClassCastException classcastexception)
        {
            throw new ClassCastException((new StringBuilder()).append(activity.toString()).append(" must implement MovieDetailsThumbnailListener.").toString());
        }
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = layoutinflater.inflate(0x7f030058, viewgroup, false);
        mThumbnailView = (ImageView)layoutinflater.findViewById(0x7f0a0099);
        mProgressView = (ProgressBar)layoutinflater.findViewById(0x7f0a00ee);
        ((ImageButton)layoutinflater.findViewById(0x7f0a007e)).setOnClickListener(new android.view.View.OnClickListener() {

            final MovieDetailsThumbnailFragment this$0;

            public void onClick(View view)
            {
                mListener.onMovieDetailsPlayClick();
            }

            
            {
                this$0 = MovieDetailsThumbnailFragment.this;
                super();
            }
        });
        return layoutinflater;
    }

    public void onResume()
    {
        super.onResume();
        setThumbnailSize();
    }

    public void setProgress(String s, String s1)
    {
        int i = (int)Math.round(((double)SharedPrefsManager.getPlayProgressForItem(s) / (double)(Integer.parseInt(s1) * 1000)) * 100D);
        mProgressView.setProgress(i);
    }

    public void setThumbnail(String s, ImageLoader imageloader, DisplayImageOptions displayimageoptions)
    {
        imageloader.displayImage(s, mThumbnailView, displayimageoptions);
    }

}
