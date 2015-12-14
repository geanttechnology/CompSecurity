// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.content.Context;
import android.os.Handler;
import android.util.Log;
import com.facebook.ads.Ad;
import com.facebook.ads.AdError;
import com.facebook.ads.InterstitialAdListener;
import com.fotoable.ad.StaticFlurryEvent;

class gv
    implements InterstitialAdListener
{

    final gu a;

    gv(gu gu1)
    {
        a = gu1;
        super();
    }

    public void onAdClicked(Ad ad)
    {
        Log.d(gt.b(a.d), (new StringBuilder()).append(gt.b(a.d)).append("onAdClicked").toString());
        StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adClicked);
    }

    public void onAdLoaded(Ad ad)
    {
        Log.d(gt.b(a.d), (new StringBuilder()).append(gt.b(a.d)).append(" onAdLoaded ").toString());
        StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adLoaded);
        if (a.c)
        {
            (new Handler(a.a.getMainLooper())).postDelayed(new gw(this, ad), 5000L);
        }
    }

    public void onError(Ad ad, AdError aderror)
    {
        a.d.a = false;
        Log.d(gt.b(a.d), (new StringBuilder()).append(gt.b(a.d)).append(" onError:").toString());
        StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adLoadedFailed);
    }

    public void onInterstitialDismissed(Ad ad)
    {
        Log.d(gt.b(a.d), (new StringBuilder()).append(gt.b(a.d)).append(" onInterstitialDismissed").toString());
    }

    public void onInterstitialDisplayed(Ad ad)
    {
        Log.d(gt.b(a.d), (new StringBuilder()).append(gt.b(a.d)).append(" onIterstitialDisplayed").toString());
        StaticFlurryEvent.logBannerEventWithKV("InterstitialAd_new", StaticFlurryEvent.adShown);
    }
}
