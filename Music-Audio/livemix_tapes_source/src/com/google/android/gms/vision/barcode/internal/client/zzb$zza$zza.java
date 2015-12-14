// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.vision.barcode.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.zzd;
import com.google.android.gms.vision.barcode.Barcode;
import com.google.android.gms.vision.internal.client.FrameMetadataParcel;

// Referenced classes of package com.google.android.gms.vision.barcode.internal.client:
//            zzb

private static class zznI
    implements zzb
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public Barcode[] zza(zzd zzd1, FrameMetadataParcel framemetadataparcel)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
        if (zzd1 == null) goto _L2; else goto _L1
_L1:
        zzd1 = zzd1.asBinder();
_L5:
        parcel.writeStrongBinder(zzd1);
        if (framemetadataparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        framemetadataparcel.writeToParcel(parcel, 0);
_L6:
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        zzd1 = (Barcode[])parcel1.createTypedArray(Barcode.CREATOR);
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

    public Barcode[] zzb(zzd zzd1, FrameMetadataParcel framemetadataparcel)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.vision.barcode.internal.client.INativeBarcodeDetector");
        if (zzd1 == null) goto _L2; else goto _L1
_L1:
        zzd1 = zzd1.asBinder();
_L5:
        parcel.writeStrongBinder(zzd1);
        if (framemetadataparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        framemetadataparcel.writeToParcel(parcel, 0);
_L6:
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        zzd1 = (Barcode[])parcel1.createTypedArray(Barcode.CREATOR);
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

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
