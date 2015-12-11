// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.ads.internal.client;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.support.v7.lk;
import android.support.v7.pz;

// Referenced classes of package com.google.android.gms.ads.internal.client:
//            zzs, AdSizeParcel

private static class zznI
    implements zzs
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public IBinder zza(lk lk1, AdSizeParcel adsizeparcel, String s, pz pz1, int i)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (lk1 == null) goto _L2; else goto _L1
_L1:
        lk1 = lk1.asBinder();
_L5:
        parcel.writeStrongBinder(lk1);
        if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        adsizeparcel.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        lk1 = obj;
        if (pz1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
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
_L2:
        lk1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
          goto _L5
    }

    public IBinder zza(lk lk1, AdSizeParcel adsizeparcel, String s, pz pz1, int i, int j)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManagerCreator");
        if (lk1 == null) goto _L2; else goto _L1
_L1:
        lk1 = lk1.asBinder();
_L5:
        parcel.writeStrongBinder(lk1);
        if (adsizeparcel == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        adsizeparcel.writeToParcel(parcel, 0);
_L6:
        parcel.writeString(s);
        lk1 = obj;
        if (pz1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        lk1 = pz1.asBinder();
        parcel.writeStrongBinder(lk1);
        parcel.writeInt(i);
        parcel.writeInt(j);
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        lk1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return lk1;
_L2:
        lk1 = null;
          goto _L5
_L4:
        parcel.writeInt(0);
          goto _L6
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
          goto _L5
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
