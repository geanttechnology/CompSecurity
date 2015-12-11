// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.fitness.result.SessionReadResult;

// Referenced classes of package com.google.android.gms.internal:
//            zzoh

private static class zznJ
    implements zzoh
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public void zza(SessionReadResult sessionreadresult)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.fitness.internal.ISessionReadCallback");
        if (sessionreadresult == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        sessionreadresult.writeToParcel(parcel, 0);
_L1:
        zznJ.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        sessionreadresult;
        parcel.recycle();
        throw sessionreadresult;
    }

    ReadResult(IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
