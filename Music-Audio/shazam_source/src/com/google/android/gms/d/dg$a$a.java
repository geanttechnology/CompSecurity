// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.d;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.d:
//            dg, dh

private static final class a
    implements dg
{

    private IBinder a;

    public final dh a(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        parcel.writeString(s);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return s;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public final IBinder asBinder()
    {
        return a;
    }

    public final boolean b(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.mediation.client.IAdapterCreator");
        parcel.writeString(s);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
