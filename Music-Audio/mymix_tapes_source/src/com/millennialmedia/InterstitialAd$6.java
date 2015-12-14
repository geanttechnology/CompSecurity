// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.millennialmedia;


// Referenced classes of package com.millennialmedia:
//            InterstitialAd

class terstitialListener
    implements Runnable
{

    final InterstitialAd this$0;
    final terstitialListener val$localInterstitialListener;

    public void run()
    {
        val$localInterstitialListener.onLoadFailed(InterstitialAd.this, new terstitialErrorStatus(5));
    }

    terstitialListener()
    {
        this$0 = final_interstitialad;
        val$localInterstitialListener = terstitialListener.this;
        super();
    }
}
