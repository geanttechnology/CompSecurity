// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzjp, zzjo

public static abstract class zza.zznI extends Binder
    implements zzjp
{
    private static class zza
        implements zzjp
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zza(zzjo zzjo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            zznI.transact(5005, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zza(zzjo zzjo1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            parcel.writeInt(i);
            zznI.transact(5004, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zza(zzjo zzjo1, int i, String s, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_87;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            parcel.writeInt(i);
            parcel.writeString(s);
            parcel.writeByteArray(abyte0);
            zznI.transact(5006, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zza(zzjo zzjo1, int i, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_80;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            parcel.writeInt(i);
            parcel.writeByteArray(abyte0);
            zznI.transact(5003, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zzb(zzjo zzjo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            zznI.transact(5008, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zzb(zzjo zzjo1, int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_68;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            parcel.writeInt(i);
            zznI.transact(5007, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public void zzc(zzjo zzjo1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            if (zzjo1 == null)
            {
                break MISSING_BLOCK_LABEL_59;
            }
            zzjo1 = zzjo1.asBinder();
_L1:
            parcel.writeStrongBinder(zzjo1);
            zznI.transact(5009, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            zzjo1 = null;
              goto _L1
            zzjo1;
            parcel1.recycle();
            parcel.recycle();
            throw zzjo1;
        }

        public int zzln()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            zznI.transact(5001, parcel, parcel1, 0);
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

        public int zzlo()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.google.android.gms.appstate.internal.IAppStateService");
            zznI.transact(5002, parcel, parcel1, 0);
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

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzjp zzan(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appstate.internal.IAppStateService");
        if (iinterface != null && (iinterface instanceof zzjp))
        {
            return (zzjp)iinterface;
        } else
        {
            return new zza(ibinder);
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
            i = zzln();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5002: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            i = zzlo();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5003: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zza(zzam(parcel.readStrongBinder()), parcel.readInt(), parcel.createByteArray());
            parcel1.writeNoException();
            return true;

        case 5004: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zza(zzam(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5005: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zza(zzam(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5006: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zza(zzam(parcel.readStrongBinder()), parcel.readInt(), parcel.readString(), parcel.createByteArray());
            parcel1.writeNoException();
            return true;

        case 5007: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zzb(zzam(parcel.readStrongBinder()), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5008: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zzb(zzam(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 5009: 
            parcel.enforceInterface("com.google.android.gms.appstate.internal.IAppStateService");
            zzc(zzam(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }
    }
}
