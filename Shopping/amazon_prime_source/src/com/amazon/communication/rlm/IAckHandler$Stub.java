// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rlm;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication.rlm:
//            IAckHandler

public static abstract class attachInterface extends Binder
    implements IAckHandler
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_onAck = 1;
    static final int TRANSACTION_onNack = 2;
    static final int TRANSACTION_onPack = 3;

    public static IAckHandler asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.rlm.IAckHandler");
        if (iinterface != null && (iinterface instanceof IAckHandler))
        {
            return (IAckHandler)iinterface;
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
            parcel1.writeString("com.amazon.communication.rlm.IAckHandler");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.communication.rlm.IAckHandler");
            onAck(parcel.readInt());
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.communication.rlm.IAckHandler");
            onNack(parcel.readInt(), parcel.readInt(), parcel.readString());
            return true;

        case 3: // '\003'
            parcel.enforceInterface("com.amazon.communication.rlm.IAckHandler");
            onPack(parcel.readInt(), parcel.readInt(), parcel.readString());
            return true;
        }
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.communication.rlm.IAckHandler");
    }
}
