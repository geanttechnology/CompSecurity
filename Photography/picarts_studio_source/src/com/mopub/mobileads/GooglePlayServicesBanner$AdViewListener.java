// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mobileads;

import com.google.android.gms.ads.AdListener;

// Referenced classes of package com.mopub.mobileads:
//            GooglePlayServicesBanner, MoPubErrorCode

class <init> extends AdListener
{

    final GooglePlayServicesBanner this$0;

    public void onAdClosed()
    {
    }

    public void onAdFailedToLoad(int i)
    {
        if (GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this) != null)
        {
            GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this).onBannerFailed(MoPubErrorCode.NETWORK_NO_FILL);
        }
    }

    public void onAdLeftApplication()
    {
    }

    public void onAdLoaded()
    {
        if (GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this) != null)
        {
            GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this).onBannerLoaded(GooglePlayServicesBanner.access$200(GooglePlayServicesBanner.this));
        }
    }

    public void onAdOpened()
    {
        if (GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this) != null)
        {
            GooglePlayServicesBanner.access$100(GooglePlayServicesBanner.this).onBannerClicked();
        }
    }

    private ner()
    {
        this$0 = GooglePlayServicesBanner.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
