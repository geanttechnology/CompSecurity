// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.lk;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzw

private static class zznI
    implements zzw
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public IBinder zza(lk lk1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IMobileAdsSettingManagerCreator");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        parcel.writeInt(i);
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        lk1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return lk1;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
