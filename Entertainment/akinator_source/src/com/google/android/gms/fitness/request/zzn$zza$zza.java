// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.fitness.request;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.data.BleDevice;

// Referenced classes of package com.google.android.gms.fitness.request:
//            zzn

private static class zznJ
    implements zzn
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void onDeviceFound(BleDevice bledevice)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
        if (bledevice == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        bledevice.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        bledevice;
        parcel.recycle();
        throw bledevice;
    }

    public void onScanStopped()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.request.IBleScanCallback");
        zznJ.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
