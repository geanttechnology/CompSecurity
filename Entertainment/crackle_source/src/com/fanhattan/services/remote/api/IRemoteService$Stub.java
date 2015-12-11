// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remote.api:
//            IRemoteService, IRemoteServiceListener

public static abstract class attachInterface extends Binder
    implements IRemoteService
{
    private static class Proxy
        implements IRemoteService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public int getBatteryLevel(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            parcel.writeInt(i);
            mRemote.transact(4, parcel, parcel1, 0);
            parcel1.readException();
            i = parcel1.readInt();
            parcel1.recycle();
            parcel.recycle();
            return i;
            Exception exception;
            exception;
            parcel1.recycle();
            parcel.recycle();
            throw exception;
        }

        public String getHardwareVersion(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            parcel.writeInt(i);
            mRemote.transact(7, parcel, parcel1, 0);
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

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.remote.api.IRemoteService";
        }

        public String getSoftwareBuild(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            parcel.writeInt(i);
            mRemote.transact(6, parcel, parcel1, 0);
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

        public String getSoftwareVersion(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            String s;
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            parcel.writeInt(i);
            mRemote.transact(5, parcel, parcel1, 0);
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

        public boolean isConnected(int i)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            boolean flag;
            flag = false;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            parcel.writeInt(i);
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

        public void registerListener(IRemoteServiceListener iremoteservicelistener)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            if (iremoteservicelistener == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            iremoteservicelistener = iremoteservicelistener.asBinder();
_L1:
            parcel.writeStrongBinder(iremoteservicelistener);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            iremoteservicelistener = null;
              goto _L1
            iremoteservicelistener;
            parcel1.recycle();
            parcel.recycle();
            throw iremoteservicelistener;
        }

        public void unregisterListener(IRemoteServiceListener iremoteservicelistener)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remote.api.IRemoteService");
            if (iremoteservicelistener == null)
            {
                break MISSING_BLOCK_LABEL_57;
            }
            iremoteservicelistener = iremoteservicelistener.asBinder();
_L1:
            parcel.writeStrongBinder(iremoteservicelistener);
            mRemote.transact(2, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            iremoteservicelistener = null;
              goto _L1
            iremoteservicelistener;
            parcel1.recycle();
            parcel.recycle();
            throw iremoteservicelistener;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.fanhattan.services.remote.api.IRemoteService";
    static final int TRANSACTION_getBatteryLevel = 4;
    static final int TRANSACTION_getHardwareVersion = 7;
    static final int TRANSACTION_getSoftwareBuild = 6;
    static final int TRANSACTION_getSoftwareVersion = 5;
    static final int TRANSACTION_isConnected = 3;
    static final int TRANSACTION_registerListener = 1;
    static final int TRANSACTION_unregisterListener = 2;

    public static IRemoteService asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.remote.api.IRemoteService");
        if (iinterface != null && (iinterface instanceof IRemoteService))
        {
            return (IRemoteService)iinterface;
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
            parcel1.writeString("com.fanhattan.services.remote.api.IRemoteService");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            registerListener(er.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            unregisterListener(er.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            boolean flag = isConnected(parcel.readInt());
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

        case 4: // '\004'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            i = getBatteryLevel(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;

        case 5: // '\005'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            parcel = getSoftwareVersion(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 6: // '\006'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            parcel = getSoftwareBuild(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;

        case 7: // '\007'
            parcel.enforceInterface("com.fanhattan.services.remote.api.IRemoteService");
            parcel = getHardwareVersion(parcel.readInt());
            parcel1.writeNoException();
            parcel1.writeString(parcel);
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.fanhattan.services.remote.api.IRemoteService");
    }
}
