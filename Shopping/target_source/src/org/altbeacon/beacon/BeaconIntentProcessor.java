// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import org.altbeacon.beacon.c.c;
import org.altbeacon.beacon.service.MonitoringData;
import org.altbeacon.beacon.service.RangingData;

// Referenced classes of package org.altbeacon.beacon:
//            c, g, f

public class BeaconIntentProcessor extends IntentService
{

    public BeaconIntentProcessor()
    {
        super("BeaconIntentProcessor");
    }

    protected void onHandleIntent(Intent intent)
    {
label0:
        {
            Object obj = null;
            c.a("BeaconIntentProcessor", "got an intent to process", new Object[0]);
            if (intent != null && intent.getExtras() != null)
            {
                MonitoringData monitoringdata = (MonitoringData)intent.getExtras().get("monitoringData");
                obj = (RangingData)intent.getExtras().get("rangingData");
                intent = monitoringdata;
            } else
            {
                intent = null;
            }
            if (obj != null)
            {
                c.a("BeaconIntentProcessor", "got ranging data", new Object[0]);
                if (((RangingData) (obj)).a() == null)
                {
                    c.c("BeaconIntentProcessor", "Ranging data has a null beacons collection", new Object[0]);
                }
                g g1 = c.a(this).d();
                java.util.Collection collection = ((RangingData) (obj)).a();
                if (g1 != null)
                {
                    g1.didRangeBeaconsInRegion(collection, ((RangingData) (obj)).b());
                } else
                {
                    c.a("BeaconIntentProcessor", "but ranging notifier is null, so we're dropping it.", new Object[0]);
                }
                g1 = c.a(this).h();
                if (g1 != null)
                {
                    g1.didRangeBeaconsInRegion(collection, ((RangingData) (obj)).b());
                }
            }
            if (intent != null)
            {
                c.a("BeaconIntentProcessor", "got monitoring data", new Object[0]);
                obj = c.a(this).();
                if (obj != null)
                {
                    c.a("BeaconIntentProcessor", "Calling monitoring notifier: %s", new Object[] {
                        obj
                    });
                    int i;
                    if (intent.a())
                    {
                        i = 1;
                    } else
                    {
                        i = 0;
                    }
                    ((f) (obj)).a(i, intent.b());
                    if (!intent.a())
                    {
                        break label0;
                    }
                    ((f) (obj)).a(intent.b());
                }
            }
            return;
        }
        ((f) (obj)).b(intent.b());
    }
}
