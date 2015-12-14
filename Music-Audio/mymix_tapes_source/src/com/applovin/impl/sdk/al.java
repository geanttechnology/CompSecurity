// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAd;
import com.applovin.sdk.AppLovinAdRewardListener;
import java.util.Map;

// Referenced classes of package com.applovin.impl.sdk:
//            ae

class al
    implements Runnable
{

    final AppLovinAd a;
    final Map b;
    final ae c;

    al(ae ae1, AppLovinAd applovinad, Map map)
    {
        c = ae1;
        a = applovinad;
        b = map;
        super();
    }

    public void run()
    {
        ae.a(c).userOverQuota(a, b);
    }
}
