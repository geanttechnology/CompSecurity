// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.easibeacon.protocol;

import android.bluetooth.BluetoothDevice;
import java.util.ArrayList;
import java.util.Collections;

// Referenced classes of package com.easibeacon.protocol:
//            IBeaconProtocol, IBeacon, IBeaconListener

final class a
    implements android.bluetooth.eScanCallback
{

    final IBeaconProtocol a;

    public final void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        abyte0 = IBeaconProtocol.a(a, abyte0);
        if (abyte0 != null)
        {
            abyte0.setRssi(i);
            abyte0.setMacAddress(bluetoothdevice.getAddress());
            if (bluetoothdevice.getName().startsWith("easiBeacon_"))
            {
                abyte0.setEasiBeacon(true);
            } else
            {
                abyte0.setEasiBeacon(false);
            }
            if (abyte0.isEasiBeacon())
            {
                abyte0.setProximity((int)IBeaconProtocol.a(abyte0.getPowerValue(), i));
            } else
            {
                abyte0.setProximity(-1);
            }
            if (!IBeaconProtocol.a(a).contains(abyte0))
            {
                IBeaconProtocol.a(a).add(abyte0);
                Collections.sort(IBeaconProtocol.a(a), new <init>(a, (byte)0));
                IBeaconProtocol.b(a).beaconFound(abyte0);
                return;
            }
        }
    }

    allback(IBeaconProtocol ibeaconprotocol)
    {
        a = ibeaconprotocol;
        super();
    }
}
