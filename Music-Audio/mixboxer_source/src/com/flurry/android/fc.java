// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.util.Log;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixIABRectangleMAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;

// Referenced classes of package com.flurry.android:
//            AdNetworkView, AdCreative, as, FlurryAds, 
//            cw

class fc extends AdNetworkView
{

    private static final String p = com/flurry/android/fc.getSimpleName();

    fc(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative)
    {
        super(context, flurryads, cw, adcreative);
        setFocusable(true);
    }

    static String d()
    {
        return p;
    }

    public void initLayout(Context context)
    {
        int i = 320;
        int j = getAdCreative().getHeight();
        int k = getAdCreative().getWidth();
        float f;
        if (k >= 320 && j >= 50)
        {
            Log.d(p, "Determined Mobclix AdSize as BANNER");
            context = new MobclixMMABannerXLAdView((Activity)context);
        } else
        if (k >= 300 && j >= 250)
        {
            Log.d(p, "Determined Mobclix AdSize as IAB_RECT");
            context = new MobclixIABRectangleMAdView((Activity)context);
        } else
        {
            Log.d(p, "Could not find Mobclix AdSize that matches size");
            context = null;
        }
        context.addMobclixAdViewListener(new as(this));
        if (!(context instanceof MobclixMMABannerXLAdView));
        if (context instanceof MobclixIABRectangleMAdView)
        {
            j = 250;
        } else
        {
            i = 300;
            j = 50;
        }
        f = getResources().getDisplayMetrics().density;
        context.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)((float)i * f + 0.5F), (int)((float)j * f + 0.5F)));
        setGravity(17);
        addView(context);
        context.setRefreshTime(-1L);
    }

}
