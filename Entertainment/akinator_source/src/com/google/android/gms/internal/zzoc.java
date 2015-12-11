// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataSourcesRequest;
import com.google.android.gms.fitness.request.SensorRegistrationRequest;
import com.google.android.gms.fitness.request.SensorUnregistrationRequest;

public interface zzoc
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zzoc
    {

        public static zzoc zzbC(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            if (iinterface != null && (iinterface instanceof zzoc))
            {
                return (zzoc)iinterface;
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
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                if (parcel.readInt() != 0)
                {
                    obj = (DataSourcesRequest)DataSourcesRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataSourcesRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (SensorRegistrationRequest)SensorRegistrationRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((SensorRegistrationRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
                obj = obj2;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (SensorUnregistrationRequest)SensorUnregistrationRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((SensorUnregistrationRequest) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zzoc
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(DataSourcesRequest datasourcesrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            if (datasourcesrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datasourcesrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datasourcesrequest;
            parcel1.recycle();
            parcel.recycle();
            throw datasourcesrequest;
        }

        public void zza(SensorRegistrationRequest sensorregistrationrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            if (sensorregistrationrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sensorregistrationrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sensorregistrationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sensorregistrationrequest;
        }

        public void zza(SensorUnregistrationRequest sensorunregistrationrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitSensorsApi");
            if (sensorunregistrationrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            sensorunregistrationrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            sensorunregistrationrequest;
            parcel1.recycle();
            parcel.recycle();
            throw sensorunregistrationrequest;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(DataSourcesRequest datasourcesrequest)
        throws RemoteException;

    public abstract void zza(SensorRegistrationRequest sensorregistrationrequest)
        throws RemoteException;

    public abstract void zza(SensorUnregistrationRequest sensorunregistrationrequest)
        throws RemoteException;
}
