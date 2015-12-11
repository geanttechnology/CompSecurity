// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.MonitoringData;
import org.altbeacon.beacon.service.RangingData;

// Referenced classes of package org.altbeacon.beacon:
//            BeaconManager, RangeNotifier, MonitorNotifier

public class BeaconIntentProcessor extends IntentService
{

    private static final String TAG = "BeaconIntentProcessor";

    public BeaconIntentProcessor()
    {
        super("BeaconIntentProcessor");
    }

    protected void onHandleIntent(Intent intent)
    {
        MonitoringData monitoringdata;
label0:
        {
            int i = 1;
            LogManager.d("BeaconIntentProcessor", "got an intent to process", new Object[0]);
            Object obj = null;
            Object obj1 = null;
            monitoringdata = obj;
            RangingData rangingdata = obj1;
            if (intent != null)
            {
                monitoringdata = obj;
                rangingdata = obj1;
                if (intent.getExtras() != null)
                {
                    monitoringdata = (MonitoringData)intent.getExtras().get("monitoringData");
                    rangingdata = (RangingData)intent.getExtras().get("rangingData");
                }
            }
            if (rangingdata != null)
            {
                LogManager.d("BeaconIntentProcessor", "got ranging data", new Object[0]);
                if (rangingdata.getBeacons() == null)
                {
                    LogManager.w("BeaconIntentProcessor", "Ranging data has a null beacons collection", new Object[0]);
                }
                RangeNotifier rangenotifier = BeaconManager.getInstanceForApplication(this).getRangingNotifier();
                intent = rangingdata.getBeacons();
                if (rangenotifier != null)
                {
                    rangenotifier.didRangeBeaconsInRegion(intent, rangingdata.getRegion());
                } else
                {
                    LogManager.d("BeaconIntentProcessor", "but ranging notifier is null, so we're dropping it.", new Object[0]);
                }
                rangenotifier = BeaconManager.getInstanceForApplication(this).getDataRequestNotifier();
                if (rangenotifier != null)
                {
                    rangenotifier.didRangeBeaconsInRegion(intent, rangingdata.getRegion());
                }
            }
            if (monitoringdata != null)
            {
                LogManager.d("BeaconIntentProcessor", "got monitoring data", new Object[0]);
                intent = BeaconManager.getInstanceForApplication(this).getMonitoringNotifier();
                if (intent != null)
                {
                    LogManager.d("BeaconIntentProcessor", "Calling monitoring notifier: %s", new Object[] {
                        intent
                    });
                    if (!monitoringdata.isInside())
                    {
                        i = 0;
                    }
                    intent.didDetermineStateForRegion(i, monitoringdata.getRegion());
                    if (!monitoringdata.isInside())
                    {
                        break label0;
                    }
                    intent.didEnterRegion(monitoringdata.getRegion());
                }
            }
            return;
        }
        intent.didExitRegion(monitoringdata.getRegion());
    }
}
