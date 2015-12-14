// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import android.os.Handler;
import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdLoadListener;

// Referenced classes of package com.applovin.impl.sdk:
//            AppLovinAdImpl, z, ac, ad

class ab
    implements AppLovinAdLoadListener
{

    final z a;
    private final AppLovinAdLoadListener b;

    ab(z z1, AppLovinAdLoadListener applovinadloadlistener)
    {
        a = z1;
        super();
        b = applovinadloadlistener;
    }

    static AppLovinAdLoadListener a(ab ab1)
    {
        return ab1.b;
    }

    public void adReceived(AppLovinAd applovinad)
    {
        z.a(a, (AppLovinAdImpl)applovinad);
        if (b != null)
        {
            z.c(a).post(new ac(this, applovinad));
        }
    }

    public void failedToReceiveAd(int i)
    {
        if (b != null)
        {
            z.c(a).post(new ad(this, i));
        }
    }
}
