// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;
import android.content.pm.ApplicationInfo;
import android.os.AsyncTask;
import com.newrelic.agent.android.instrumentation.AsyncTaskInstrumentation;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.RejectedExecutionException;
import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.c.c;
import org.altbeacon.beacon.service.a.a;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService

class a
    implements a
{

    final BeaconService a;

    public void a()
    {
label0:
        {
            BeaconService.b(a);
            org.altbeacon.beacon.service.BeaconService.c(a);
            if (BeaconService.d(a) != null)
            {
                c.c("BeaconService", "Simulated scan data is deprecated and will be removed in a future release. Please use the new BeaconSimulator interface instead.", new Object[0]);
                ApplicationInfo applicationinfo = a.getApplicationInfo();
                int i = applicationinfo.flags & 2;
                applicationinfo.flags = i;
                if (i != 0)
                {
                    Beacon beacon;
                    for (Iterator iterator = BeaconService.d(a).iterator(); iterator.hasNext(); org.altbeacon.beacon.service.BeaconService.a(a, beacon))
                    {
                        beacon = (Beacon)iterator.next();
                    }

                } else
                {
                    c.c("BeaconService", "Simulated scan data provided, but ignored because we are not running in debug mode.  Please remove simulated scan data for production.", new Object[0]);
                }
            }
            if (org.altbeacon.beacon.c.g() != null)
            {
                if (org.altbeacon.beacon.c.g().a() == null)
                {
                    break label0;
                }
                ApplicationInfo applicationinfo1 = a.getApplicationInfo();
                int j = applicationinfo1.flags & 2;
                applicationinfo1.flags = j;
                if (j != 0)
                {
                    Beacon beacon1;
                    for (Iterator iterator1 = org.altbeacon.beacon.c.g().a().iterator(); iterator1.hasNext(); org.altbeacon.beacon.service.BeaconService.a(a, beacon1))
                    {
                        beacon1 = (Beacon)iterator1.next();
                    }

                } else
                {
                    c.c("BeaconService", "Beacon simulations provided, but ignored because we are not running in debug mode.  Please remove beacon simulations for production.", new Object[0]);
                }
            }
            return;
        }
        c.c("BeaconService", "getBeacons is returning null. No simulated beacons to report.", new Object[0]);
    }

    public void a(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        a a1;
        java.util.concurrent.ExecutorService executorservice;
        a aa[];
        a1 = new <init>(a, null);
        executorservice = org.altbeacon.beacon.service.BeaconService.a(a);
        aa = new a[1];
        aa[0] = new <init>(a, bluetoothdevice, i, abyte0);
        if (!(a1 instanceof AsyncTask))
        {
            a1.executeOnExecutor(executorservice, aa);
            return;
        }
        try
        {
            AsyncTaskInstrumentation.executeOnExecutor((AsyncTask)a1, executorservice, aa);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (BluetoothDevice bluetoothdevice)
        {
            c.c("BeaconService", "Ignoring scan result because we cannot keep up.", new Object[0]);
        }
        return;
    }

    on(BeaconService beaconservice)
    {
        a = beaconservice;
        super();
    }
}
