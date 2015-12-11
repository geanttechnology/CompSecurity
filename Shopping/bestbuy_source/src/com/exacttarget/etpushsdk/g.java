// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.Context;
import android.content.IntentFilter;
import com.exacttarget.etpushsdk.event.ProximityStatusEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import com.radiusnetworks.ibeacon.IBeaconManager;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager

class g
    implements Runnable
{

    final boolean a;
    final ETLocationManager b;

    g(ETLocationManager etlocationmanager, boolean flag)
    {
        b = etlocationmanager;
        a = flag;
        super();
    }

    public void run()
    {
        m.a("~!ETLocationManager", "proximityStateThread start started");
        if (a)
        {
            b.g(true);
        }
        if (!b.e()) goto _L2; else goto _L1
_L1:
        b.h(true);
        if (!ETLocationManager.g(b))
        {
            IntentFilter intentfilter = new IntentFilter("android.bluetooth.adapter.action.STATE_CHANGED");
            ETLocationManager.e(b).registerReceiver(ETLocationManager.h(b), intentfilter);
            ETLocationManager.a(b, true);
        }
        if (ETLocationManager.b(b).isBound(ETLocationManager.a(b)))
        {
            break MISSING_BLOCK_LABEL_155;
        }
        ETLocationManager.b(b).bind(ETLocationManager.a(b));
_L3:
        EventBus.getInstance().a(new ProximityStatusEvent(false));
_L2:
        m.a("~!ETLocationManager", "proximityStateThread start ended");
        ETLocationManager.i().countDown();
        return;
        ETLocationManager.f(b);
          goto _L3
        Object obj;
        obj;
        m.c("~!ETLocationManager", ((Exception) (obj)).getMessage(), ((Throwable) (obj)));
        m.a("~!ETLocationManager", "proximityStateThread start ended");
        ETLocationManager.i().countDown();
        return;
        obj;
        m.a("~!ETLocationManager", "proximityStateThread start ended");
        ETLocationManager.i().countDown();
        throw obj;
    }
}
