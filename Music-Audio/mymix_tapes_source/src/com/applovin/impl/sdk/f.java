// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.impl.adview.AdViewControllerImpl;

// Referenced classes of package com.applovin.impl.sdk:
//            e, AppLovinAdServiceImpl

class f
    implements Runnable
{

    final e a;

    f(e e1)
    {
        a = e1;
        super();
    }

    public void run()
    {
        if (!a.a.isForegroundClickInvalidated())
        {
            AppLovinAdServiceImpl.a(a.e, a.b, a.c, a.d, a.a);
        }
    }
}
