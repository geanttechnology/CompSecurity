// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

final class aas
    implements IInterface
{

    private final IBinder a;

    public aas(IBinder ibinder)
    {
        a = ibinder;
    }

    public String a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Object obj;
        obj;
        zw.h().a("Fabric", "Could not get parcel from Google Play Service to capture AdvertisingId");
        parcel1.recycle();
        parcel.recycle();
        return null;
        obj;
        parcel1.recycle();
        parcel.recycle();
        throw obj;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public boolean b()
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        parcel.writeInt(1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i == 0)
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Object obj;
        obj;
        zw.h().a("Fabric", "Could not get parcel from Google Play Service to capture Advertising limitAdTracking");
        parcel1.recycle();
        parcel.recycle();
        return false;
        obj;
        parcel1.recycle();
        parcel.recycle();
        throw obj;
    }
}
