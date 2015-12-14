// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

// Referenced classes of package com.applovin.impl.adview:
//            AdViewControllerImpl

class c
    implements AppLovinAdClickListener
{

    final AdViewControllerImpl a;

    c(AdViewControllerImpl adviewcontrollerimpl)
    {
        a = adviewcontrollerimpl;
        super();
    }

    public void adClicked(AppLovinAd applovinad)
    {
        if (AdViewControllerImpl.h(a) != null)
        {
            AdViewControllerImpl.h(a).adClicked(applovinad);
        }
    }
}
