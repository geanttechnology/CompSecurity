// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.appnexus.opensdk.mediatedviews;

import android.app.Activity;
import com.appnexus.opensdk.MediatedInterstitialAdView;
import com.appnexus.opensdk.af;
import com.appnexus.opensdk.at;
import com.appnexus.opensdk.b.b;
import com.mopub.mobileads.t;

// Referenced classes of package com.appnexus.opensdk.mediatedviews:
//            MoPubListener

public class MoPubInterstitialAdView
    implements MediatedInterstitialAdView
{

    private t interstitialAd;
    private MoPubListener mpListener;

    public MoPubInterstitialAdView()
    {
    }

    public void destroy()
    {
        if (interstitialAd != null)
        {
            interstitialAd.a(null);
            mpListener = null;
            interstitialAd.h();
            interstitialAd = null;
        }
    }

    public boolean isReady()
    {
        return interstitialAd != null && interstitialAd.f();
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
        mpListener = new MoPubListener(af, getClass().getSimpleName());
        interstitialAd = new t(activity, s1);
        interstitialAd.a(mpListener);
        if (at != null)
        {
            af = MoPubListener.a(at);
            interstitialAd.a(af);
        }
        interstitialAd.e();
    }

    public void show()
    {
        b.b(b.c, "show called");
        if (!isReady())
        {
            b.b(b.c, "show called while interstitial ad view was unavailable");
            return;
        }
        if (interstitialAd.g())
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
