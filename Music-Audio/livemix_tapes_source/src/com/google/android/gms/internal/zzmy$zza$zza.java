// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.request.DeleteAllUserDataRequest;

// Referenced classes of package com.google.android.gms.internal:
//            zzmy

private static class zznI
    implements zzmy
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(DeleteAllUserDataRequest deletealluserdatarequest)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IGoogleFitInternalApi");
        if (deletealluserdatarequest == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        deletealluserdatarequest.writeToParcel(parcel, 0);
_L1:
        zznI.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        deletealluserdatarequest;
        parcel.recycle();
        throw deletealluserdatarequest;
    }

    AllUserDataRequest(IBinder ibinder)
    {
        zznI = ibinder;
    }
}
