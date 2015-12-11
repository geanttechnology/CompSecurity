// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.alipay.android.app;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.alipay.android.app:
//            IAlixPay, IRemoteServiceCallback

private static class mRemote
    implements IAlixPay
{

    private IBinder mRemote;

    public String Pay(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel.writeString(s);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public IBinder asBinder()
    {
        return mRemote;
    }

    public void deployFastConnect()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        mRemote.transact(6, parcel, parcel1, 0);
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

    public String prePay(String s)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        parcel.writeString(s);
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        s = parcel1.readString();
        parcel1.recycle();
        parcel.recycle();
        return s;
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    public void registerCallback(IRemoteServiceCallback iremoteservicecallback)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (iremoteservicecallback == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        iremoteservicecallback = iremoteservicecallback.asBinder();
_L1:
        parcel.writeStrongBinder(iremoteservicecallback);
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        iremoteservicecallback = null;
          goto _L1
        iremoteservicecallback;
        parcel1.recycle();
        parcel.recycle();
        throw iremoteservicecallback;
    }

    public String test()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        String s;
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        mRemote.transact(2, parcel, parcel1, 0);
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

    public void unregisterCallback(IRemoteServiceCallback iremoteservicecallback)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.alipay.android.app.IAlixPay");
        if (iremoteservicecallback == null)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        iremoteservicecallback = iremoteservicecallback.asBinder();
_L1:
        parcel.writeStrongBinder(iremoteservicecallback);
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        iremoteservicecallback = null;
          goto _L1
        iremoteservicecallback;
        parcel1.recycle();
        parcel.recycle();
        throw iremoteservicecallback;
    }

    ck(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
