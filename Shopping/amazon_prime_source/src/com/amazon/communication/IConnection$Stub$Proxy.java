// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            IConnection, MessageEnvelope, ErrorCodeWithDataPointsEnvelope, IResponseHandler

private static class mRemote
    implements IConnection
{

    private IBinder mRemote;

    public IBinder asBinder()
    {
        return mRemote;
    }

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.IConnection";
    }

    public boolean isValidConnection()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.IConnection");
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        if (i != 0)
        {
            flag = true;
        }
        parcel1.recycle();
        parcel.recycle();
        return flag;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public void release()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IConnection");
        mRemote.transact(3, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public ErrorCodeWithDataPointsEnvelope sendMessage(MessageEnvelope messageenvelope, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IConnection");
        if (messageenvelope == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L3:
        parcel.writeInt(i);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_108;
        }
        messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.teFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return messageenvelope;
_L2:
        parcel.writeInt(0);
          goto _L3
        messageenvelope;
        parcel1.recycle();
        parcel.recycle();
        throw messageenvelope;
        messageenvelope = null;
          goto _L4
    }

    public ErrorCodeWithDataPointsEnvelope sendReliableMessage(MessageEnvelope messageenvelope, int i, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IConnection");
        if (messageenvelope == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L3:
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_123;
        }
        messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.teFromParcel(parcel1);
_L4:
        parcel1.recycle();
        parcel.recycle();
        return messageenvelope;
_L2:
        parcel.writeInt(0);
          goto _L3
        messageenvelope;
        parcel1.recycle();
        parcel.recycle();
        throw messageenvelope;
        messageenvelope = null;
          goto _L4
    }

    public ErrorCodeWithDataPointsEnvelope sendRequest(MessageEnvelope messageenvelope, IResponseHandler iresponsehandler)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.IConnection");
        if (messageenvelope == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L5:
        if (iresponsehandler == null) goto _L4; else goto _L3
_L3:
        messageenvelope = iresponsehandler.asBinder();
_L6:
        parcel.writeStrongBinder(messageenvelope);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        if (parcel1.readInt() == 0)
        {
            break MISSING_BLOCK_LABEL_124;
        }
        messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.teFromParcel(parcel1);
_L7:
        parcel1.recycle();
        parcel.recycle();
        return messageenvelope;
_L2:
        parcel.writeInt(0);
          goto _L5
        messageenvelope;
        parcel1.recycle();
        parcel.recycle();
        throw messageenvelope;
_L4:
        messageenvelope = null;
          goto _L6
        messageenvelope = null;
          goto _L7
    }

    Envelope(IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
