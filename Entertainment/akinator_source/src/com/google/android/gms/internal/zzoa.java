// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DeleteAllUserDataRequest;

public interface zzoa
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzoa
    {

        public static zzoa zzbA(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            if (iinterface != null && (iinterface instanceof zzoa))
            {
                return (zzoa)iinterface;
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
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
                break;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (DeleteAllUserDataRequest)DeleteAllUserDataRequest.CREATOR.createFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            zza(parcel);
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzoa
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(DeleteAllUserDataRequest deletealluserdatarequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
            if (deletealluserdatarequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            deletealluserdatarequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            deletealluserdatarequest;
            parcel1.recycle();
            parcel.recycle();
            throw deletealluserdatarequest;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(DeleteAllUserDataRequest deletealluserdatarequest)
        throws RemoteException;
}
