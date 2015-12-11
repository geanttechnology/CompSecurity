// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remotemanager.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remotemanager.api:
//            IRemoteManagerCallback

public static abstract class attachInterface extends Binder
    implements IRemoteManagerCallback
{
    private static class Proxy
        implements IRemoteManagerCallback
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.remotemanager.api.IRemoteManagerCallback";
        }

        public void onRemoteEvent(byte abyte0[])
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remotemanager.api.IRemoteManagerCallback");
            parcel.writeByteArray(abyte0);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            abyte0;
            parcel1.recycle();
            parcel.recycle();
            throw abyte0;
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    private static final String DESCRIPTOR = "com.fanhattan.services.remotemanager.api.IRemoteManagerCallback";
    static final int TRANSACTION_onRemoteEvent = 1;

    public static IRemoteManagerCallback asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.remotemanager.api.IRemoteManagerCallback");
        if (iinterface != null && (iinterface instanceof IRemoteManagerCallback))
        {
            return (IRemoteManagerCallback)iinterface;
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
            parcel1.writeString("com.fanhattan.services.remotemanager.api.IRemoteManagerCallback");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.fanhattan.services.remotemanager.api.IRemoteManagerCallback");
            onRemoteEvent(parcel.createByteArray());
            parcel1.writeNoException();
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.fanhattan.services.remotemanager.api.IRemoteManagerCallback");
    }
}
