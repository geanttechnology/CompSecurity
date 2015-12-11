// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package org.altbeacon.beacon.service.scanner;

import android.bluetooth.BluetoothDevice;

public interface CycledLeScanCallback
{

    public abstract void onCycleEnd();

    public abstract void onLeScan(BluetoothDevice bluetoothdevice, int i, byte abyte0[]);
}
