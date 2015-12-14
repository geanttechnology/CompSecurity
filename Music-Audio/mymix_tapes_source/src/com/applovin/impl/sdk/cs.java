// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.applovin.impl.sdk;

import java.util.concurrent.ThreadFactory;

// Referenced classes of package com.applovin.impl.sdk:
//            cq, AppLovinSdkImpl, dh, ct

class cs
    implements ThreadFactory
{

    final cq a;
    private final String b;

    public cs(cq cq1, String s)
    {
        a = cq1;
        super();
        b = s;
    }

    public Thread newThread(Runnable runnable)
    {
        runnable = new Thread(runnable, (new StringBuilder()).append("AppLovinSdk:").append(b).append(":").append(dh.a(cq.a(a).getSdkKey())).toString());
        runnable.setDaemon(true);
        runnable.setPriority(10);
        runnable.setUncaughtExceptionHandler(new ct(this));
        return runnable;
    }
}
