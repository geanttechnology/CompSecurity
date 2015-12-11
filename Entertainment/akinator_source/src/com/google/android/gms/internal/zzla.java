// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface zzla
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzla
    {

        public static zzla zzaF(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
            if (iinterface != null && (iinterface instanceof zzla))
            {
                return (zzla)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public IBinder asBinder()
        {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
                zzbg(parcel.readInt());
                return true;
            }
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
        }
    }

    private static class zza.zza
        implements zzla
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zzbg(int i)
            throws RemoteException
        {
            Parcel parcel = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
            parcel.writeInt(i);
            zznJ.transact(1, parcel, null, 1);
            parcel.recycle();
            return;
            Exception exception;
            exception;
            parcel.recycle();
            throw exception;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zzbg(int i)
        throws RemoteException;
}
