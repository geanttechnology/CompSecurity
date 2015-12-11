// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import android.os.Bundle;
import android.util.Pair;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.at;
import com.google.android.gms.ads.a.c;
import com.google.android.gms.ads.a.e;
import com.google.android.gms.ads.c.a.a;
import java.util.ArrayList;
import java.util.Iterator;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            GooglePlayAdListener

public class GooglePlayDFPInterstitial
    implements MediatedInterstitialAdView
{

    private GooglePlayAdListener adListener;
    private e interstitialAd;

    public GooglePlayDFPInterstitial()
    {
    }

    private c buildRequest(at at1)
    {
        com.google.android.gms.ads.a.c.a a1 = new com.google.android.gms.ads.a.c.a();
        static class _cls1
        {

            static final int a[];

            static 
            {
                a = new int[com.appnexus.opensdk.k.c.values().length];
                try
                {
                    a[com.appnexus.opensdk.k.c.a.ordinal()] = 1;
                }
                catch (NoSuchFieldError nosuchfielderror2) { }
                try
                {
                    a[com.appnexus.opensdk.k.c.c.ordinal()] = 2;
                }
                catch (NoSuchFieldError nosuchfielderror1) { }
                try
                {
                    a[com.appnexus.opensdk.k.c.b.ordinal()] = 3;
                }
                catch (NoSuchFieldError nosuchfielderror)
                {
                    return;
                }
            }
        }

        com.appnexus.opensdk.mediatedviews._cls1.a[at1.c.ordinal()];
        JVM INSTR tableswitch 1 3: default 44
    //                   1 136
    //                   2 145
    //                   3 154;
           goto _L1 _L2 _L3 _L4
_L1:
        Bundle bundle;
        bundle = new Bundle();
        if (at1.a != null)
        {
            bundle.putString("Age", at1.a);
        }
        if (at1.d != null)
        {
            a1.a(at1.d);
        }
        Pair pair;
        for (at1 = at1.b.iterator(); at1.hasNext(); bundle.putString((String)pair.first, (String)pair.second))
        {
            pair = (Pair)at1.next();
        }

        break; /* Loop/switch isn't completed */
_L2:
        a1.a(0);
        continue; /* Loop/switch isn't completed */
_L3:
        a1.a(2);
        continue; /* Loop/switch isn't completed */
_L4:
        a1.a(1);
        if (true) goto _L1; else goto _L5
_L5:
        a1.a(new a(bundle));
        return a1.a();
    }

    public void destroy()
    {
        if (interstitialAd != null)
        {
            interstitialAd.a(null);
            interstitialAd = null;
            adListener = null;
        }
    }

    public boolean isReady()
    {
        return interstitialAd != null && interstitialAd.a();
    }

    public void onDestroy()
    {
        destroy();
    }

    public void onPause()
    {
    }

    public void onResume()
    {
    }

    public void requestAd(af af, Activity activity, String s, String s1, at at1)
    {
        adListener = new GooglePlayAdListener(af, super.getClass().getSimpleName());
        adListener.a(String.format(" - requesting an ad: [%s, %s]", new Object[] {
            s, s1
        }));
        interstitialAd = new e(activity);
        interstitialAd.a(s1);
        interstitialAd.a(adListener);
        interstitialAd.a(buildRequest(at1));
    }

    public void show()
    {
        adListener.a("show called");
        if (interstitialAd == null)
        {
            adListener.b("show called while interstitial ad view was null");
            return;
        }
        if (!interstitialAd.a())
        {
            adListener.b("show called while interstitial ad view was not ready");
            return;
        } else
        {
            interstitialAd.b();
            adListener.a("interstitial ad shown");
            return;
        }
    }
}
