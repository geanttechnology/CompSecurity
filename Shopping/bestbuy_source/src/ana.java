// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class ana
    implements amy
{

    private IBinder a;

    ana(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(akd akd1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IOnStreetViewPanoramaReadyCallback");
        if (akd1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        akd1 = akd1.asBinder();
_L1:
        parcel.writeStrongBinder(akd1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        akd1 = null;
          goto _L1
        akd1;
        parcel1.recycle();
        parcel.recycle();
        throw akd1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}
