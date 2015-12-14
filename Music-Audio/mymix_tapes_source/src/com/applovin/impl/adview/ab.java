// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.adview.AppLovinAdView;
import com.applovin.impl.sdk.AppLovinAdImpl;
import com.applovin.sdk.AppLovinAd;

// Referenced classes of package com.applovin.impl.adview:
//            x

class ab
    implements Runnable
{

    final AppLovinAd a;
    final x b;

    ab(x x1, AppLovinAd applovinad)
    {
        b = x1;
        a = applovinad;
        super();
    }

    public void run()
    {
        x.f(b).renderAd(a);
        x.a(b, ((AppLovinAdImpl)a).getCloseStyle());
    }
}
