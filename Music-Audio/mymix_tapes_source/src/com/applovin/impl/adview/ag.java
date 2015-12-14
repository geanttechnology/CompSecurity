// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

// Referenced classes of package com.applovin.impl.adview:
//            af

class ag
    implements AppLovinAdLoadListener
{

    final af a;

    ag(af af1)
    {
        a = af1;
        super();
    }

    public void adReceived(AppLovinAd applovinad)
    {
        af.a(a, applovinad);
        a.showAndRender(applovinad);
    }

    public void failedToReceiveAd(int i)
    {
        af.a(a, i);
    }
}
