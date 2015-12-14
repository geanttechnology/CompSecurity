// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.mopub.mobileads:
//            GooglePlayServicesInterstitial, MoPubErrorCode

class <init> extends AdListener
{

    final GooglePlayServicesInterstitial this$0;

    public void onAdClosed()
    {
        if (GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this) != null)
        {
            GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this).onInterstitialDismissed();
        }
    }

    public void onAdFailedToLoad(int i)
    {
        if (GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this) != null)
        {
            GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this).onInterstitialFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLeftApplication()
    {
        if (GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this) != null)
        {
            GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this).onInterstitialClicked();
        }
    }

    public void onAdLoaded()
    {
        if (GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this) != null)
        {
            GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this).onInterstitialLoaded();
        }
    }

    public void onAdOpened()
    {
        if (GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this) != null)
        {
            GooglePlayServicesInterstitial.access$100(GooglePlayServicesInterstitial.this).onInterstitialShown();
        }
    }

    private r()
    {
        this$0 = GooglePlayServicesInterstitial.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
