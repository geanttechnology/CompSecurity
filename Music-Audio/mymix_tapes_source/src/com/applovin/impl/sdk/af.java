// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;

// Referenced classes of package com.applovin.impl.sdk:
//            ae

class af
    implements Runnable
{

    final AppLovinAd a;
    final int b;
    final ae c;

    af(ae ae1, AppLovinAd applovinad, int i)
    {
        c = ae1;
        a = applovinad;
        b = i;
        super();
    }

    public void run()
    {
        ae.a(c).validationRequestFailed(a, b);
    }
}
