// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class amc
    implements ama
{

    private IBinder a;

    amc(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(ajo ajo1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnMapReadyCallback");
        if (ajo1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        ajo1 = ajo1.asBinder();
_L1:
        parcel.writeStrongBinder(ajo1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ajo1 = null;
          goto _L1
        ajo1;
        parcel1.recycle();
        parcel.recycle();
        throw ajo1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}
