// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinAdLoadListener;

// Referenced classes of package com.applovin.impl.adview:
//            af

class aj
    implements Runnable
{

    final int a;
    final af b;

    aj(af af1, int i)
    {
        b = af1;
        a = i;
        super();
    }

    public void run()
    {
        if (af.c(b) != null)
        {
            af.c(b).failedToReceiveAd(a);
        }
    }
}
