// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;

class aie
    implements aic
{

    private IBinder a;

    aie(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(Location location)
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.location.ILocationListener");
        if (location == null)
        {
            break MISSING_BLOCK_LABEL_44;
        }
        parcel.writeInt(1);
        location.writeToParcel(parcel, 0);
_L1:
        a.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        location;
        parcel.recycle();
        throw location;
    }

    public IBinder asBinder()
    {
        return a;
    }
}
