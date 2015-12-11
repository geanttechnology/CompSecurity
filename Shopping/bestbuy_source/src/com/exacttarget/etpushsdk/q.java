// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.event.PushStatusEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETException, ETPush

class q
    implements Runnable
{

    final ETPush a;

    q(ETPush etpush)
    {
        a = etpush;
        super();
    }

    public void run()
    {
        m.a("~!ETPush", "disablePush()...");
        ETPush.c();
        if (a.j())
        {
            ETPush.a(a, false);
            ETPush.f();
            EventBus.getInstance().a(new PushStatusEvent(false));
        }
        ETPush.v().countDown();
        return;
        Object obj;
        obj;
        m.c("~!ETPush", ((ETException) (obj)).getMessage(), ((Throwable) (obj)));
        ETPush.v().countDown();
        return;
        obj;
        ETPush.v().countDown();
        throw obj;
    }
}
