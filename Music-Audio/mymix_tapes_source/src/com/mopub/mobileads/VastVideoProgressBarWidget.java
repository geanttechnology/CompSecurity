// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.ProgressBarDrawable;

public class VastVideoProgressBarWidget extends ImageView
{

    private ProgressBarDrawable mProgressBarDrawable;
    private final int mProgressBarHeight;

    public VastVideoProgressBarWidget(Context context)
    {
        super(context);
        setId((int)Utils.generateUniqueId());
        mProgressBarDrawable = new ProgressBarDrawable(context);
        setImageDrawable(mProgressBarDrawable);
        mProgressBarHeight = Dips.dipsToIntPixels(4F, context);
    }

    public void calibrateAndMakeVisible(int i, int j)
    {
        mProgressBarDrawable.setDurationAndSkipOffset(i, j);
        setVisibility(0);
    }

    ProgressBarDrawable getImageViewDrawable()
    {
        return mProgressBarDrawable;
    }

    public void reset()
    {
        mProgressBarDrawable.reset();
        mProgressBarDrawable.setProgress(0);
    }

    public void setAnchorId(int i)
    {
        android.widget.RelativeLayout.LayoutParams layoutparams = new android.widget.RelativeLayout.LayoutParams(-1, mProgressBarHeight);
        layoutparams.addRule(8, i);
        setLayoutParams(layoutparams);
    }

    void setImageViewDrawable(ProgressBarDrawable progressbardrawable)
    {
        mProgressBarDrawable = progressbardrawable;
    }

    public void updateProgress(int i)
    {
        mProgressBarDrawable.setProgress(i);
    }
}
