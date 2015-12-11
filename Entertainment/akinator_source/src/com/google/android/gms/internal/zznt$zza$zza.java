// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.DailyTotalResult;

// Referenced classes of package com.google.android.gms.internal:
//            zznt

private static class zznJ
    implements zznt
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(DailyTotalResult dailytotalresult)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IDailyTotalCallback");
        if (dailytotalresult == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        dailytotalresult.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        dailytotalresult;
        parcel.recycle();
        throw dailytotalresult;
    }

    talResult(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
