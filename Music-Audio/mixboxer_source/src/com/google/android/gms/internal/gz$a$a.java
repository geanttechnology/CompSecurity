// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.internal:
//            gz, hb

private static class dU
    implements gz
{

    private IBinder dU;

    public void a(int i, hb hb1)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.places.internal.IPlacesCallbacks");
        parcel.writeInt(i);
        if (hb1 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        parcel.writeInt(1);
        hb1.writeToParcel(parcel, 0);
_L1:
        dU.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        hb1;
        parcel.recycle();
        throw hb1;
    }

    public IBinder asBinder()
    {
        return dU;
    }

    (IBinder ibinder)
    {
        dU = ibinder;
    }
}
