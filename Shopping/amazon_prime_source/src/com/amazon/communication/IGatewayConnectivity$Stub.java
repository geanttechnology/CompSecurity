// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IGatewayConnectivity

public static abstract class attachInterface extends Binder
    implements IGatewayConnectivity
{
    private static class Proxy
        implements IGatewayConnectivity
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public int getGatewayConnectionState()
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            int i;
            parcel.writeInterfaceToken("com.amazon.communication.IGatewayConnectivity");
            mRemote.transact(1, parcel, parcel1, 0);
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

        public String getInterfaceDescriptor()
        {
            return "com.amazon.communication.IGatewayConnectivity";
        }

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_getGatewayConnectionState = 1;

    public static IGatewayConnectivity asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IGatewayConnectivity");
        if (iinterface != null && (iinterface instanceof IGatewayConnectivity))
        {
            return (IGatewayConnectivity)iinterface;
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
            parcel1.writeString("com.amazon.communication.IGatewayConnectivity");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.communication.IGatewayConnectivity");
            i = getGatewayConnectionState();
            parcel1.writeNoException();
            parcel1.writeInt(i);
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.communication.IGatewayConnectivity");
    }
}
