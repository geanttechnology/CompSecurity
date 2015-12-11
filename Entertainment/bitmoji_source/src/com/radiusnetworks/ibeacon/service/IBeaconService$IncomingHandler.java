// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.os.Handler;
import android.os.Message;
import android.util.Log;
import java.lang.ref.WeakReference;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconService, StartRMData, Callback

static class mService extends Handler
{

    private final WeakReference mService;

    public void handleMessage(Message message)
    {
        IBeaconService ibeaconservice;
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
                            ibeaconservice = (IBeaconService)mService.get();
                            startrmdata = (StartRMData)message.obj;
                            if (ibeaconservice != null)
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
                        Log.i("IBeaconService", "start ranging received");
                        ibeaconservice.startRangingBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                        ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                        return;
                    }
                    Log.i("IBeaconService", "stop ranging received");
                    ibeaconservice.stopRangingBeaconsInRegion(startrmdata.getRegionData());
                    ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                    return;
                }
                Log.i("IBeaconService", "start monitoring received");
                ibeaconservice.startMonitoringBeaconsInRegion(startrmdata.getRegionData(), new Callback(startrmdata.getCallbackPackageName()));
                ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
                return;
            }
            Log.i("IBeaconService", "stop monitoring received");
            ibeaconservice.stopMonitoringBeaconsInRegion(startrmdata.getRegionData());
            ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
            return;
        }
        Log.i("IBeaconService", "set scan intervals received");
        ibeaconservice.setScanPeriods(startrmdata.getScanPeriod(), startrmdata.getBetweenScanPeriod());
    }

    (IBeaconService ibeaconservice)
    {
        mService = new WeakReference(ibeaconservice);
    }
}
