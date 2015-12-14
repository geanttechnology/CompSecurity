// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.data.DataHolder;

// Referenced classes of package com.google.android.gms.internal:
//            zzjo

private static class zznI
    implements zzjo
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(int i, DataHolder dataholder)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        parcel.writeInt(i);
        if (dataholder == null)
        {
            break MISSING_BLOCK_LABEL_67;
        }
        parcel.writeInt(1);
        dataholder.writeToParcel(parcel, 0);
_L1:
        zznI.transact(5001, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        dataholder;
        parcel1.recycle();
        parcel.recycle();
        throw dataholder;
    }

    public void zza(DataHolder dataholder)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        if (dataholder == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        parcel.writeInt(1);
        dataholder.writeToParcel(parcel, 0);
_L1:
        zznI.transact(5002, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        dataholder;
        parcel1.recycle();
        parcel.recycle();
        throw dataholder;
    }

    public void zzap(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        parcel.writeInt(i);
        zznI.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zzg(int i, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        parcel.writeInt(i);
        parcel.writeInt(j);
        zznI.transact(5003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zzll()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateCallbacks");
        zznI.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        zznI = ibinder;
    }
}
