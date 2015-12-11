// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            zzky, zzla

public interface zzkz
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzkz
    {

        public static zzkz zzaE(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            if (iinterface != null && (iinterface instanceof zzkz))
            {
                return (zzkz)iinterface;
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
                parcel1.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                destroy();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                disconnect();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                zza(zzky.zza.zzaD(parcel.readStrongBinder()), zzla.zza.zzaF(parcel.readStrongBinder()), parcel.readString(), parcel.readString());
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                zza(zzky.zza.zzaD(parcel.readStrongBinder()), parcel.readInt());
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
                zza(zzky.zza.zzaD(parcel.readStrongBinder()));
                return true;
            }
        }
    }

    private static class zza.zza
        implements zzkz
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void destroy()
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            zznJ.transact(2, parcel, null, 1);
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
            zznJ.transact(3, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        public void zza(zzky zzky1)
            throws RemoteException
        {
            IBinder ibinder;
            Parcel parcel;
            ibinder = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            if (zzky1 == null)
            {
                break MISSING_BLOCK_LABEL_23;
            }
            ibinder = zzky1.asBinder();
            parcel.writeStrongBinder(ibinder);
            zznJ.transact(6, parcel, null, 1);
            parcel.recycle();
            return;
            zzky1;
            parcel.recycle();
            throw zzky1;
        }

        public void zza(zzky zzky1, int i)
            throws RemoteException
        {
            IBinder ibinder;
            Parcel parcel;
            ibinder = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            if (zzky1 == null)
            {
                break MISSING_BLOCK_LABEL_25;
            }
            ibinder = zzky1.asBinder();
            parcel.writeStrongBinder(ibinder);
            parcel.writeInt(i);
            zznJ.transact(5, parcel, null, 1);
            parcel.recycle();
            return;
            zzky1;
            parcel.recycle();
            throw zzky1;
        }

        public void zza(zzky zzky1, zzla zzla1, String s, String s1)
            throws RemoteException
        {
            Object obj;
            Parcel parcel;
            obj = null;
            parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
            if (zzky1 == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            zzky1 = zzky1.asBinder();
_L1:
            parcel.writeStrongBinder(zzky1);
            zzky1 = obj;
            if (zzla1 == null)
            {
                break MISSING_BLOCK_LABEL_46;
            }
            zzky1 = zzla1.asBinder();
            parcel.writeStrongBinder(zzky1);
            parcel.writeString(s);
            parcel.writeString(s1);
            zznJ.transact(4, parcel, null, 1);
            parcel.recycle();
            return;
            zzky1 = null;
              goto _L1
            zzky1;
            parcel.recycle();
            throw zzky1;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void destroy()
        throws RemoteException;

    public abstract void disconnect()
        throws RemoteException;

    public abstract void zza(zzky zzky)
        throws RemoteException;

    public abstract void zza(zzky zzky, int i)
        throws RemoteException;

    public abstract void zza(zzky zzky, zzla zzla, String s, String s1)
        throws RemoteException;
}
