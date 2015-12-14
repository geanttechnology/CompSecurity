// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.CtaButtonDrawable;

public class VastVideoCtaButtonWidget extends ImageView
{

    private CtaButtonDrawable mCtaButtonDrawable;
    private boolean mHasClickthroughUrl;
    private boolean mHasCompanionAd;
    private boolean mIsVideoComplete;
    private boolean mIsVideoSkippable;
    private final android.widget.RelativeLayout.LayoutParams mLandscapeLayoutParams;
    private final android.widget.RelativeLayout.LayoutParams mPortraitLayoutParams;

    public VastVideoCtaButtonWidget(Context context, int i, boolean flag, boolean flag1)
    {
        super(context);
        mHasCompanionAd = flag;
        mHasClickthroughUrl = flag1;
        setId((int)Utils.generateUniqueId());
        int j = Dips.dipsToIntPixels(200F, context);
        int k = Dips.dipsToIntPixels(42F, context);
        int l = Dips.dipsToIntPixels(16F, context);
        mCtaButtonDrawable = new CtaButtonDrawable(context);
        setImageDrawable(mCtaButtonDrawable);
        mLandscapeLayoutParams = new android.widget.RelativeLayout.LayoutParams(j, k);
        mLandscapeLayoutParams.setMargins(l, l, l, l);
        mLandscapeLayoutParams.addRule(8, i);
        mLandscapeLayoutParams.addRule(7, i);
        mPortraitLayoutParams = new android.widget.RelativeLayout.LayoutParams(j, k);
        mPortraitLayoutParams.setMargins(l, l, l, l);
        mPortraitLayoutParams.addRule(3, i);
        mPortraitLayoutParams.addRule(14);
        updateLayoutAndVisibility();
    }

    private void updateLayoutAndVisibility()
    {
        if (!mHasClickthroughUrl)
        {
            setVisibility(8);
            return;
        }
        if (!mIsVideoSkippable)
        {
            setVisibility(4);
            return;
        }
        if (mIsVideoComplete && mHasCompanionAd)
        {
            setVisibility(8);
            return;
        }
        switch (getResources().getConfiguration().orientation)
        {
        default:
            MoPubLog.d("Unrecognized screen orientation: CTA button widget defaulting to portrait layout");
            setVisibility(0);
            setLayoutParams(mPortraitLayoutParams);
            return;

        case 2: // '\002'
            setVisibility(0);
            setLayoutParams(mLandscapeLayoutParams);
            return;

        case 1: // '\001'
            setVisibility(0);
            setLayoutParams(mPortraitLayoutParams);
            return;

        case 0: // '\0'
            MoPubLog.d("Screen orientation undefined: CTA button widget defaulting to portrait layout");
            setVisibility(0);
            setLayoutParams(mPortraitLayoutParams);
            return;

        case 3: // '\003'
            MoPubLog.d("Screen orientation is deprecated ORIENTATION_SQUARE: CTA button widget defaulting to portrait layout");
            break;
        }
        setVisibility(0);
        setLayoutParams(mPortraitLayoutParams);
    }

    String getCtaText()
    {
        return mCtaButtonDrawable.getCtaText();
    }

    boolean hasLandscapeLayoutParams()
    {
        return getLayoutParams().equals(mLandscapeLayoutParams);
    }

    boolean hasPortraitLayoutParams()
    {
        return getLayoutParams().equals(mPortraitLayoutParams);
    }

    void notifyVideoComplete()
    {
        mIsVideoSkippable = true;
        mIsVideoComplete = true;
        updateLayoutAndVisibility();
    }

    void notifyVideoSkippable()
    {
        mIsVideoSkippable = true;
        updateLayoutAndVisibility();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updateLayoutAndVisibility();
    }

    void updateCtaText(String s)
    {
        mCtaButtonDrawable.setCtaText(s);
    }
}
