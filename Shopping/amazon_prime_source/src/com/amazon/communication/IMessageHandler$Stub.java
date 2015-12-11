// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IMessageHandler, ParcelableEndpointIdentity, MessageEnvelope

public static abstract class attachInterface extends Binder
    implements IMessageHandler
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_onMessage = 1;
    static final int TRANSACTION_onMessageFragment = 2;

    public static IMessageHandler asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IMessageHandler");
        if (iinterface != null && (iinterface instanceof IMessageHandler))
        {
            return (IMessageHandler)iinterface;
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
            parcel1.writeString("com.amazon.communication.IMessageHandler");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.communication.IMessageHandler");
            if (parcel.readInt() != 0)
            {
                parcel1 = (ParcelableEndpointIdentity)ParcelableEndpointIdentity.CREATOR.eateFromParcel(parcel);
            } else
            {
                parcel1 = null;
            }
            if (parcel.readInt() != 0)
            {
                parcel = (MessageEnvelope)MessageEnvelope.CREATOR.eateFromParcel(parcel);
            } else
            {
                parcel = null;
            }
            onMessage(parcel1, parcel);
            return true;

        case 2: // '\002'
            parcel.enforceInterface("com.amazon.communication.IMessageHandler");
            break;
        }
        MessageEnvelope messageenvelope;
        boolean flag;
        if (parcel.readInt() != 0)
        {
            parcel1 = (ParcelableEndpointIdentity)ParcelableEndpointIdentity.CREATOR.eateFromParcel(parcel);
        } else
        {
            parcel1 = null;
        }
        if (parcel.readInt() != 0)
        {
            messageenvelope = (MessageEnvelope)MessageEnvelope.CREATOR.eateFromParcel(parcel);
        } else
        {
            messageenvelope = null;
        }
        i = parcel.readInt();
        if (parcel.readInt() != 0)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        onMessageFragment(parcel1, messageenvelope, i, flag);
        return true;
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.communication.IMessageHandler");
    }
}
