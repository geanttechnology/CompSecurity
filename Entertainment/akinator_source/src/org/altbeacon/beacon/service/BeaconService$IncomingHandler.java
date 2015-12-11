// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;
import org.altbeacon.beacon.logging.LogManager;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService, StartRMData, Callback

static class mService extends Handler
{

    private final WeakReference mService;

    public void handleMessage(Message message)
    {
        BeaconService beaconservice;
        StartRMData startrmdata;
label0:
        {
label1:
            {
label2:
                {
label3:
                    {
label4:
                        {
                            beaconservice = (BeaconService)mService.get();
                            startrmdata = (StartRMData)message.obj;
                            if (beaconservice != null)
                            {
                                switch (message.what)
                                {
                                default:
                                    super.handleMessage(message);
                                    break;

                                case 2: // '\002'
                                    break label4;

                                case 3: // '\003'
                                    break label3;

                                case 4: // '\004'
                                    break label2;

                                case 5: // '\005'
                                    break label1;

                                case 6: // '\006'
                                    break label0;
                                }
                            }
                            return;
                        }
                        LogManager.i("BeaconService", "start ranging received", new Object[0]);
                        beaconservice.startRangingBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                        beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                        return;
                    }
                    LogManager.i("BeaconService", "stop ranging received", new Object[0]);
                    beaconservice.stopRangingBeaconsInRegion(startrmdata.getRegionData());
                    beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                    return;
                }
                LogManager.i("BeaconService", "start monitoring received", new Object[0]);
                beaconservice.startMonitoringBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
                return;
            }
            LogManager.i("BeaconService", "stop monitoring received", new Object[0]);
            beaconservice.stopMonitoringBeaconsInRegion(startrmdata.getRegionData());
            beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
            return;
        }
        LogManager.i("BeaconService", "set scan intervals received", new Object[0]);
        beaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod(), startrmdata.getBackgroundFlag());
    }

    (BeaconService beaconservice)
    {
        mService = new WeakReference(beaconservice);
    }
}
