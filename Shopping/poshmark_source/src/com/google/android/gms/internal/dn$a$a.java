// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            dn, dm

private static class ky
    implements dn
{

    private IBinder ky;

    public void a(dm dm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        ky.transact(5005, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public void a(dm dm1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        parcel.writeInt(i);
        ky.transact(5004, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public void a(dm dm1, int i, String s, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_87;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        parcel.writeInt(i);
        parcel.writeString(s);
        parcel.writeByteArray(abyte0);
        ky.transact(5006, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public void a(dm dm1, int i, byte abyte0[])
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_80;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        parcel.writeInt(i);
        parcel.writeByteArray(abyte0);
        ky.transact(5003, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public IBinder asBinder()
    {
        return ky;
    }

    public void b(dm dm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        ky.transact(5008, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public void b(dm dm1, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_68;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        parcel.writeInt(i);
        ky.transact(5007, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public void c(dm dm1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        if (dm1 == null)
        {
            break MISSING_BLOCK_LABEL_59;
        }
        dm1 = dm1.asBinder();
_L1:
        parcel.writeStrongBinder(dm1);
        ky.transact(5009, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dm1 = null;
          goto _L1
        dm1;
        parcel1.recycle();
        parcel.recycle();
        throw dm1;
    }

    public int cN()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        ky.transact(5001, parcel, parcel1, 0);
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

    public int cO()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
        ky.transact(5002, parcel, parcel1, 0);
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
        ky = ibinder;
    }
}
