// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ClaimBleDeviceRequest;
import com.google.android.gms.fitness.request.ListClaimedBleDevicesRequest;
import com.google.android.gms.fitness.request.StartBleScanRequest;
import com.google.android.gms.fitness.request.StopBleScanRequest;
import com.google.android.gms.fitness.request.UnclaimBleDeviceRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznx

public static abstract class zza.zznJ extends Binder
    implements zznx
{
    private static class zza
        implements zznx
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(ClaimBleDeviceRequest claimbledevicerequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (claimbledevicerequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            claimbledevicerequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            claimbledevicerequest;
            parcel1.recycle();
            parcel.recycle();
            throw claimbledevicerequest;
        }

        public void zza(ListClaimedBleDevicesRequest listclaimedbledevicesrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (listclaimedbledevicesrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            listclaimedbledevicesrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            listclaimedbledevicesrequest;
            parcel1.recycle();
            parcel.recycle();
            throw listclaimedbledevicesrequest;
        }

        public void zza(StartBleScanRequest startblescanrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (startblescanrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            startblescanrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            startblescanrequest;
            parcel1.recycle();
            parcel.recycle();
            throw startblescanrequest;
        }

        public void zza(StopBleScanRequest stopblescanrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (stopblescanrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            stopblescanrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            stopblescanrequest;
            parcel1.recycle();
            parcel.recycle();
            throw stopblescanrequest;
        }

        public void zza(UnclaimBleDeviceRequest unclaimbledevicerequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (unclaimbledevicerequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            unclaimbledevicerequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            unclaimbledevicerequest;
            parcel1.recycle();
            parcel.recycle();
            throw unclaimbledevicerequest;
        }

        zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public static zznx zzbx(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
        if (iinterface != null && (iinterface instanceof zznx))
        {
            return (zznx)iinterface;
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
        Object obj3 = null;
        Object obj4 = null;
        Object obj = null;
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            if (parcel.readInt() != 0)
            {
                obj = (StartBleScanRequest)StartBleScanRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((StartBleScanRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            obj = obj1;
            if (parcel.readInt() != 0)
            {
                obj = (StopBleScanRequest)StopBleScanRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((StopBleScanRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            obj = obj2;
            if (parcel.readInt() != 0)
            {
                obj = (ClaimBleDeviceRequest)ClaimBleDeviceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((ClaimBleDeviceRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            obj = obj3;
            if (parcel.readInt() != 0)
            {
                obj = (UnclaimBleDeviceRequest)UnclaimBleDeviceRequest.CREATOR.createFromParcel(parcel);
            }
            zza(((UnclaimBleDeviceRequest) (obj)));
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitBleApi");
            obj = obj4;
            break;
        }
        if (parcel.readInt() != 0)
        {
            obj = (ListClaimedBleDevicesRequest)ListClaimedBleDevicesRequest.CREATOR.createFromParcel(parcel);
        }
        zza(((ListClaimedBleDevicesRequest) (obj)));
        parcel1.writeNoException();
        return true;
    }
}
