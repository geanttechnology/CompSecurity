// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import com.applovin.sdk.AppLovinLogger;

// Referenced classes of package com.applovin.impl.sdk:
//            cs, cq

class ct
    implements Thread.UncaughtExceptionHandler
{

    final cs a;

    ct(cs cs1)
    {
        a = cs1;
        super();
    }

    public void uncaughtException(Thread thread, Throwable throwable)
    {
        cq.b(a.a).e("TaskManager", "Caught unhandled exception", throwable);
    }
}
