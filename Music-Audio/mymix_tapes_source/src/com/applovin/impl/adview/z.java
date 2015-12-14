// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdClickListener;

// Referenced classes of package com.applovin.impl.adview:
//            af, x

class z
    implements AppLovinAdClickListener
{

    final af a;
    final x b;

    z(x x, af af1)
    {
        b = x;
        a = af1;
        super();
    }

    public void adClicked(AppLovinAd applovinad)
    {
        AppLovinAdClickListener applovinadclicklistener = a.e();
        if (applovinadclicklistener != null)
        {
            applovinadclicklistener.adClicked(applovinad);
        }
    }
}
