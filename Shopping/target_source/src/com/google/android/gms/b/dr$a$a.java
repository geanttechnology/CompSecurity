// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.b;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.google.android.gms.b:
//            dr, dq

private static class a
    implements dr
{

    private IBinder a;

    public void a(dq dq1, String s, String s1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.search.internal.ISearchAuthService");
        if (dq1 == null)
        {
            break MISSING_BLOCK_LABEL_78;
        }
        dq1 = dq1.asBinder();
_L1:
        parcel.writeStrongBinder(dq1);
        parcel.writeString(s);
        parcel.writeString(s1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        dq1 = null;
          goto _L1
        dq1;
        parcel1.recycle();
        parcel.recycle();
        throw dq1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
