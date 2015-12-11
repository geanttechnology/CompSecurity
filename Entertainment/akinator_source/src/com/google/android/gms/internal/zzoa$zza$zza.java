// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DeleteAllUserDataRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzoa

private static class zznJ
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

    AllUserDataRequest(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
