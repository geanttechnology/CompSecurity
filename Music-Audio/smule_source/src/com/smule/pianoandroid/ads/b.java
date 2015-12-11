// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.smule.pianoandroid.ads;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.doubleclick.PublisherInterstitialAd;
import com.smule.android.c.a;
import com.smule.android.c.aa;

// Referenced classes of package com.smule.pianoandroid.ads:
//            g

public class b extends AdListener
{

    private static final String a = com/smule/pianoandroid/ads/g.getName();
    private boolean b;
    private PublisherInterstitialAd c;
    private PublisherAdView d;
    private Runnable e;
    private String f;

    public b(PublisherAdView publisheradview)
    {
        d = publisheradview;
    }

    public b(PublisherInterstitialAd publisherinterstitialad, String s, Runnable runnable)
    {
        c = publisherinterstitialad;
        e = runnable;
        f = s;
    }

    private void b()
    {
        if (c != null)
        {
            c.setAppEventListener(null);
        }
        if (d != null)
        {
            d.setAppEventListener(null);
        }
    }

    public void a()
    {
        b = true;
    }

    public void a(Runnable runnable)
    {
        e = runnable;
    }

    public void onAdClosed()
    {
        b();
        super.onAdClosed();
        if (e != null)
        {
            e.run();
        }
        aa.a(a, "onAdClosed");
    }

    public void onAdFailedToLoad(int i)
    {
        b();
        super.onAdFailedToLoad(i);
        aa.a(a, (new StringBuilder()).append("onAdFailedToLoad ").append(i).toString());
    }

    public void onAdLeftApplication()
    {
        b();
        super.onAdLeftApplication();
        aa.a(a, "onAdLeftApplication");
    }

    public void onAdLoaded()
    {
        super.onAdLoaded();
        aa.a(a, "onAdLoaded");
        if (b && c != null)
        {
            c.show();
            com.smule.android.c.a.a(f);
        }
    }

    public void onAdOpened()
    {
        super.onAdOpened();
        aa.a(a, "onAdOpened");
    }

}
