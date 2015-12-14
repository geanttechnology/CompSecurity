// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

// Referenced classes of package com.applovin.impl.sdk:
//            ae

class ah
    implements Runnable
{

    final AppLovinAd a;
    final ae b;

    ah(ae ae1, AppLovinAd applovinad)
    {
        b = ae1;
        a = applovinad;
        super();
    }

    public void run()
    {
        ae.c(b).adClicked(a);
    }
}
