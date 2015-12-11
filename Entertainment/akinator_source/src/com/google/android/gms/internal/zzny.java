// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;

public interface zzny
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzny
    {

        public static zzny zzby(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            if (iinterface != null && (iinterface instanceof zzny))
            {
                return (zzny)iinterface;
            } else
            {
                return new zza(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            Object obj1 = null;
            Object obj2 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                if (parcel.readInt() != 0)
                {
                    obj = (DataTypeCreateRequest)DataTypeCreateRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataTypeCreateRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (DataTypeReadRequest)DataTypeReadRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataTypeReadRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 22: // '\026'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
                obj = obj2;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (DisableFitRequest)DisableFitRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((DisableFitRequest) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzny
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(DataTypeCreateRequest datatypecreaterequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            if (datatypecreaterequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datatypecreaterequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datatypecreaterequest;
            parcel1.recycle();
            parcel.recycle();
            throw datatypecreaterequest;
        }

        public void zza(DataTypeReadRequest datatypereadrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            if (datatypereadrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datatypereadrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datatypereadrequest;
            parcel1.recycle();
            parcel.recycle();
            throw datatypereadrequest;
        }

        public void zza(DisableFitRequest disablefitrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
            if (disablefitrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            disablefitrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(22, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            disablefitrequest;
            parcel1.recycle();
            parcel.recycle();
            throw disablefitrequest;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(DataTypeCreateRequest datatypecreaterequest)
        throws RemoteException;

    public abstract void zza(DataTypeReadRequest datatypereadrequest)
        throws RemoteException;

    public abstract void zza(DisableFitRequest disablefitrequest)
        throws RemoteException;
}
