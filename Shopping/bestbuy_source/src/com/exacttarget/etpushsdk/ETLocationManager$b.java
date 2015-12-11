// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.exacttarget.etpushsdk;

import android.app.NotificationManager;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import com.exacttarget.etpushsdk.data.Message;
import com.exacttarget.etpushsdk.data.RegionMessage;
import com.exacttarget.etpushsdk.database.e;
import com.exacttarget.etpushsdk.database.f;
import com.exacttarget.etpushsdk.database.g;
import com.exacttarget.etpushsdk.event.BackgroundEvent;
import com.exacttarget.etpushsdk.event.BeaconRegionEnterEvent;
import com.exacttarget.etpushsdk.event.BeaconRegionExitEvent;
import com.exacttarget.etpushsdk.event.BeaconRegionRangeEvent;
import com.exacttarget.etpushsdk.util.EventBus;
import com.exacttarget.etpushsdk.util.d;
import com.exacttarget.etpushsdk.util.m;
import com.radiusnetworks.ibeacon.IBeacon;
import com.radiusnetworks.ibeacon.IBeaconConsumer;
import com.radiusnetworks.ibeacon.IBeaconManager;
import com.radiusnetworks.ibeacon.MonitorNotifier;
import com.radiusnetworks.ibeacon.RangeNotifier;
import com.radiusnetworks.ibeacon.Region;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.exacttarget.etpushsdk:
//            ETAnalytics, ETLocationManager, ETException, ETPush, 
//            c

class <init>
    implements IBeaconConsumer, MonitorNotifier, RangeNotifier
{

    final ETLocationManager a;

    public boolean bindService(Intent intent, ServiceConnection serviceconnection, int i)
    {
        m.a("~!IBeaconMonitor", "bindService");
        return getApplicationContext().bindService(intent, serviceconnection, i);
    }

    public void didDetermineStateForRegion(int i, Region region)
    {
        m.a("~!IBeaconMonitor", (new StringBuilder()).append("BeaconState - {state: ").append(i).append(", id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
    }

    public void didEnterRegion(Region region)
    {
        m.a("~!IBeaconMonitor", (new StringBuilder()).append("didEnterRegion - {id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
        try
        {
            region = g.a(region.getUniqueId());
            region.setEntryCount(Integer.valueOf(region.getEntryCount().intValue() + 1));
            region.setHasEntered(Boolean.TRUE);
            g.c(region);
            m.a("~!IBeaconMonitor", (new StringBuilder()).append("Beacon: ").append(region.getId()).append(", EntryCount: ").append(region.getEntryCount()).toString());
            if (d.f())
            {
                ETAnalytics.a().a(region.getId(), true);
            }
            EventBus.getInstance().a(new BeaconRegionEnterEvent(region));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (Region region)
        {
            m.c("~!IBeaconMonitor", region.getMessage(), region);
        }
    }

    public void didExitRegion(Region region)
    {
        m.a("~!IBeaconMonitor", (new StringBuilder()).append("didExitRegion - {id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
        try
        {
            region = g.a(region.getUniqueId());
            region.setExitCount(Integer.valueOf(region.getExitCount().intValue() + 1));
            region.setHasEntered(Boolean.FALSE);
            g.c(region);
            m.a("~!IBeaconMonitor", (new StringBuilder()).append("Beacon: ").append(region.getId()).append(", ExitCount: ").append(region.getEntryCount()).toString());
            Message message;
            for (Iterator iterator = f.a("region_id = ?", new String[] {
    region.getId()
}, null, null, null).iterator(); iterator.hasNext(); e.c(message))
            {
                message = e.a(((RegionMessage)iterator.next()).getMessage().getId());
                message.setHasEntered(Boolean.FALSE);
                message.setEntryTime(Long.valueOf(0L));
                if (message.getEphemeralMessage().booleanValue() && message.getNotifyId() != null)
                {
                    ((NotificationManager)com.exacttarget.etpushsdk.ETLocationManager.e(a).getSystemService("notification")).cancel(message.getNotifyId().intValue());
                    message.setNotifyId(null);
                }
            }

        }
        // Misplaced declaration of an exception variable
        catch (Region region)
        {
            m.c("~!IBeaconMonitor", region.getMessage(), region);
            return;
        }
        if (d.f())
        {
            ETAnalytics.a().a(region.getId());
        }
        EventBus.getInstance().a(new BeaconRegionExitEvent(region));
        return;
    }

    public void didRangeBeaconsInRegion(Collection collection, Region region)
    {
        collection = collection.iterator();
_L4:
        if (!collection.hasNext()) goto _L2; else goto _L1
_L1:
        IBeacon ibeacon;
        com.exacttarget.etpushsdk.data.Region region1;
        ibeacon = (IBeacon)collection.next();
        m.a("~!IBeaconMonitor", (new StringBuilder()).append("didRangeBeaconsInRegion - {proximity: ").append(ibeacon.getProximity()).append(", id: '").append(region.getUniqueId()).append("', uuid: '").append(region.getProximityUuid()).append("', major: ").append(region.getMajor()).append(", minor: ").append(region.getMinor()).append("}").toString());
        region1 = g.a(region.getUniqueId());
        if (region1 == null) goto _L4; else goto _L3
_L3:
        if (!region1.getHasEntered().booleanValue())
        {
            break MISSING_BLOCK_LABEL_191;
        }
        ETPush.getInstance().a(region.getUniqueId(), -1, ibeacon.getProximity());
        EventBus.getInstance().a(new BeaconRegionRangeEvent(region1, ibeacon.getProximity(), ibeacon.getRssi(), ibeacon.getAccuracy()));
          goto _L4
        collection;
        m.c("~!IBeaconMonitor", collection.getMessage(), collection);
_L2:
        return;
        m.a("~!IBeaconMonitor", (new StringBuilder()).append("Ranged region ").append(region1.getId()).append(" but monitoring hasn't yet entered").toString());
          goto _L4
    }

    public Context getApplicationContext()
    {
        return com.exacttarget.etpushsdk.ETLocationManager.e(a);
    }

    public void onIBeaconServiceConnect()
    {
        m.a("~!IBeaconMonitor", "onIBeaconServiceConnect");
        ETLocationManager.b(a).setMonitorNotifier(this);
        ETLocationManager.b(a).setRangeNotifier(this);
        if (ETLocationManager.k().booleanValue() && a.f())
        {
            a.b(false);
        }
        BackgroundEvent backgroundevent = (BackgroundEvent)EventBus.getInstance().a(com/exacttarget/etpushsdk/event/BackgroundEvent);
        if (backgroundevent == null || backgroundevent.isInBackground())
        {
            ETLocationManager.b(a).setBackgroundMode(ETLocationManager.a(a), true);
        }
    }

    public void unbindService(ServiceConnection serviceconnection)
    {
        m.a("~!IBeaconMonitor", "unbindService");
        getApplicationContext().unbindService(serviceconnection);
    }

    private t(ETLocationManager etlocationmanager)
    {
        a = etlocationmanager;
        super();
    }

    a(ETLocationManager etlocationmanager, c c)
    {
        this(etlocationmanager);
    }
}
