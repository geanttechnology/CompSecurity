// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

final class bbu
    implements bbs
{

    private IBinder a;

    bbu(IBinder ibinder)
    {
        a = ibinder;
    }

    public final IBinder a(String s, ayh ayh1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.adshield.internal.IAdShieldCreator");
        parcel.writeString(s);
        if (ayh1 == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        s = ayh1.asBinder();
_L1:
        parcel.writeStrongBinder(s);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return s;
        s = null;
          goto _L1
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public final IBinder asBinder()
    {
        return a;
    }
}
