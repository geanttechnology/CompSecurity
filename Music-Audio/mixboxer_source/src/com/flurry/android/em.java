// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.ads.AdSize;
import com.google.ads.AdView;

// Referenced classes of package com.flurry.android:
//            AdNetworkView, AdCreative, cy, w, 
//            FlurryAds, cw

final class em extends AdNetworkView
{

    private static final String gm = com/flurry/android/em.getSimpleName();
    private final boolean bU;
    private final String gn;
    private final String q;

    public em(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        super(context, flurryads, cw, adcreative);
        q = bundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
        gn = bundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
        bU = bundle.getBoolean("com.flurry.admob.test");
        setFocusable(true);
    }

    static String ap()
    {
        return gm;
    }

    public final void initLayout(Context context)
    {
        int k = getAdCreative().getWidth();
        int l = getAdCreative().getHeight();
        Object obj = context.getResources().getDisplayMetrics();
        int i1 = (int)((float)((DisplayMetrics) (obj)).heightPixels / ((DisplayMetrics) (obj)).density);
        int j = (int)((float)((DisplayMetrics) (obj)).widthPixels / ((DisplayMetrics) (obj)).density);
        int i = j;
        if (k > 0)
        {
            if (k > j)
            {
                i = j;
            } else
            {
                i = k;
            }
        }
        j = i1;
        if (l > 0)
        {
            if (l > i1)
            {
                j = i1;
            } else
            {
                j = l;
            }
        }
        if (i >= 728 && j >= 90)
        {
            obj = AdSize.IAB_LEADERBOARD;
        } else
        if (i >= 468 && j >= 60)
        {
            obj = AdSize.IAB_BANNER;
        } else
        if (i >= 320 && j >= 50)
        {
            obj = AdSize.BANNER;
        } else
        if (i >= 300 && j >= 250)
        {
            obj = AdSize.IAB_MRECT;
        } else
        {
            Log.d("FlurryAgent", "Could not find AdMob AdSize that matches size");
            obj = null;
        }
        if (obj == null)
        {
            cy.d(gm, (new StringBuilder()).append("Could not find Admob AdSize that matches {width = ").append(k).append(", height ").append(l).append("}").toString());
            return;
        }
        cy.c(gm, (new StringBuilder()).append("Determined Admob AdSize as ").append(obj).append(" that best matches {width = ").append(k).append(", height = ").append(l).append("}").toString());
        AdView adview = new AdView((Activity)context, ((AdSize) (obj)), q);
        adview.setAdListener(new w(this));
        setGravity(17);
        addView(adview, new android.widget.RelativeLayout.LayoutParams(((AdSize) (obj)).getWidthInPixels(context), ((AdSize) (obj)).getHeightInPixels(context)));
        context = new AdRequest();
        if (bU)
        {
            cy.c(gm, "Admob AdView set to Test Mode.");
            context.addTestDevice(AdRequest.TEST_EMULATOR);
            if (!TextUtils.isEmpty(gn))
            {
                context.addTestDevice(gn);
            }
        }
        adview.loadAd(context);
    }

}
