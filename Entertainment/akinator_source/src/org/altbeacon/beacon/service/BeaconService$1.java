// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import java.util.Iterator;
import java.util.List;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.logging.LogManager;
import org.altbeacon.beacon.service.scanner.CycledLeScanCallback;
import org.altbeacon.beacon.simulator.BeaconSimulator;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService

class this._cls0
    implements CycledLeScanCallback
{

    final BeaconService this$0;

    public void onCycleEnd()
    {
label0:
        {
            BeaconService.access$100(BeaconService.this);
            BeaconService.access$200(BeaconService.this);
            if (BeaconService.access$300(BeaconService.this) != null)
            {
                LogManager.w("BeaconService", "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.", new Object[0]);
                ApplicationInfo applicationinfo = getApplicationInfo();
                int i = applicationinfo.flags & 2;
                applicationinfo.flags = i;
                if (i != 0)
                {
                    Beacon beacon;
                    for (Iterator iterator = BeaconService.access$300(BeaconService.this).iterator(); iterator.hasNext(); BeaconService.access$400(BeaconService.this, beacon))
                    {
                        beacon = (Beacon)iterator.next();
                    }

                } else
                {
                    LogManager.w("BeaconService", "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.", new Object[0]);
                }
            }
            if (BeaconManager.getBeaconSimulator() != null)
            {
                if (BeaconManager.getBeaconSimulator().getBeacons() == null)
                {
                    break label0;
                }
                ApplicationInfo applicationinfo1 = getApplicationInfo();
                int j = applicationinfo1.flags & 2;
                applicationinfo1.flags = j;
                if (j != 0)
                {
                    Beacon beacon1;
                    for (Iterator iterator1 = BeaconManager.getBeaconSimulator().getBeacons().iterator(); iterator1.hasNext(); BeaconService.access$400(BeaconService.this, beacon1))
                    {
                        beacon1 = (Beacon)iterator1.next();
                    }

                } else
                {
                    LogManager.w("BeaconService", "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                }
            }
            return;
        }
        LogManager.w("BeaconService", "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
    }

    public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        (new anProcessor(BeaconService.this, null)).executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new anData[] {
            new anData(BeaconService.this, bluetoothdevice, i, abyte0)
        });
    }

    anData()
    {
        this$0 = BeaconService.this;
        super();
    }
}
