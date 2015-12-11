// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Binder;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.client.metrics.DataPointEnvelope;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            IResponseHandler, MessageEnvelope

public static abstract class attachInterface extends Binder
    implements IResponseHandler
{
    private static class Proxy
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

        Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    static final int TRANSACTION_onResponse = 1;

    public static IResponseHandler asInterface(IBinder ibinder)
    {
        if (ibinder == null)
        {
            return null;
        }
        android.os.IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IResponseHandler");
        if (iinterface != null && (iinterface instanceof IResponseHandler))
        {
            return (IResponseHandler)iinterface;
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
            parcel1.writeString("com.amazon.communication.IResponseHandler");
            return true;

        case 1: // '\001'
            parcel.enforceInterface("com.amazon.communication.IResponseHandler");
            break;
        }
        MessageEnvelope messageenvelope;
        if (parcel.readInt() != 0)
        {
            messageenvelope = (MessageEnvelope)MessageEnvelope.CREATOR.ateFromParcel(parcel);
        } else
        {
            messageenvelope = null;
        }
        onResponse(messageenvelope, parcel.createTypedArrayList(DataPointEnvelope.CREATOR));
        parcel1.writeNoException();
        return true;
    }

    public Proxy.mRemote()
    {
        attachInterface(this, "com.amazon.communication.IResponseHandler");
    }
}
