// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.adview:
//            l, AppLovinInterstitialActivity

class m
    implements Runnable
{

    final int a;
    final int b;
    final l c;

    m(l l1, int i, int j)
    {
        c = l1;
        a = i;
        b = j;
        super();
    }

    public void run()
    {
        AppLovinInterstitialActivity.c(c.a).e("AppLovinInterstitialActivity", (new StringBuilder()).append("Video view error (").append(a).append(",").append(b).append(") - showing close button.").toString());
        AppLovinInterstitialActivity.d(c.a);
    }
}
