// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import android.content.Context;
import android.widget.ImageView;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Utils;
import com.mopub.mobileads.resource.RadialCountdownDrawable;

public class VastVideoRadialCountdownWidget extends ImageView
{

    private int mLastProgressMilliseconds;
    private RadialCountdownDrawable mRadialCountdownDrawable;

    public VastVideoRadialCountdownWidget(Context context)
    {
        super(context);
        setId((int)Utils.generateUniqueId());
        int i = Dips.dipsToIntPixels(45F, context);
        int j = Dips.dipsToIntPixels(16F, context);
        int k = Dips.dipsToIntPixels(16F, context);
        int l = Dips.dipsToIntPixels(5F, context);
        mRadialCountdownDrawable = new RadialCountdownDrawable(context);
        setImageDrawable(mRadialCountdownDrawable);
        setPadding(l, l, l, l);
        context = new android.widget.RelativeLayout.LayoutParams(i, i);
        context.setMargins(0, j, k, 0);
        context.addRule(11);
        setLayoutParams(context);
    }

    void calibrateAndMakeVisible(int i)
    {
        mRadialCountdownDrawable.setInitialCountdown(i);
        setVisibility(0);
    }

    RadialCountdownDrawable getImageViewDrawable()
    {
        return mRadialCountdownDrawable;
    }

    void setImageViewDrawable(RadialCountdownDrawable radialcountdowndrawable)
    {
        mRadialCountdownDrawable = radialcountdowndrawable;
    }

    void updateCountdownProgress(int i, int j)
    {
label0:
        {
            if (j >= mLastProgressMilliseconds)
            {
                if (i - j >= 0)
                {
                    break label0;
                }
                setVisibility(8);
            }
            return;
        }
        mRadialCountdownDrawable.updateCountdownProgress(j);
        mLastProgressMilliseconds = j;
    }
}
