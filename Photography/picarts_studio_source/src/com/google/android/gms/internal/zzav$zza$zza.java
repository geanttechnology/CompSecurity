// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;

// Referenced classes of package com.google.android.gms.internal:
//            zzav

class zznJ
    implements zzav
{

    private IBinder zznJ;

    public IBinder asBinder()
    {
        return zznJ;
    }

    public String getId()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        zznJ.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void zzb(String s, boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        int i;
        i = 0;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        parcel.writeString(s);
        if (flag)
        {
            i = 1;
        }
        parcel.writeInt(i);
        zznJ.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public boolean zzc(boolean flag)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag1;
        flag1 = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        zznJ.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = flag1;
        } else
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String zzn(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.identifier.internal.IAdvertisingIdService");
        parcel.writeString(s);
        zznJ.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        zznJ = ibinder;
    }
}
