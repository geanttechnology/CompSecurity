// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.picsart.studio.ads.lib;

import android.util.Log;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.MoPubInterstitial;

// Referenced classes of package com.picsart.studio.ads.lib:
//            AdsFactoryImpl

final class itialAdListener
    implements com.mopub.mobileads.InterstitialAdListener
{

    public final void onInterstitialClicked(MoPubInterstitial mopubinterstitial)
    {
        Log.i("MopubInterstitial", " Mopub Interstitial clicked");
    }

    public final void onInterstitialDismissed(MoPubInterstitial mopubinterstitial)
    {
        Log.i("MopubInterstitial", " Mopub Interstitial Dismissed");
        mopubinterstitial.destroy();
    }

    public final void onInterstitialFailed(MoPubInterstitial mopubinterstitial, MoPubErrorCode mopuberrorcode)
    {
        Log.i("MopubInterstitial", (new StringBuilder(" Mopub Interstitial Load failed errorCode = ")).append(mopuberrorcode).toString());
        mopubinterstitial.destroy();
    }

    public final void onInterstitialLoaded(MoPubInterstitial mopubinterstitial)
    {
        Log.i("MopubInterstitial", " Mopub Interstitial Loaded");
    }

    public final void onInterstitialShown(MoPubInterstitial mopubinterstitial)
    {
        Log.i("MopubInterstitial", " Mopub Interstitial shown");
    }

    itialAdListener()
    {
    }
}
