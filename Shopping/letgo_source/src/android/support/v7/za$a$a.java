// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package android.support.v7:
//            za, aab, lk

private static class a
    implements za
{

    private IBinder a;

    public lk a(aab aab1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if (aab1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aab1 = aab1.asBinder();
_L1:
        parcel.writeStrongBinder(aab1);
        a.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        aab1 = ption(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return aab1;
        aab1 = null;
          goto _L1
        aab1;
        parcel1.recycle();
        parcel.recycle();
        throw aab1;
    }

    public IBinder asBinder()
    {
        return a;
    }

    public lk b(aab aab1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.maps.internal.IInfoWindowAdapter");
        if (aab1 == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        aab1 = aab1.asBinder();
_L1:
        parcel.writeStrongBinder(aab1);
        a.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        aab1 = ption(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return aab1;
        aab1 = null;
          goto _L1
        aab1;
        parcel1.recycle();
        parcel.recycle();
        throw aab1;
    }

    (IBinder ibinder)
    {
        a = ibinder;
    }
}
