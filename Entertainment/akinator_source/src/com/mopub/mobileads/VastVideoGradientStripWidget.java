// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.util.Dips;

public class VastVideoGradientStripWidget extends ImageView
{

    com.mopub.common.util.DeviceUtils.ForceOrientation mForceOrientation;
    private boolean mHasCompanionAd;
    private boolean mIsVideoComplete;
    private int mVisibilityForCompanionAd;

    public VastVideoGradientStripWidget(Context context, android.graphics.drawable.GradientDrawable.Orientation orientation, com.mopub.common.util.DeviceUtils.ForceOrientation forceorientation, boolean flag, int i, int j, int k)
    {
        super(context);
        mForceOrientation = forceorientation;
        mVisibilityForCompanionAd = i;
        mHasCompanionAd = flag;
        setImageDrawable(new GradientDrawable(orientation, new int[] {
            com.mopub.mobileads.resource.DrawableConstants.GradientStrip.START_COLOR, com.mopub.mobileads.resource.DrawableConstants.GradientStrip.END_COLOR
        }));
        context = new android.widget.RelativeLayout.LayoutParams(-1, Dips.dipsToIntPixels(72F, context));
        context.addRule(j, k);
        setLayoutParams(context);
        updateVisibility();
    }

    private void updateVisibility()
    {
        if (mIsVideoComplete)
        {
            if (mHasCompanionAd)
            {
                setVisibility(mVisibilityForCompanionAd);
                return;
            } else
            {
                setVisibility(8);
                return;
            }
        }
        if (mForceOrientation == com.mopub.common.util.DeviceUtils.ForceOrientation.FORCE_PORTRAIT)
        {
            setVisibility(4);
            return;
        }
        if (mForceOrientation == com.mopub.common.util.DeviceUtils.ForceOrientation.FORCE_LANDSCAPE)
        {
            setVisibility(0);
            return;
        }
        switch (getResources().getConfiguration().orientation)
        {
        default:
            MoPubLog.d("Unrecognized screen orientation: do not show gradient strip widget");
            setVisibility(4);
            return;

        case 2: // '\002'
            setVisibility(0);
            return;

        case 1: // '\001'
            setVisibility(4);
            return;

        case 0: // '\0'
            MoPubLog.d("Screen orientation undefined: do not show gradient strip widget");
            setVisibility(4);
            return;

        case 3: // '\003'
            MoPubLog.d("Screen orientation is deprecated ORIENTATION_SQUARE: do not show gradient strip widget");
            break;
        }
        setVisibility(4);
    }

    void notifyVideoComplete()
    {
        mIsVideoComplete = true;
        updateVisibility();
    }

    protected void onConfigurationChanged(Configuration configuration)
    {
        super.onConfigurationChanged(configuration);
        updateVisibility();
    }
}
