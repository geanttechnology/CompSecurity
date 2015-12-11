// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DailyTotalRequest;
import com.google.android.gms.fitness.request.DataDeleteRequest;
import com.google.android.gms.fitness.request.DataInsertRequest;
import com.google.android.gms.fitness.request.DataReadRequest;
import com.google.android.gms.fitness.request.GetSyncInfoRequest;
import com.google.android.gms.fitness.request.ReadRawRequest;
import com.google.android.gms.fitness.request.ReadStatsRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zznz

private static class zznJ
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

    sertRequest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
