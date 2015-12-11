// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service;

import android.bluetooth.BluetoothDevice;

// Referenced classes of package org.altbeacon.beacon.service:
//            BeaconService

private class c
{

    int a;
    BluetoothDevice b;
    byte c[];
    final BeaconService d;

    public (BeaconService beaconservice, BluetoothDevice bluetoothdevice, int i, byte abyte0[])
    {
        d = beaconservice;
        super();
        b = bluetoothdevice;
        a = i;
        c = abyte0;
    }
}
