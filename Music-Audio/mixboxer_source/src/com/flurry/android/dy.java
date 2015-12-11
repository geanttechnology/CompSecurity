// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.android;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import com.inmobi.androidsdk.IMAdInterstitial;
import com.inmobi.androidsdk.IMAdRequest;
import java.lang.reflect.Method;

// Referenced classes of package com.flurry.android:
//            do, bp, FlurryAds, cw, 
//            AdUnit

class dy extends do
{

    private static final String p = com/flurry/android/dy.getSimpleName();
    private final boolean bU;
    private final Method fH;
    private final String q;

    public dy(Context context, FlurryAds flurryads, cw cw, AdUnit adunit, Bundle bundle)
    {
        int i;
        int j;
        super(context, flurryads, cw, adunit);
        q = bundle.getString("com.flurry.inmobi.MY_APP_ID");
        bU = bundle.getBoolean("com.flurry.inmobi.test");
        cw = com/inmobi/androidsdk/IMAdInterstitial.getMethods();
        j = cw.length;
        i = 0;
_L5:
        if (i >= j)
        {
            break MISSING_BLOCK_LABEL_101;
        }
        flurryads = cw[i];
        adunit = flurryads.getName();
        context = flurryads;
        if (adunit.equals("setIMAdInterstitialListener")) goto _L2; else goto _L1
_L1:
        if (!adunit.equals("setImAdInterstitialListener")) goto _L4; else goto _L3
_L3:
        context = flurryads;
_L2:
        fH = context;
        return;
_L4:
        i++;
          goto _L5
        context = null;
          goto _L2
    }

    static String d()
    {
        return p;
    }

    public final void M()
    {
        IMAdInterstitial imadinterstitial = new IMAdInterstitial((Activity)getContext(), q);
        Object obj = new bp(this);
        if (fH != null && imadinterstitial != null)
        {
            try
            {
                fH.invoke(imadinterstitial, new Object[] {
                    obj
                });
            }
            catch (Exception exception) { }
        }
        obj = new IMAdRequest();
        if (bU)
        {
            Log.d(p, "InMobi Interstitial set to Test Mode.");
            ((IMAdRequest) (obj)).setTestMode(true);
        }
        imadinterstitial.loadNewAd(((IMAdRequest) (obj)));
    }

}
