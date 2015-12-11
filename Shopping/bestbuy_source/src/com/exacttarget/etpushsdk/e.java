// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import ahy;
import com.exacttarget.etpushsdk.event.LocationStatusEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import java.util.concurrent.CountDownLatch;
import qm;
import qn;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager, ETPush

class e
    implements Runnable
{

    final boolean a;
    final ETLocationManager b;

    e(ETLocationManager etlocationmanager, boolean flag)
    {
        b = etlocationmanager;
        a = flag;
        super();
    }

    public void run()
    {
        m.a("~!ETLocationManager", "locationStateThread start started");
        if (ETLocationManager.c(b) == null)
        {
            m.a("~!ETLocationManager", "Creating our GoogleApiClient");
            ETLocationManager.a(b, (new qn(ETLocationManager.e(b))).a(ahy.a).a(ETLocationManager.d(b)).a(ETLocationManager.d(b)).b());
        }
        if (!ETLocationManager.c(b).d())
        {
            m.a("~!ETLocationManager", "Connecting our GoogleApiClient");
            ETLocationManager.c(b).b();
        }
        if (a)
        {
            b.e(true);
        }
        if (b.c())
        {
            b.f(true);
            ETLocationManager.f(b);
            ETPush.f();
            EventBus.getInstance().a(new LocationStatusEvent(true));
        }
        m.a("~!ETLocationManager", "locationStateThread start ended");
        ETLocationManager.h().countDown();
        return;
        Object obj;
        obj;
        m.c("~!ETLocationManager", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        m.a("~!ETLocationManager", "locationStateThread start ended");
        ETLocationManager.h().countDown();
        return;
        obj;
        m.a("~!ETLocationManager", "locationStateThread start ended");
        ETLocationManager.h().countDown();
        throw obj;
    }
}
