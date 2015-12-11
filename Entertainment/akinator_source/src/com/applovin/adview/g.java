// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.adview;

import java.util.UUID;

// Referenced classes of package com.applovin.adview:
//            AppLovinInterstitialActivity

class g
    implements Runnable
{

    final int a;
    final UUID b;
    final AppLovinInterstitialActivity c;

    g(AppLovinInterstitialActivity applovininterstitialactivity, int i, UUID uuid)
    {
        c = applovininterstitialactivity;
        a = i;
        b = uuid;
        super();
    }

    public void run()
    {
        AppLovinInterstitialActivity.a(c, a, b);
    }
}
