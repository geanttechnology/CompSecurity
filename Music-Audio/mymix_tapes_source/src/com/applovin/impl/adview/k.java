// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl, o, a

class k
    implements Runnable
{

    final AdViewControllerImpl a;

    private k(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    k(AdViewControllerImpl adviewcontrollerimpl, a a1)
    {
        this(adviewcontrollerimpl);
    }

    public void run()
    {
        if (AdViewControllerImpl.d(a) != null)
        {
            AdViewControllerImpl.a(AdViewControllerImpl.c(a), AdViewControllerImpl.d(a).getSize());
            AdViewControllerImpl.c(a).a(AdViewControllerImpl.d(a));
        }
    }
}
