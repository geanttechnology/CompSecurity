// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.ListSubscriptionsResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoe

private static class zznJ
    implements zzoe
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(ListSubscriptionsResult listsubscriptionsresult)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.IListSubscriptionsCallback");
        if (listsubscriptionsresult == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        listsubscriptionsresult.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        listsubscriptionsresult;
        parcel.recycle();
        throw listsubscriptionsresult;
    }

    scriptionsResult(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
