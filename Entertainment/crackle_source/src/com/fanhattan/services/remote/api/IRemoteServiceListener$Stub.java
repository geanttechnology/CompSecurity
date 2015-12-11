// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remote.api:
//            IRemoteServiceListener

public static abstract class attachInterface extends Binder
    implements IRemoteServiceListener
{
    private static class Proxy
        implements IRemoteServiceListener
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.remote.api.IRemoteServiceListener";
        }

        public void onBatteryLevelChanged(int i, int j)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteServiceListener");
            parcel.writeInt(i);
            parcel.writeInt(j);
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

        public void onConnected(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteServiceListener");
            parcel.writeInt(i);
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

        public void onDisconnected(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteServiceListener");
            parcel.writeInt(i);
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

        public void onEnvironmentReport(int i, int j, int k, int l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteServiceListener");
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeInt(k);
            parcel.writeInt(l);
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

        public boolean onTouchEvent(int i, int j, float f, float f1, float f2, float f3, int k, 
                long l)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteServiceListener");
            parcel.writeInt(i);
            parcel.writeInt(j);
            parcel.writeFloat(f);
            parcel.writeFloat(f1);
            parcel.writeFloat(f2);
            parcel.writeFloat(f3);
            parcel.writeInt(k);
            parcel.writeLong(l);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            boolean flag;
            if (i != 0)
            {
                flag = true;
            } else
            {
                flag = false;
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.fanhattan.services.remote.api.IRemoteServiceListener";
    static final int TRANSACTION_onBatteryLevelChanged = 3;
    static final int TRANSACTION_onConnected = 5;
    static final int TRANSACTION_onDisconnected = 4;
    static final int TRANSACTION_onEnvironmentReport = 2;
    static final int TRANSACTION_onTouchEvent = 1;

    public static IRemoteServiceListener asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
        if (iinterface != null && (iinterface instanceof IRemoteServiceListener))
        {
            return (IRemoteServiceListener)iinterface;
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
            parcel1.writeString("com.fanhattan.services.remote.api.IRemoteServiceListener");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
            boolean flag = onTouchEvent(parcel.readInt(), parcel.readInt(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readFloat(), parcel.readInt(), parcel.readLong());
            parcel1.writeNoException();
            if (flag)
            {
                i = 1;
            } else
            {
                i = 0;
            }
            parcel1.writeInt(i);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
            onEnvironmentReport(parcel.readInt(), parcel.readInt(), parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
            onBatteryLevelChanged(parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 4: // '\004'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
            onDisconnected(parcel.readInt());
            parcel1.writeNoException();
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteServiceListener");
            onConnected(parcel.readInt());
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.fanhattan.services.remote.api.IRemoteServiceListener");
    }
}
