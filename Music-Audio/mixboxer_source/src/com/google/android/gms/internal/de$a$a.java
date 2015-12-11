// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            de, dd

private static class dU
    implements de
{

    private IBinder dU;

    public void a(dd dd1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        dU.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public void a(dd dd1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        parcel.writeInt(i);
        dU.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public void a(dd dd1, int i, String s, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        dU.transact(5006, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public void a(dd dd1, int i, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        parcel.writeInt(i);
        parcel.writeByteArray(abyte0);
        dU.transact(5003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public IBinder asBinder()
    {
        return dU;
    }

    public void b(dd dd1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        dU.transact(5008, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public void b(dd dd1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        parcel.writeInt(i);
        dU.transact(5007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public void c(dd dd1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dd1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dd1 = dd1.asBinder();
_L1:
        parcel.writeStrongBinder(dd1);
        dU.transact(5009, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dd1 = null;
          goto _L1
        dd1;
        parcel1.recycle();
        parcel.recycle();
        throw dd1;
    }

    public int getMaxNumKeys()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        dU.transact(5002, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public int getMaxStateSize()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        dU.transact(5001, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        dU = ibinder;
    }
}
