// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.dcp.sso;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;

// Referenced classes of package com.amazon.dcp.sso:
//            IWebserviceCallback

public static abstract class attachInterface extends Binder
    implements IWebserviceCallback
{
    private static class Proxy
        implements IWebserviceCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void onAuthenticationFailed()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IWebserviceCallback");
            mRemote.transact(3, parcel, parcel1, 0);
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

        public void onBadResponse()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IWebserviceCallback");
            mRemote.transact(4, parcel, parcel1, 0);
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

        public void onInvalidRequest()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IWebserviceCallback");
            mRemote.transact(5, parcel, parcel1, 0);
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

        public void onNetworkError()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IWebserviceCallback");
            mRemote.transact(2, parcel, parcel1, 0);
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

        public void onResponseReceived(long l, Map map, byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.dcp.sso.IWebserviceCallback");
            parcel.writeLong(l);
            parcel.writeMap(map);
            parcel.writeByteArray(abyte0);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            map;
            parcel1.recycle();
            parcel.recycle();
            throw map;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public static IWebserviceCallback asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.dcp.sso.IWebserviceCallback");
        if (iinterface != null && (iinterface instanceof IWebserviceCallback))
        {
            return (IWebserviceCallback)iinterface;
        } else
        {
            return new Proxy(ibinder);
        }
    }

    public IBinder asBinder()
    {
        return this;
    }

    public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
        throws RemoteException
    {
        switch (i)
        {
        default:
            return super.onTransact(i, parcel, parcel1, j);

        case 1598968902: 
            parcel1.writeString("com.amazon.dcp.sso.IWebserviceCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.dcp.sso.IWebserviceCallback");
            onResponseReceived(parcel.readLong(), parcel.readHashMap(getClass().getClassLoader()), parcel.createByteArray());
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.dcp.sso.IWebserviceCallback");
            onNetworkError();
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.dcp.sso.IWebserviceCallback");
            onAuthenticationFailed();
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.amazon.dcp.sso.IWebserviceCallback");
            onBadResponse();
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.amazon.dcp.sso.IWebserviceCallback");
            onInvalidRequest();
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.dcp.sso.IWebserviceCallback");
    }
}
