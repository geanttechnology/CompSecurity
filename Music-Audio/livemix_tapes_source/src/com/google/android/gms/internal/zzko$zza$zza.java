// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzko, zzkn, zzkp

private static class zznI
    implements zzko
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void destroy()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        zznI.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void disconnect()
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        zznI.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void zza(zzkn zzkn1)
        throws RemoteException
    {
        IBinder ibinder;
        Parcel parcel;
        ibinder = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        if (zzkn1 == null)
        {
            break MISSING_BLOCK_LABEL_23;
        }
        ibinder = zzkn1.asBinder();
        parcel.writeStrongBinder(ibinder);
        zznI.transact(6, parcel, null, 1);
        parcel.recycle();
        return;
        zzkn1;
        parcel.recycle();
        throw zzkn1;
    }

    public void zza(zzkn zzkn1, int i)
        throws RemoteException
    {
        IBinder ibinder;
        Parcel parcel;
        ibinder = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        if (zzkn1 == null)
        {
            break MISSING_BLOCK_LABEL_25;
        }
        ibinder = zzkn1.asBinder();
        parcel.writeStrongBinder(ibinder);
        parcel.writeInt(i);
        zznI.transact(5, parcel, null, 1);
        parcel.recycle();
        return;
        zzkn1;
        parcel.recycle();
        throw zzkn1;
    }

    public void zza(zzkn zzkn1, zzkp zzkp1, String s, String s1)
        throws RemoteException
    {
        Object obj;
        Parcel parcel;
        obj = null;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
        if (zzkn1 == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        zzkn1 = zzkn1.asBinder();
_L1:
        parcel.writeStrongBinder(zzkn1);
        zzkn1 = obj;
        if (zzkp1 == null)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        zzkn1 = zzkp1.asBinder();
        parcel.writeStrongBinder(zzkn1);
        parcel.writeString(s);
        parcel.writeString(s1);
        zznI.transact(4, parcel, null, 1);
        parcel.recycle();
        return;
        zzkn1 = null;
          goto _L1
        zzkn1;
        parcel.recycle();
        throw zzkn1;
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
