// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.time.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

public interface ITimeService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements ITimeService
    {

        private static final String DESCRIPTOR = "com.fanhattan.services.time.api.ITimeService";
        static final int TRANSACTION_getTimeZone = 2;
        static final int TRANSACTION_isAutoTimeZone = 4;
        static final int TRANSACTION_setAutoTimeZone = 3;
        static final int TRANSACTION_setTimeZone = 1;

        public static ITimeService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.time.api.ITimeService");
            if (iinterface != null && (iinterface instanceof ITimeService))
            {
                return (ITimeService)iinterface;
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
            boolean flag;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.fanhattan.services.time.api.ITimeService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.fanhattan.services.time.api.ITimeService");
                setTimeZone(parcel.readString(), parcel.readString());
                parcel1.writeNoException();
                return true;

            case 2: // '\002'
                parcel.enforceInterface("com.fanhattan.services.time.api.ITimeService");
                parcel = getTimeZone(parcel.readString());
                parcel1.writeNoException();
                parcel1.writeString(parcel);
                return true;

            case 3: // '\003'
                parcel.enforceInterface("com.fanhattan.services.time.api.ITimeService");
                setAutoTimeZone(parcel.readString());
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.fanhattan.services.time.api.ITimeService");
                flag = isAutoTimeZone();
                parcel1.writeNoException();
                break;
            }
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.fanhattan.services.time.api.ITimeService");
        }
    }

    private static class Stub.Proxy
        implements ITimeService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.time.api.ITimeService";
        }

        public String getTimeZone(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.time.api.ITimeService");
            parcel.writeString(s);
            mRemote.transact(2, parcel, parcel1, 0);
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

        public boolean isAutoTimeZone()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.fanhattan.services.time.api.ITimeService");
            mRemote.transact(4, parcel, parcel1, 0);
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

        public void setAutoTimeZone(String s)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.time.api.ITimeService");
            parcel.writeString(s);
            mRemote.transact(3, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
        }

        public void setTimeZone(String s, String s1)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.time.api.ITimeService");
            parcel.writeString(s);
            parcel.writeString(s1);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
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


    public abstract String getTimeZone(String s)
        throws RemoteException;

    public abstract boolean isAutoTimeZone()
        throws RemoteException;

    public abstract void setAutoTimeZone(String s)
        throws RemoteException;

    public abstract void setTimeZone(String s, String s1)
        throws RemoteException;
}
