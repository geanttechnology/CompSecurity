// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

final class bbp
    implements bbn
{

    private IBinder a;

    bbp(IBinder ibinder)
    {
        a = ibinder;
    }

    public final ayh a(ayh ayh1, ayh ayh2)
    {
        Object obj;
        Parcel parcel;
        Parcel parcel1;
        obj = null;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        if (ayh1 == null)
        {
            break MISSING_BLOCK_LABEL_98;
        }
        ayh1 = ayh1.asBinder();
_L1:
        parcel.writeStrongBinder(ayh1);
        ayh1 = obj;
        if (ayh2 == null)
        {
            break MISSING_BLOCK_LABEL_49;
        }
        ayh1 = ayh2.asBinder();
        parcel.writeStrongBinder(ayh1);
        a.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        ayh1 = ayi.a(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return ayh1;
        ayh1 = null;
          goto _L1
        ayh1;
        parcel1.recycle();
        parcel.recycle();
        throw ayh1;
    }

    public final String a()
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        a.transact(1, parcel, parcel1, 0);
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

    public final void a(String s)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        parcel.writeString(s);
        a.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public final void a(String s, String s1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        parcel.writeString(s);
        parcel.writeString(s1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public final boolean a(ayh ayh1)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        if (ayh1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ayh1 = ayh1.asBinder();
_L1:
        int i;
        parcel.writeStrongBinder(ayh1);
        a.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        ayh1 = null;
          goto _L1
        ayh1;
        parcel1.recycle();
        parcel.recycle();
        throw ayh1;
    }

    public final IBinder asBinder()
    {
        return a;
    }

    public final boolean b(ayh ayh1)
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        if (ayh1 == null)
        {
            break MISSING_BLOCK_LABEL_76;
        }
        ayh1 = ayh1.asBinder();
_L1:
        int i;
        parcel.writeStrongBinder(ayh1);
        a.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        ayh1 = null;
          goto _L1
        ayh1;
        parcel1.recycle();
        parcel.recycle();
        throw ayh1;
    }

    public final String c(ayh ayh1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldClient");
        if (ayh1 == null)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        ayh1 = ayh1.asBinder();
_L1:
        parcel.writeStrongBinder(ayh1);
        a.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        ayh1 = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return ayh1;
        ayh1 = null;
          goto _L1
        ayh1;
        parcel1.recycle();
        parcel.recycle();
        throw ayh1;
    }
}
