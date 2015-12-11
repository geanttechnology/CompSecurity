// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.ListSubscriptionsRequest;
import com.google.android.gms.fitness.request.SubscribeRequest;
import com.google.android.gms.fitness.request.UnsubscribeRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzob

private static class zznJ
    implements zzob
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(ListSubscriptionsRequest listsubscriptionsrequest)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
        if (listsubscriptionsrequest == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        listsubscriptionsrequest.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        listsubscriptionsrequest;
        parcel1.recycle();
        parcel.recycle();
        throw listsubscriptionsrequest;
    }

    public void zza(SubscribeRequest subscriberequest)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
        if (subscriberequest == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        subscriberequest.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        subscriberequest;
        parcel1.recycle();
        parcel.recycle();
        throw subscriberequest;
    }

    public void zza(UnsubscribeRequest unsubscriberequest)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitRecordingApi");
        if (unsubscriberequest == null)
        {
            break MISSING_BLOCK_LABEL_56;
        }
        parcel.writeInt(1);
        unsubscriberequest.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        unsubscriberequest;
        parcel1.recycle();
        parcel.recycle();
        throw unsubscriberequest;
    }

    cribeRequest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
