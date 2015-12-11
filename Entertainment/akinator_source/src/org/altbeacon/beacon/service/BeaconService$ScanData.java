// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService

private class scanRecord
{

    BluetoothDevice device;
    int rssi;
    byte scanRecord[];
    final BeaconService this$0;

    public _cls9(BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        this$0 = BeaconService.this;
        super();
        device = bluetoothdevice;
        rssi = i;
        scanRecord = abyte0;
    }
}
