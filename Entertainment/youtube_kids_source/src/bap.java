// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;
import java.util.Map;

final class bap
    implements ban
{

    private IBinder a;

    bap(IBinder ibinder)
    {
        a = ibinder;
    }

    public final void a()
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardHandle");
        a.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public final void a(String s)
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardHandle");
        parcel.writeString(s);
        a.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public final byte[] a(Map map)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.droidguard.internal.IDroidGuardHandle");
        parcel.writeMap(map);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        map = parcel1.createByteArray();
        parcel1.recycle();
        parcel.recycle();
        return map;
        map;
        parcel1.recycle();
        parcel.recycle();
        throw map;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}
