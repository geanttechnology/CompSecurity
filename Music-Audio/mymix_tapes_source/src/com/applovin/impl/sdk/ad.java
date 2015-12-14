// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinAdLoadListener;

// Referenced classes of package com.applovin.impl.sdk:
//            ab

class ad
    implements Runnable
{

    final int a;
    final ab b;

    ad(ab ab1, int i)
    {
        b = ab1;
        a = i;
        super();
    }

    public void run()
    {
        ab.a(b).failedToReceiveAd(a);
    }
}
