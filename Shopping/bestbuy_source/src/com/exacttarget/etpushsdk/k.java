// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.content.ContentValues;
import android.os.RemoteException;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.event.ProximityStatusEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.m;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.Region;
import java.util.Collection;
import java.util.Iterator;
import java.util.concurrent.CountDownLatch;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETLocationManager

class k
    implements Runnable
{

    final boolean a;
    final ETLocationManager b;

    k(ETLocationManager etlocationmanager, boolean flag)
    {
        b = etlocationmanager;
        a = flag;
        super();
    }

    public void run()
    {
        m.a("~!ETLocationManager", "proximityStateThread stop started");
        Object obj;
        if (a)
        {
            b.g(false);
        }
        obj = new ContentValues();
        ((ContentValues) (obj)).put("active", Integer.valueOf(0));
        ((ContentValues) (obj)).put("has_entered", Integer.valueOf(0));
        g.a("location_type = ?", new String[] {
            String.valueOf(3)
        }, ((ContentValues) (obj)));
        obj = new ContentValues();
        ((ContentValues) (obj)).put("has_entered", Boolean.FALSE);
        e.a(null, null, ((ContentValues) (obj)));
        obj = ETLocationManager.b(b).getMonitoredRegions().iterator();
_L1:
        Region region;
        if (!((Iterator) (obj)).hasNext())
        {
            break MISSING_BLOCK_LABEL_211;
        }
        region = (Region)((Iterator) (obj)).next();
        m.a("~!ETLocationManager", (new StringBuilder()).append("stopMonitoringBeaconRegion: ").append(region.getUniqueId()).toString());
        ETLocationManager.b(b).stopMonitoringBeaconsInRegion(region);
          goto _L1
        RemoteException remoteexception;
        remoteexception;
        m.d("~!ETLocationManager", remoteexception.getMessage());
          goto _L1
        Object obj1;
        obj1;
        m.c("~!ETLocationManager", ((Exception) (obj1)).getMessage(), ((Throwable) (obj1)));
        m.a("~!ETLocationManager", "proximityStateThread stop ended");
        ETLocationManager.i().countDown();
        return;
        obj1 = ETLocationManager.b(b).getRangedRegions().iterator();
_L2:
        if (!((Iterator) (obj1)).hasNext())
        {
            break MISSING_BLOCK_LABEL_319;
        }
        remoteexception = (Region)((Iterator) (obj1)).next();
        m.a("~!ETLocationManager", (new StringBuilder()).append("stopRangingBeaconRegion: ").append(remoteexception.getUniqueId()).toString());
        ETLocationManager.b(b).stopRangingBeaconsInRegion(remoteexception);
          goto _L2
        remoteexception;
        m.d("~!ETLocationManager", remoteexception.getMessage());
          goto _L2
        obj1;
        m.a("~!ETLocationManager", "proximityStateThread stop ended");
        ETLocationManager.i().countDown();
        throw obj1;
        if (ETLocationManager.b(b).getMonitoredRegions().size() > 0)
        {
            m.d("~!ETLocationManager", "currentlyMonitoredRegions SHOULD BE ZERO!!!");
        }
        if (ETLocationManager.b(b).getRangedRegions().size() > 0)
        {
            m.d("~!ETLocationManager", "rangedRegions SHOULD BE ZERO!!!");
        }
        if (ETLocationManager.b(b).isBound(ETLocationManager.a(b)))
        {
            ETLocationManager.b(b).unBind(ETLocationManager.a(b));
        }
        ETLocationManager.i(b);
        EventBus.getInstance().a(new ProximityStatusEvent(false));
        m.a("~!ETLocationManager", "proximityStateThread stop ended");
        ETLocationManager.i().countDown();
        return;
    }
}
