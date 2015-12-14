// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;
import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class a
    implements Runnable
{

    final AppLovinAd a;
    final AdViewControllerImpl b;

    a(AdViewControllerImpl adviewcontrollerimpl, AppLovinAd applovinad)
    {
        b = adviewcontrollerimpl;
        a = applovinad;
        super();
    }

    public void run()
    {
        try
        {
            if (AdViewControllerImpl.a(b) != null)
            {
                AdViewControllerImpl.a(b).adReceived(a);
            }
            return;
        }
        catch (Throwable throwable)
        {
            AdViewControllerImpl.b(b).userError("AppLovinSdk", (new StringBuilder()).append("Exception while running app load callback: ").append(throwable.getMessage()).toString());
        }
    }
}
