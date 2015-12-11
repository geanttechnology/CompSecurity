// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

import android.os.IBinder;
import android.os.Parcel;

class yl
    implements yj
{

    private IBinder a;

    yl(IBinder ibinder)
    {
        a = ibinder;
    }

    public void a(yg yg1)
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseListener");
        if (yg1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        yg1 = yg1.asBinder();
_L1:
        parcel.writeStrongBinder(yg1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        yg1 = null;
          goto _L1
        yg1;
        parcel1.recycle();
        parcel.recycle();
        throw yg1;
    }

    public IBinder asBinder()
    {
        return a;
    }
}
