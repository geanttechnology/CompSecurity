// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

// Referenced classes of package com.applovin.impl.adview:
//            af

class ai
    implements Runnable
{

    final AppLovinAd a;
    final af b;

    ai(af af1, AppLovinAd applovinad)
    {
        b = af1;
        a = applovinad;
        super();
    }

    public void run()
    {
        if (af.c(b) != null)
        {
            af.c(b).adReceived(a);
        }
    }
}
