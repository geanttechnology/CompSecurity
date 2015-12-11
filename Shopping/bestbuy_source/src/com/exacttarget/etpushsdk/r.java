// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush

class r
    implements Runnable
{

    final Thread a;
    final ETPush b;

    r(ETPush etpush, Thread thread)
    {
        b = etpush;
        a = thread;
        super();
    }

    public void run()
    {
        m.a("~!ETPush", "Waiting for enablePush() to finish");
        if (!ETPush.v().await(25000L, TimeUnit.MILLISECONDS))
        {
            throw new ETException("ETPush disablePush() timed out waiting for state change.");
        }
          goto _L1
        Object obj;
        obj;
_L3:
        m.c("~!ETPush", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        return;
_L1:
        m.a("~!ETPush", "enablePush() finished.  So continue with disabling push.");
        ETPush.b(new CountDownLatch(1));
        a.start();
        return;
        obj;
        if (true) goto _L3; else goto _L2
_L2:
    }
}
