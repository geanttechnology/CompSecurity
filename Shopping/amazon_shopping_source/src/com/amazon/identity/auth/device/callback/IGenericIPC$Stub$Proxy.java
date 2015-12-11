// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.auth.device.callback;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.identity.auth.device.callback:
//            IGenericIPC, IRemoteCallback

private static class mRemote
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

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
