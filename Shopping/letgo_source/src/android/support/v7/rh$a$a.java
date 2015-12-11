// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v7:
//            rh, lk

private static class a
    implements rh
{

    private IBinder a;

    public IBinder a(lk lk1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.purchase.client.IInAppPurchaseManagerCreator");
        if (lk1 == null)
        {
            break MISSING_BLOCK_LABEL_63;
        }
        lk1 = lk1.asBinder();
_L1:
        parcel.writeStrongBinder(lk1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        lk1 = parcel1.readStrongBinder();
        parcel1.recycle();
        parcel.recycle();
        return lk1;
        lk1 = null;
          goto _L1
        lk1;
        parcel1.recycle();
        parcel.recycle();
        throw lk1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
