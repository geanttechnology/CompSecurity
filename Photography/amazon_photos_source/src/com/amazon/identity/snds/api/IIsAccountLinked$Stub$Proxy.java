// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.identity.snds.api;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.identity.snds.api:
//            IIsAccountLinked, ReturnValueOrError

private static class mRemote
    implements IIsAccountLinked
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public ReturnValueOrError isAccountLinked(String s, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.identity.snds.api.IIsAccountLinked");
        parcel.writeString(s);
        parcel.writeInt(i);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0) goto _L2; else goto _L1
_L1:
        s = (ReturnValueOrError)ReturnValueOrError.CREATOR.mParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return s;
_L2:
        s = null;
        if (true) goto _L4; else goto _L3
_L3:
        s;
        parcel1.recycle();
        parcel.recycle();
        throw s;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
