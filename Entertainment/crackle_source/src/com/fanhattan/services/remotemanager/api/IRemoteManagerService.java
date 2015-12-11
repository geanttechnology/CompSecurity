// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remotemanager.api;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remotemanager.api:
//            IRemoteManagerCallback

public interface IRemoteManagerService
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IRemoteManagerService
    {

        private static final String DESCRIPTOR = "com.fanhattan.services.remotemanager.api.IRemoteManagerService";
        static final int TRANSACTION_registerCallback = 1;

        public static IRemoteManagerService asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.fanhattan.services.remotemanager.api.IRemoteManagerService");
            if (iinterface != null && (iinterface instanceof IRemoteManagerService))
            {
                return (IRemoteManagerService)iinterface;
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
                parcel1.writeString("com.fanhattan.services.remotemanager.api.IRemoteManagerService");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.fanhattan.services.remotemanager.api.IRemoteManagerService");
                registerCallback(parcel.readInt(), IRemoteManagerCallback.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.fanhattan.services.remotemanager.api.IRemoteManagerService");
        }
    }

    private static class Stub.Proxy
        implements IRemoteManagerService
    {

        private IBinder mRemote;

        public IBinder asBinder()
        {
            return mRemote;
        }

        public String getInterfaceDescriptor()
        {
            return "com.fanhattan.services.remotemanager.api.IRemoteManagerService";
        }

        public void registerCallback(int i, IRemoteManagerCallback iremotemanagercallback)
            throws RemoteException
        {
            Parcel parcel;
            Parcel parcel1;
            parcel = Parcel.obtain();
            parcel1 = Parcel.obtain();
            parcel.writeInterfaceToken("com.fanhattan.services.remotemanager.api.IRemoteManagerService");
            parcel.writeInt(i);
            if (iremotemanagercallback == null)
            {
                break MISSING_BLOCK_LABEL_66;
            }
            iremotemanagercallback = iremotemanagercallback.asBinder();
_L1:
            parcel.writeStrongBinder(iremotemanagercallback);
            mRemote.transact(1, parcel, parcel1, 0);
            parcel1.readException();
            parcel1.recycle();
            parcel.recycle();
            return;
            iremotemanagercallback = null;
              goto _L1
            iremotemanagercallback;
            parcel1.recycle();
            parcel.recycle();
            throw iremotemanagercallback;
        }

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract void registerCallback(int i, IRemoteManagerCallback iremotemanagercallback)
        throws RemoteException;
}
