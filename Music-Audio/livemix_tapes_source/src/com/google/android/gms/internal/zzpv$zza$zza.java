// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzpv, zzpu

private static class zznI
    implements zzpv
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(zzpu zzpu1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzpu1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        zzpu1 = zzpu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpu1);
        zznI.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpu1 = null;
          goto _L1
        zzpu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpu1;
    }

    public void zza(zzpu zzpu1, String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzpu1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        zzpu1 = zzpu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpu1);
        parcel.writeString(s);
        zznI.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpu1 = null;
          goto _L1
        zzpu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpu1;
    }

    public void zza(zzpu zzpu1, String s, int ai[], int i, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzpu1 == null)
        {
            break MISSING_BLOCK_LABEL_92;
        }
        zzpu1 = zzpu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpu1);
        parcel.writeString(s);
        parcel.writeIntArray(ai);
        parcel.writeInt(i);
        parcel.writeString(s1);
        zznI.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpu1 = null;
          goto _L1
        zzpu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpu1;
    }

    public void zza(zzpu zzpu1, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.safetynet.internal.ISafetyNetService");
        if (zzpu1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        zzpu1 = zzpu1.asBinder();
_L1:
        parcel.writeStrongBinder(zzpu1);
        parcel.writeByteArray(abyte0);
        zznI.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        zzpu1 = null;
          goto _L1
        zzpu1;
        parcel1.recycle();
        parcel.recycle();
        throw zzpu1;
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
