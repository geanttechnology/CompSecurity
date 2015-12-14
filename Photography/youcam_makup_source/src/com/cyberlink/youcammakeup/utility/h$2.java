// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.cyberlink.youcammakeup.utility;

import com.google.android.gms.ads.AdListener;
import com.pf.common.utility.m;

// Referenced classes of package com.cyberlink.youcammakeup.utility:
//            h

class init> extends AdListener
{

    final h a;

    public void onAdClosed()
    {
    }

    public void onAdFailedToLoad(int i)
    {
        m.c(h.g(), (new StringBuilder()).append("PublisherInterstitialAd onAdFailedToLoad : ").append(h.a(i)).toString());
    }

    public void onAdLoaded()
    {
        m.c(h.g(), "PublisherInterstitialAd onAdLoaded");
    }

    (h h1)
    {
        a = h1;
        super();
    }
}
