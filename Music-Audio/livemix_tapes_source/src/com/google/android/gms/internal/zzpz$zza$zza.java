// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.search.GoogleNowAuthState;

// Referenced classes of package com.google.android.gms.internal:
//            zzpz

private static class zznI
    implements zzpz
{

    private IBinder zznI;

    public IBinder asBinder()
    {
        return zznI;
    }

    public void zza(Status status, GoogleNowAuthState googlenowauthstate)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        if (status == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L3:
        if (googlenowauthstate == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        parcel.writeInt(1);
        googlenowauthstate.writeToParcel(parcel, 0);
_L4:
        zznI.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        status;
        parcel.recycle();
        throw status;
        parcel.writeInt(0);
          goto _L4
    }

    public void zzbc(Status status)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthCallbacks");
        if (status == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        status.writeToParcel(parcel, 0);
_L1:
        zznI.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        status;
        parcel.recycle();
        throw status;
    }

    ate(IBinder ibinder)
    {
        zznI = ibinder;
    }
}
