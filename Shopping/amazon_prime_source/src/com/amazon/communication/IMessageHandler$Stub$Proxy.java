// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IMessageHandler, ParcelableEndpointIdentity, MessageEnvelope

private static class mRemote
    implements IMessageHandler
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.IMessageHandler";
    }

    public void onMessage(ParcelableEndpointIdentity parcelableendpointidentity, MessageEnvelope messageenvelope)
        throws RemoteException
    {
        Parcel parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IMessageHandler");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L3:
        if (messageenvelope == null)
        {
            break MISSING_BLOCK_LABEL_74;
        }
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L4:
        mRemote.transact(1, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        parcelableendpointidentity;
        parcel.recycle();
        throw parcelableendpointidentity;
        parcel.writeInt(0);
          goto _L4
    }

    public void onMessageFragment(ParcelableEndpointIdentity parcelableendpointidentity, MessageEnvelope messageenvelope, int i, boolean flag)
        throws RemoteException
    {
        Parcel parcel;
        boolean flag1;
        flag1 = true;
        parcel = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IMessageHandler");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L3:
        if (messageenvelope == null)
        {
            break MISSING_BLOCK_LABEL_107;
        }
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L4:
        parcel.writeInt(i);
        if (flag)
        {
            i = ((flag1) ? 1 : 0);
        } else
        {
            i = 0;
        }
        parcel.writeInt(i);
        mRemote.transact(2, parcel, null, 1);
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        parcelableendpointidentity;
        parcel.recycle();
        throw parcelableendpointidentity;
        parcel.writeInt(0);
          goto _L4
    }

    _cls9(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
