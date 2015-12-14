// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdVideoPlaybackListener;

// Referenced classes of package com.applovin.impl.sdk:
//            ae

class ai
    implements Runnable
{

    final AppLovinAd a;
    final ae b;

    ai(ae ae1, AppLovinAd applovinad)
    {
        b = ae1;
        a = applovinad;
        super();
    }

    public void run()
    {
        ae.d(b).videoPlaybackBegan(a);
    }
}
