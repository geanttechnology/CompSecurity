// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import com.inmobi.androidsdk.IMAdRequest;
import com.inmobi.androidsdk.IMAdView;

// Referenced classes of package com.flurry.android:
//            AdNetworkView, ew, FlurryAds, cw, 
//            AdCreative

final class ad extends AdNetworkView
{

    private static final String p = com/flurry/android/ad.getSimpleName();
    private final boolean bU;
    private final String q;

    ad(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        super(context, flurryads, cw, adcreative);
        q = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        bU = bundle.getBoolean("com.flurry.inmobi.test");
        setFocusable(true);
    }

    static String d()
    {
        return p;
    }

    public final void initLayout(Context context)
    {
        int j = 320;
        int k = 50;
        DisplayMetrics displaymetrics = context.getResources().getDisplayMetrics();
        int i = (int)((float)displaymetrics.heightPixels / displaymetrics.density);
        int l = (int)((float)displaymetrics.widthPixels / displaymetrics.density);
        if (l >= 728 && i >= 90)
        {
            Log.d(p, "Determined InMobi AdSize as 728x90");
            i = 11;
        } else
        if (l >= 468 && i >= 60)
        {
            Log.d(p, "Determined InMobi AdSize as 468x60");
            i = 12;
        } else
        if (l >= 320 && i >= 50)
        {
            Log.d(p, "Determined InMobi AdSize as 320x50");
            i = 15;
        } else
        if (l >= 300 && i >= 250)
        {
            Log.d(p, "Determined InMobi AdSize as 300x250");
            i = 10;
        } else
        if (l >= 120 && i >= 600)
        {
            Log.d(p, "Determined InMobi AdSize as 120x600");
            i = 13;
        } else
        {
            Log.d(p, "Could not find InMobi AdSize that matches size");
            i = -1;
        }
        if (i != -1)
        {
            context = new IMAdView((Activity)context, i, q);
            if (i != 15);
            if (i == 11)
            {
                j = 728;
                k = 90;
            }
            if (i == 12)
            {
                j = 468;
                k = 60;
            }
            if (i == 10)
            {
                j = 300;
                k = 250;
            }
            if (i == 13)
            {
                j = 120;
                k = 600;
            }
            float f = getResources().getDisplayMetrics().density;
            context.setLayoutParams(new android.widget.LinearLayout.LayoutParams((int)((float)j * f + 0.5F), (int)((float)k * f + 0.5F)));
            context.setIMAdListener(new ew(this));
            setGravity(17);
            addView(context);
            IMAdRequest imadrequest = new IMAdRequest();
            if (bU)
            {
                Log.d(p, "InMobi AdView set to Test Mode.");
                imadrequest.setTestMode(true);
            }
            context.setIMAdRequest(imadrequest);
            context.setRefreshInterval(-1);
            context.loadNewAd();
            return;
        } else
        {
            Log.d(p, "**********Could not load InMobi Ad");
            return;
        }
    }

}
