// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;

public interface zzjk
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzjk
    {

        public static zzjk zzaj(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
            if (iinterface != null && (iinterface instanceof zzjk))
            {
                return (zzjk)iinterface;
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
                parcel1.writeString("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (Status)Status.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zze(parcel);
            parcel1.writeNoException();
            return true;
        }

        public zza()
        {
            attachInterface(this, "com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
        }
    }

    private static class zza.zza
        implements zzjk
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void zze(Status status)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.appinvite.internal.IAppInviteCallbacks");
            if (status == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            status.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            status;
            parcel1.recycle();
            parcel.recycle();
            throw status;
        }

        zza.zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public abstract void zze(Status status)
        throws RemoteException;
}
