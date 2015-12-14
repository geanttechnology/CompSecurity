// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.adview;

import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.adview:
//            x, y

class ae
    implements Runnable
{

    final x a;

    private ae(x x1)
    {
        a = x1;
        super();
    }

    ae(x x1, y y)
    {
        this(x1);
    }

    public void run()
    {
        a.dismiss();
_L1:
        return;
        Throwable throwable;
        throwable;
        if (x.g(a) != null)
        {
            x.g(a).e("InterstitialAdDialog", "dismiss() threw exception", throwable);
            return;
        }
          goto _L1
    }
}
