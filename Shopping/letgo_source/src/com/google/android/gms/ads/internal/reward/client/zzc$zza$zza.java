// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.reward.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.lk;
import android.support.v7.pz;

// Referenced classes of package com.google.android.gms.ads.internal.reward.client:
//            zzc

private static class zznI
    implements zzc
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public IBinder zza(lk lk1, pz pz1, int i)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.reward.client.IRewardedVideoAdCreator");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_102;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        lk1 = obj;
        if (pz1 == null)
        {
            break MISSING_BLOCK_LABEL_51;
        }
        lk1 = pz1.asBinder();
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
