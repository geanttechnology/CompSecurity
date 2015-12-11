// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.facebook.ads.h;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            FacebookListener

public class FacebookInterstitial
    implements MediatedInterstitialAdView
{

    private h interstitialAd;

    public FacebookInterstitial()
    {
        interstitialAd = null;
    }

    public void destroy()
    {
        if (interstitialAd != null)
        {
            interstitialAd.b();
            try
            {
                interstitialAd.a(null);
            }
            catch (NullPointerException nullpointerexception) { }
            interstitialAd = null;
        }
    }

    public boolean isReady()
    {
        return interstitialAd != null && interstitialAd.c();
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

    public void requestAd(af af, Activity activity, String s, String s1, at at)
    {
        af = new FacebookListener(af, getClass().getSimpleName());
        interstitialAd = new h(activity, s1);
        interstitialAd.a(af);
        interstitialAd.a();
    }

    public void show()
    {
        b.b(b.c, "show called");
        if (!isReady())
        {
            b.b(b.c, "show called while interstitial ad view was unavailable");
            return;
        }
        if (interstitialAd.d())
        {
            b.b(b.c, "display called successfully");
            return;
        } else
        {
            b.b(b.c, "display call failed");
            return;
        }
    }
}
