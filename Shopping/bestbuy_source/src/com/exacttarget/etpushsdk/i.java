// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import com.exacttarget.etpushsdk.event.LocationStatusEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;
import qm;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager, ETPush

class i
    implements Runnable
{

    final boolean a;
    final ETLocationManager b;

    i(ETLocationManager etlocationmanager, boolean flag)
    {
        b = etlocationmanager;
        a = flag;
        super();
    }

    public void run()
    {
        m.a("~!ETLocationManager", "locationStateThread stop started");
        b.e(a);
        ETLocationManager.d(b).a(Boolean.TRUE);
        ETLocationManager.c.a(ETLocationManager.d(b));
        ETLocationManager.i(b);
        ETLocationManager.c(b).c();
        ETPush.f();
        EventBus.getInstance().a(new LocationStatusEvent(a));
        m.a("~!ETLocationManager", " ended");
        m.a("~!ETLocationManager", "locationStateThread stop ended");
        ETLocationManager.h().countDown();
        return;
        Object obj;
        obj;
        m.c("~!ETLocationManager", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        m.a("~!ETLocationManager", "locationStateThread stop ended");
        ETLocationManager.h().countDown();
        return;
        obj;
        m.a("~!ETLocationManager", "locationStateThread stop ended");
        ETLocationManager.h().countDown();
        throw obj;
    }
}
