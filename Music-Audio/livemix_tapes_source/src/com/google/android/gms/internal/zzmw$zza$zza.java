// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DataTypeCreateRequest;
import com.google.android.gms.fitness.request.DataTypeReadRequest;
import com.google.android.gms.fitness.request.DisableFitRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzmw

private static class zznI
    implements zzmw
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(DataTypeCreateRequest datatypecreaterequest)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
        if (datatypecreaterequest == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        datatypecreaterequest.writeToParcel(parcel, 0);
_L1:
        zznI.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        datatypecreaterequest;
        parcel.recycle();
        throw datatypecreaterequest;
    }

    public void zza(DataTypeReadRequest datatypereadrequest)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
        if (datatypereadrequest == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        datatypereadrequest.writeToParcel(parcel, 0);
_L1:
        zznI.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        datatypereadrequest;
        parcel.recycle();
        throw datatypereadrequest;
    }

    public void zza(DisableFitRequest disablefitrequest)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitConfigApi");
        if (disablefitrequest == null)
        {
            break MISSING_BLOCK_LABEL_45;
        }
        parcel.writeInt(1);
        disablefitrequest.writeToParcel(parcel, 0);
_L1:
        zznI.transact(22, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        disablefitrequest;
        parcel.recycle();
        throw disablefitrequest;
    }

    eFitRequest(IBinder ibinder)
    {
        zznI = ibinder;
    }
}
