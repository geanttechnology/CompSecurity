// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.nearby.bootstrap.Device;

// Referenced classes of package com.google.android.gms.internal:
//            zzpa

public static abstract class zza.zznI extends Binder
    implements zzpa
{
    private static class zza
        implements zzpa
    {

        private IBinder zznI;

        public IBinder asBinder()
        {
            return zznI;
        }

        public void onError(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            parcel.writeInt(i);
            zznI.transact(3, parcel, parcel1, 0);
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

        public void onScanStopped()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            zznI.transact(2, parcel, parcel1, 0);
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

        public void zza(Device device)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            if (device == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            device.writeToParcel(parcel, 0);
_L1:
            zznI.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            device;
            parcel1.recycle();
            parcel.recycle();
            throw device;
        }

        zza(IBinder ibinder)
        {
            zznI = ibinder;
        }
    }


    public static zzpa zzdd(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
        if (iinterface != null && (iinterface instanceof zzpa))
        {
            return (zzpa)iinterface;
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
            parcel1.writeString("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            if (parcel.readInt() != 0)
            {
                parcel = (Device)Device.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(parcel);
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            onScanStopped();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.nearby.bootstrap.internal.IScanListener");
            onError(parcel.readInt());
            parcel1.writeNoException();
            return true;
        }
    }
}
