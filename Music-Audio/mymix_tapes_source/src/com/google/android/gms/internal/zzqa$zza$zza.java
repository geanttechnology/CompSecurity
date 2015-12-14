// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzqa, zzpz

private static class zznI
    implements zzqa
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(zzpz zzpz1, String s, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
        if (zzpz1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        zzpz1 = zzpz1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpz1);
        parcel.writeString(s);
        parcel.writeString(s1);
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpz1 = null;
          goto _L1
        zzpz1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpz1;
    }

    public void zzb(zzpz zzpz1, String s, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
        if (zzpz1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        zzpz1 = zzpz1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpz1);
        parcel.writeString(s);
        parcel.writeString(s1);
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpz1 = null;
          goto _L1
        zzpz1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpz1;
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
