// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class xr
    implements xp
{

    private IBinder a;

    xr(IBinder ibinder)
    {
        a = ibinder;
    }

    public IBinder a(ry ry1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.overlay.client.IAdOverlayCreator");
        if (ry1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        ry1 = ry1.asBinder();
_L1:
        parcel.writeStrongBinder(ry1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        ry1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return ry1;
        ry1 = null;
          goto _L1
        ry1;
        parcel1.recycle();
        parcel.recycle();
        throw ry1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}
