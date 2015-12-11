// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remote.api:
//            IRemoteService, IRemoteServiceListener

private static class mRemote
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

    A(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
