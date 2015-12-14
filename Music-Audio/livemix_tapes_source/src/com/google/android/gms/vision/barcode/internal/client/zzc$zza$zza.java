// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;

// Referenced classes of package com.google.android.gms.vision.barcode.internal.client:
//            zzc, BarcodeDetectorOptions, zzb

private static class zznI
    implements zzc
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public zzb zza(zzd zzd1, BarcodeDetectorOptions barcodedetectoroptions)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetectorCreator");
        if (zzd1 == null) goto _L2; else goto _L1
_L1:
        zzd1 = zzd1.asBinder();
_L5:
        parcel.writeStrongBinder(zzd1);
        if (barcodedetectoroptions == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        barcodedetectoroptions.writeToParcel(parcel, 0);
_L6:
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzd1 = (parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return zzd1;
_L2:
        zzd1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        zzd1;
        parcel1.recycle();
        parcel.recycle();
        throw zzd1;
          goto _L5
    }

    torOptions(IBinder ibinder)
    {
        zznI = ibinder;
    }
}
