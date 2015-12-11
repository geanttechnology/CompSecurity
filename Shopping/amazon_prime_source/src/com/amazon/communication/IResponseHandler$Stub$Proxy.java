// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            IResponseHandler, MessageEnvelope

private static class mRemote
    implements IResponseHandler
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.IResponseHandler";
    }

    public void onResponse(MessageEnvelope messageenvelope, List list)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IResponseHandler");
        if (messageenvelope == null)
        {
            break MISSING_BLOCK_LABEL_65;
        }
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L1:
        parcel.writeTypedList(list);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        parcel.writeInt(0);
          goto _L1
        messageenvelope;
        parcel1.recycle();
        parcel.recycle();
        throw messageenvelope;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
