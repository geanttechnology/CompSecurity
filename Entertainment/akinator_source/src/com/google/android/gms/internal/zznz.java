// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;

public interface zznz
    extends IInterface
{
    public static abstract class zza extends Binder
        implements zznz
    {

        public static zznz zzbz(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (iinterface != null && (iinterface instanceof zznz))
            {
                return (zznz)iinterface;
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
            Object obj5 = null;
            Object obj6 = null;
            Object obj7 = null;
            Object obj = null;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                if (parcel.readInt() != 0)
                {
                    obj = (DataReadRequest)DataReadRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataReadRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj1;
                if (parcel.readInt() != 0)
                {
                    obj = (DataInsertRequest)DataInsertRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataInsertRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj2;
                if (parcel.readInt() != 0)
                {
                    obj = (DataDeleteRequest)DataDeleteRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DataDeleteRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj3;
                if (parcel.readInt() != 0)
                {
                    obj = (GetSyncInfoRequest)GetSyncInfoRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((GetSyncInfoRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj4;
                if (parcel.readInt() != 0)
                {
                    obj = (ReadStatsRequest)ReadStatsRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((ReadStatsRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj5;
                if (parcel.readInt() != 0)
                {
                    obj = (ReadRawRequest)ReadRawRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((ReadRawRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 7: // '\007'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj6;
                if (parcel.readInt() != 0)
                {
                    obj = (DailyTotalRequest)DailyTotalRequest.CREATOR.createFromParcel(parcel);
                }
                zza(((DailyTotalRequest) (obj)));
                parcel1.writeNoException();
                return true;

            case 8: // '\b'
                parcel.enforceInterface("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
                obj = obj7;
                break;
            }
            if (parcel.readInt() != 0)
            {
                obj = (DataInsertRequest)DataInsertRequest.CREATOR.createFromParcel(parcel);
            }
            zzb(((DataInsertRequest) (obj)));
            parcel1.writeNoException();
            return true;
        }
    }

    private static class zza.zza
        implements zznz
    {

        private IBinder zznJ;

        public IBinder asBinder()
        {
            return zznJ;
        }

        public void zza(DailyTotalRequest dailytotalrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (dailytotalrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            dailytotalrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(7, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            dailytotalrequest;
            parcel1.recycle();
            parcel.recycle();
            throw dailytotalrequest;
        }

        public void zza(DataDeleteRequest datadeleterequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datadeleterequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datadeleterequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datadeleterequest;
            parcel1.recycle();
            parcel.recycle();
            throw datadeleterequest;
        }

        public void zza(DataInsertRequest datainsertrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datainsertrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datainsertrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datainsertrequest;
            parcel1.recycle();
            parcel.recycle();
            throw datainsertrequest;
        }

        public void zza(DataReadRequest datareadrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datareadrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            datareadrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datareadrequest;
            parcel1.recycle();
            parcel.recycle();
            throw datareadrequest;
        }

        public void zza(GetSyncInfoRequest getsyncinforequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (getsyncinforequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            getsyncinforequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            getsyncinforequest;
            parcel1.recycle();
            parcel.recycle();
            throw getsyncinforequest;
        }

        public void zza(ReadRawRequest readrawrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (readrawrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            readrawrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(6, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            readrawrequest;
            parcel1.recycle();
            parcel.recycle();
            throw readrawrequest;
        }

        public void zza(ReadStatsRequest readstatsrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (readstatsrequest == null)
            {
                break MISSING_BLOCK_LABEL_56;
            }
            parcel.writeInt(1);
            readstatsrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(5, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            readstatsrequest;
            parcel1.recycle();
            parcel.recycle();
            throw readstatsrequest;
        }

        public void zzb(DataInsertRequest datainsertrequest)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitHistoryApi");
            if (datainsertrequest == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            parcel.writeInt(1);
            datainsertrequest.writeToParcel(parcel, 0);
_L1:
            zznJ.transact(8, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            datainsertrequest;
            parcel1.recycle();
            parcel.recycle();
            throw datainsertrequest;
        }

        zza.zza(IBinder ibinder)
        {
            zznJ = ibinder;
        }
    }


    public abstract void zza(DailyTotalRequest dailytotalrequest)
        throws RemoteException;

    public abstract void zza(DataDeleteRequest datadeleterequest)
        throws RemoteException;

    public abstract void zza(DataInsertRequest datainsertrequest)
        throws RemoteException;

    public abstract void zza(DataReadRequest datareadrequest)
        throws RemoteException;

    public abstract void zza(GetSyncInfoRequest getsyncinforequest)
        throws RemoteException;

    public abstract void zza(ReadRawRequest readrawrequest)
        throws RemoteException;

    public abstract void zza(ReadStatsRequest readstatsrequest)
        throws RemoteException;

    public abstract void zzb(DataInsertRequest datainsertrequest)
        throws RemoteException;
}
