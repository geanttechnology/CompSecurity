// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.radiusnetworks.ibeacon.service;

import android.bluetooth.BluetoothDevice;

// Referenced classes of package com.radiusnetworks.ibeacon.service:
//            IBeaconService

private class scanRecord
{

    public BluetoothDevice device;
    public int rssi;
    public byte scanRecord[];
    final IBeaconService this$0;

    public (BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        this$0 = IBeaconService.this;
        super();
        device = bluetoothdevice;
        rssi = i;
        scanRecord = abyte0;
    }
}
