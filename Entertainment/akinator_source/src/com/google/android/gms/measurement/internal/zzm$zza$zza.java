// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.measurement.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.measurement.internal:
//            zzm, AppMetadata, EventParcel, UserAttributeParcel

private static class zznJ
    implements zzm
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(AppMetadata appmetadata)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
        if (appmetadata == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        appmetadata.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        appmetadata;
        parcel1.recycle();
        parcel.recycle();
        throw appmetadata;
    }

    public void zza(EventParcel eventparcel, AppMetadata appmetadata)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
        if (eventparcel == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        eventparcel.writeToParcel(parcel, 0);
_L3:
        if (appmetadata == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        parcel.writeInt(1);
        appmetadata.writeToParcel(parcel, 0);
_L4:
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        eventparcel;
        parcel1.recycle();
        parcel.recycle();
        throw eventparcel;
        parcel.writeInt(0);
          goto _L4
    }

    public void zza(UserAttributeParcel userattributeparcel, AppMetadata appmetadata)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.measurement.internal.IMeasurementService");
        if (userattributeparcel == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        userattributeparcel.writeToParcel(parcel, 0);
_L3:
        if (appmetadata == null)
        {
            break MISSING_BLOCK_LABEL_95;
        }
        parcel.writeInt(1);
        appmetadata.writeToParcel(parcel, 0);
_L4:
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        userattributeparcel;
        parcel1.recycle();
        parcel.recycle();
        throw userattributeparcel;
        parcel.writeInt(0);
          goto _L4
    }

    eParcel(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
