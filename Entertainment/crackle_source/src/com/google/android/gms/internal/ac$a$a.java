// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.gms.internal;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.dynamic.b;

// Referenced classes of package com.google.android.gms.internal:
//            ac, ab, ae, x, 
//            v, y

private static class dU
    implements ac
{

    private IBinder dU;

    public void H()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(11, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void a(ab ab1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (ab1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ab1 = ab1.asBinder();
_L1:
        parcel.writeStrongBinder(ab1);
        dU.transact(7, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ab1 = null;
          goto _L1
        ab1;
        parcel1.recycle();
        parcel.recycle();
        throw ab1;
    }

    public void a(ae ae1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (ae1 == null)
        {
            break MISSING_BLOCK_LABEL_58;
        }
        ae1 = ae1.asBinder();
_L1:
        parcel.writeStrongBinder(ae1);
        dU.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        ae1 = null;
          goto _L1
        ae1;
        parcel1.recycle();
        parcel.recycle();
        throw ae1;
    }

    public void a(x x1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (x1 == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        parcel.writeInt(1);
        x1.writeToParcel(parcel, 0);
_L1:
        dU.transact(13, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        x1;
        parcel1.recycle();
        parcel.recycle();
        throw x1;
    }

    public boolean a(v v1)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        if (v1 == null)
        {
            break MISSING_BLOCK_LABEL_72;
        }
        parcel.writeInt(1);
        v1.writeToParcel(parcel, 0);
_L1:
        int i;
        dU.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i == 0)
        {
            flag = false;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        parcel.writeInt(0);
          goto _L1
        v1;
        parcel1.recycle();
        parcel.recycle();
        throw v1;
    }

    public IBinder asBinder()
    {
        return dU;
    }

    public void destroy()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public boolean isReady()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
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

    public void pause()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void resume()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void showInterstitial()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void stopLoading()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public b x()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        b b;
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        b = com.google.android.gms.dynamic..dU(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return b;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public x y()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.google.android.gms.ads.internal.client.IAdManager");
        dU.transact(12, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        x x1 = x.CREATOR.b(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return x1;
_L2:
        x1 = null;
        if (true) goto _L4; else goto _L3
_L3:
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    (IBinder ibinder)
    {
        dU = ibinder;
    }
}
