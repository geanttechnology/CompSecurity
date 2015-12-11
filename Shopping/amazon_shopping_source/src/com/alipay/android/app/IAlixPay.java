// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.alipay.android.app;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.alipay.android.app:
//            IRemoteServiceCallback

public interface IAlixPay
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IAlixPay
    {

        public static IAlixPay asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.alipay.android.app.IAlixPay");
            if (iinterface != null && (iinterface instanceof IAlixPay))
            {
                return (IAlixPay)iinterface;
            } else
            {
                return new Proxy(ibinder);
            }
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel1, int j)
            throws RemoteException
        {
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.alipay.android.app.IAlixPay");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                parcel = Pay(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                parcel = test();
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                registerCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                unregisterCallback(IRemoteServiceCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                parcel = prePay(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 6: // '\006'
                parcel.enforceInterface("com.alipay.android.app.IAlixPay");
                deployFastConnect();
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.alipay.android.app.IAlixPay");
        }
    }

    private static class Stub.Proxy
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract String Pay(String s)
        throws RemoteException;

    public abstract void deployFastConnect()
        throws RemoteException;

    public abstract String prePay(String s)
        throws RemoteException;

    public abstract void registerCallback(IRemoteServiceCallback iremoteservicecallback)
        throws RemoteException;

    public abstract String test()
        throws RemoteException;

    public abstract void unregisterCallback(IRemoteServiceCallback iremoteservicecallback)
        throws RemoteException;
}
