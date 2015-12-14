// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

// Referenced classes of package com.applovin.impl.sdk:
//            ae

class aj
    implements Runnable
{

    final AppLovinAd a;
    final double b;
    final boolean c;
    final ae d;

    aj(ae ae1, AppLovinAd applovinad, double d1, boolean flag)
    {
        d = ae1;
        a = applovinad;
        b = d1;
        c = flag;
        super();
    }

    public void run()
    {
        ae.d(d).videoPlaybackEnded(a, b, c);
    }
}
