// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class b
    implements Runnable
{

    final int a;
    final AdViewControllerImpl b;

    b(AdViewControllerImpl adviewcontrollerimpl, int i)
    {
        b = adviewcontrollerimpl;
        a = i;
        super();
    }

    public void run()
    {
        try
        {
            if (AdViewControllerImpl.a(b) != null)
            {
                AdViewControllerImpl.a(b).failedToReceiveAd(a);
            }
            return;
        }
        catch (Throwable throwable)
        {
            AdViewControllerImpl.b(b).userError("AppLovinAdView", "Exception while running app load  callback", throwable);
        }
    }
}
