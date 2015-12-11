// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SyncInfoResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzok

private static class zznJ
    implements zzok
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(SyncInfoResult syncinforesult)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.ISyncInfoCallback");
        if (syncinforesult == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        syncinforesult.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        syncinforesult;
        parcel.recycle();
        throw syncinforesult;
    }

    oResult(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
