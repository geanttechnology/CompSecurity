// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon;

import android.app.IntentService;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.radiusnetworks.ibeacon.service.IBeaconData;
import com.radiusnetworks.ibeacon.service.MonitoringData;
import com.radiusnetworks.ibeacon.service.RangingData;

// Referenced classes of package com.radiusnetworks.ibeacon:
//            IBeaconManager, RangeNotifier, MonitorNotifier

public class IBeaconIntentProcessor extends IntentService
{

    private static final String TAG = "IBeaconIntentProcessor";
    private boolean initialized;

    public IBeaconIntentProcessor()
    {
        super("IBeaconIntentProcessor");
        initialized = false;
    }

    protected void onHandleIntent(Intent intent)
    {
        Object obj = null;
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconIntentProcessor", "got an intent to process");
        }
        java.util.Collection collection;
        RangeNotifier rangenotifier;
        int i;
        if (intent != null && intent.getExtras() != null)
        {
            MonitoringData monitoringdata = (MonitoringData)intent.getExtras().get("monitoringData");
            obj = (RangingData)intent.getExtras().get("rangingData");
            intent = monitoringdata;
        } else
        {
            intent = null;
        }
        if (obj == null) goto _L2; else goto _L1
_L1:
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconIntentProcessor", "got ranging data");
        }
        if (((RangingData) (obj)).getIBeacons() == null)
        {
            Log.w("IBeaconIntentProcessor", "Ranging data has a null iBeacons collection");
        }
        rangenotifier = IBeaconManager.getInstanceForApplication(this).getRangingNotifier();
        collection = IBeaconData.fromIBeaconDatas(((RangingData) (obj)).getIBeacons());
        if (rangenotifier == null) goto _L4; else goto _L3
_L3:
        rangenotifier.didRangeBeaconsInRegion(collection, ((RangingData) (obj)).getRegion());
_L6:
        rangenotifier = IBeaconManager.getInstanceForApplication(this).getDataRequestNotifier();
        if (rangenotifier != null)
        {
            rangenotifier.didRangeBeaconsInRegion(collection, ((RangingData) (obj)).getRegion());
        }
_L2:
        if (intent != null)
        {
            if (IBeaconManager.debug)
            {
                Log.d("IBeaconIntentProcessor", "got monitoring data");
            }
            obj = IBeaconManager.getInstanceForApplication(this).getMonitoringNotifier();
            if (obj != null)
            {
                if (IBeaconManager.debug)
                {
                    Log.d("IBeaconIntentProcessor", (new StringBuilder()).append("Calling monitoring notifier:").append(obj).toString());
                }
                if (intent.isInside())
                {
                    i = 1;
                } else
                {
                    i = 0;
                }
                ((MonitorNotifier) (obj)).didDetermineStateForRegion(i, intent.getRegion());
                if (!intent.isInside())
                {
                    break; /* Loop/switch isn't completed */
                }
                ((MonitorNotifier) (obj)).didEnterRegion(intent.getRegion());
            }
        }
        return;
_L4:
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconIntentProcessor", "but ranging notifier is null, so we're dropping it.");
        }
        if (true) goto _L6; else goto _L5
_L5:
        ((MonitorNotifier) (obj)).didExitRegion(intent.getRegion());
        return;
    }
}
