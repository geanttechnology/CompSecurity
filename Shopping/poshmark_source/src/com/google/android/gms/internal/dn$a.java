// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            dn, dm

public static abstract class a.ky extends Binder
    implements dn
{
    private static class a
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

        a(IBinder ibinder)
        {
            ky = ibinder;
        }
    }


    public static dn u(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
        if (iinterface != null && (iinterface instanceof dn))
        {
            return (dn)iinterface;
        } else
        {
            return new a(ibinder);
        }
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.appstate.internal.IAppStateService");
            return true;

        case 5001: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            i = cN();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5002: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            i = cO();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5003: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            a(t(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            return true;

        case 5004: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            a(t(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5005: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            a(t(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5006: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            a(t(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
            parcel1.writeNoException();
            return true;

        case 5007: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            b(t(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5008: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            b(t(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5009: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            c(t(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
