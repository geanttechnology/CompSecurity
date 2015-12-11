// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.alipay.android.app;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface IRemoteServiceCallback
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IRemoteServiceCallback
    {

        public static IRemoteServiceCallback asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.alipay.android.app.IRemoteServiceCallback");
            if (iinterface != null && (iinterface instanceof IRemoteServiceCallback))
            {
                return (IRemoteServiceCallback)iinterface;
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
            boolean flag = false;
            boolean flag1 = false;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.alipay.android.app.IRemoteServiceCallback");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                String s = parcel.readString();
                String s1 = parcel.readString();
                i = parcel.readInt();
                if (parcel.readInt() != 0)
                {
                    parcel = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
                } else
                {
                    parcel = null;
                }
                startActivity(s, s1, i, parcel);
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                if (parcel.readInt() != 0)
                {
                    flag1 = true;
                }
                payEnd(flag1, parcel.readString());
                parcel1.writeNoException();
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.alipay.android.app.IRemoteServiceCallback");
                flag1 = isHideLoadingScreen();
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                break;
            }
            if (flag1)
            {
                i = 1;
            }
            parcel1.writeInt(i);
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.alipay.android.app.IRemoteServiceCallback");
        }
    }

    private static class Stub.Proxy
        implements IRemoteServiceCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public boolean isHideLoadingScreen()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
            mRemote.transact(3, parcel, parcel1, 0);
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

        public void payEnd(boolean flag, String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            int i;
            i = 0;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
            if (flag)
            {
                i = 1;
            }
            parcel.writeInt(i);
            parcel.writeString(s);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void startActivity(String s, String s1, int i, Bundle bundle)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.alipay.android.app.IRemoteServiceCallback");
            parcel.writeString(s);
            parcel.writeString(s1);
            parcel.writeInt(i);
            if (bundle == null)
            {
                break MISSING_BLOCK_LABEL_86;
            }
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L1:
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            parcel.writeInt(0);
              goto _L1
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract boolean isHideLoadingScreen()
        throws RemoteException;

    public abstract void payEnd(boolean flag, String s)
        throws RemoteException;

    public abstract void startActivity(String s, String s1, int i, Bundle bundle)
        throws RemoteException;
}
