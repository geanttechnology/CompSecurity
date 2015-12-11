// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import com.google.ads.AdRequest;
import com.google.ads.InterstitialAd;

// Referenced classes of package com.flurry.android:
//            do, gm, FlurryAds, cw, 
//            AdUnit

final class eo extends do
{

    private static final String p = com/flurry/android/eo.getSimpleName();
    private final boolean bU;
    private final String gn;
    private final InterstitialAd go;
    private final String q;

    public eo(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        super(context, flurryads, cw, adunit);
        q = bundle.getString("com.flurry.admob.MY_AD_UNIT_ID");
        gn = bundle.getString("com.flurry.admob.MYTEST_AD_DEVICE_ID");
        bU = bundle.getBoolean("com.flurry.admob.test");
        go = new InterstitialAd((Activity)getContext(), q);
        go.setAdListener(new gm(this));
    }

    static InterstitialAd a(eo eo1)
    {
        return eo1.go;
    }

    static String aV()
    {
        return p;
    }

    public final void M()
    {
        AdRequest adrequest = new AdRequest();
        if (bU)
        {
            Log.d(p, "Admob AdView set to Test Mode.");
            adrequest.addTestDevice(AdRequest.TEST_EMULATOR);
            if (!TextUtils.isEmpty(gn))
            {
                adrequest.addTestDevice(gn);
            }
        }
        go.loadAd(adrequest);
    }

}
