// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            IRemoteCallback

public interface IGenericIPC
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IGenericIPC
    {

        static final int TRANSACTION_call = 1;

        public static IGenericIPC asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.identity.auth.device.callback.IGenericIPC");
            if (iinterface != null && (iinterface instanceof IGenericIPC))
            {
                return (IGenericIPC)iinterface;
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
            String s;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.identity.auth.device.callback.IGenericIPC");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.identity.auth.device.callback.IGenericIPC");
                s = parcel.readString();
                break;
            }
            Bundle bundle;
            if (parcel.readInt() != 0)
            {
                bundle = (Bundle)Bundle.CREATOR.createFromParcel(parcel);
            } else
            {
                bundle = null;
            }
            call(s, bundle, IRemoteCallback.Stub.asInterface(parcel.readStrongBinder()));
            parcel1.writeNoException();
            return true;
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.identity.auth.device.callback.IGenericIPC");
        }
    }

    private static class Stub.Proxy
        implements IGenericIPC
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public void call(String s, Bundle bundle, IRemoteCallback iremotecallback)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.amazon.identity.auth.device.callback.IGenericIPC");
            parcel.writeString(s);
            if (bundle == null) goto _L2; else goto _L1
_L1:
            parcel.writeInt(1);
            bundle.writeToParcel(parcel, 0);
_L3:
            if (iremotecallback == null)
            {
                break MISSING_BLOCK_LABEL_111;
            }
            s = iremotecallback.asBinder();
_L4:
            parcel.writeStrongBinder(s);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
_L2:
            parcel.writeInt(0);
              goto _L3
            s;
            parcel1.recycle();
            parcel.recycle();
            throw s;
            s = null;
              goto _L4
        }

        public String getInterfaceDescriptor()
        {
            return "com.amazon.identity.auth.device.callback.IGenericIPC";
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void call(String s, Bundle bundle, IRemoteCallback iremotecallback)
        throws RemoteException;
}
