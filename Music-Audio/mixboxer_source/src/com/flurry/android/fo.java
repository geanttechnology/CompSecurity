// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.millennialmedia.android.MMAdView;
import com.millennialmedia.android.MMSDK;

// Referenced classes of package com.flurry.android:
//            AdNetworkView, AdCreative, fn, FlurryAds, 
//            cw

final class fo extends AdNetworkView
{

    private static final String p = com/flurry/android/fo.getSimpleName();
    private final String hJ;
    private final String q;

    fo(Context context, FlurryAds flurryads, cw cw, AdCreative adcreative, Bundle bundle)
    {
        super(context, flurryads, cw, adcreative);
        q = bundle.getString("com.flurry.millennial.MYAPID");
        hJ = bundle.getString("com.flurry.millennial.MYAPIDRECTANGLE");
        setFocusable(true);
    }

    static String d()
    {
        return p;
    }

    public final void initLayout(Context context)
    {
        char c;
        int i;
        int j;
        c = '2';
        i = getAdCreative().getWidth();
        j = getAdCreative().getHeight();
        Log.d(p, String.format("Ad space width: %d Ad space height: %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(j)
        }));
        if ((i < 320 || j < 50) && (i < 300 || j < 250)) goto _L2; else goto _L1
_L1:
        context = new MMAdView((Activity)context);
        setId(MMSDK.getDefaultAdId());
        if (i < 320 || j < 50) goto _L4; else goto _L3
_L3:
        context.setApid(q);
        if (i < 728 || j < 90) goto _L6; else goto _L5
_L5:
        i = 728;
        c = 'Z';
_L9:
        Log.d(p, String.format("Determined Millennial AdSize as %d x %d", new Object[] {
            Integer.valueOf(i), Integer.valueOf(c)
        }));
        context.setWidth(i);
        context.setHeight(c);
        setHorizontalScrollBarEnabled(false);
        setVerticalScrollBarEnabled(false);
        setGravity(17);
        context.setListener(new fn(this));
        addView(context);
        context.getAd();
        return;
_L6:
        if (i >= 480 && j >= 60)
        {
            i = 480;
            c = '<';
            continue; /* Loop/switch isn't completed */
        }
          goto _L7
_L4:
        if (i >= 300 && j >= 250)
        {
            context.setApid(hJ);
            c = '\372';
            i = 300;
            continue; /* Loop/switch isn't completed */
        }
          goto _L7
_L2:
        Log.d(p, "**********Could not load Millennial Ad");
        return;
_L7:
        i = 320;
        if (true) goto _L9; else goto _L8
_L8:
    }

}
