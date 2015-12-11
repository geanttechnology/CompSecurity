// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remote.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remote.api:
//            IRemoteServiceListener

private static class mRemote
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

    I(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
