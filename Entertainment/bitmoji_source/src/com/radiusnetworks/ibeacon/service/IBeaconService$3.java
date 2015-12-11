// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.bluetooth.BluetoothDevice;
import android.util.Log;
import com.radiusnetworks.ibeacon.IBeaconManager;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconService

class this._cls0
    implements android.bluetooth.LeScanCallback
{

    final IBeaconService this$0;

    public void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        if (IBeaconManager.debug)
        {
            Log.d("IBeaconService", "got record");
        }
        (new anProcessor(IBeaconService.this, null)).execute(new anData[] {
            new anData(IBeaconService.this, bluetoothdevice, i, abyte0)
        });
    }

    anData()
    {
        this$0 = IBeaconService.this;
        super();
    }
}
