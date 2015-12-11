// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.fanhattan.services.remotemanager.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.fanhattan.services.remotemanager.api:
//            IRemoteManagerService, IRemoteManagerCallback

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
