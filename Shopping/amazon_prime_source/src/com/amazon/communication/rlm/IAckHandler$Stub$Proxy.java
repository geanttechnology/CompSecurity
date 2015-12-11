// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rlm;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication.rlm:
//            IAckHandler

private static class mRemote
    implements IAckHandler
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.rlm.IAckHandler";
    }

    public void onAck(int i)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.rlm.IAckHandler");
        parcel.writeInt(i);
        mRemote.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel.recycle();
        throw exception;
    }

    public void onNack(int i, int j, String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.rlm.IAckHandler");
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        mRemote.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    public void onPack(int i, int j, String s)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.rlm.IAckHandler");
        parcel.writeInt(i);
        parcel.writeInt(j);
        parcel.writeString(s);
        mRemote.transact(3, parcel, null, 1);
        parcel.recycle();
        return;
        s;
        parcel.recycle();
        throw s;
    }

    _cls9(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
