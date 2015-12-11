// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

// Referenced classes of package com.amazon.communication:
//            MessageEnvelope, ErrorCodeWithDataPointsEnvelope, IResponseHandler

public interface IConnection
    extends IInterface
{
    public static abstract class Stub extends Binder
        implements IConnection
    {

        static final int TRANSACTION_isValidConnection = 4;
        static final int TRANSACTION_release = 3;
        static final int TRANSACTION_sendMessage = 1;
        static final int TRANSACTION_sendReliableMessage = 5;
        static final int TRANSACTION_sendRequest = 2;

        public static IConnection asInterface(IBinder ibinder)
        {
            if (ibinder == null)
            {
                return null;
            }
            IInterface iinterface = ibinder.queryLocalInterface("com.amazon.communication.IConnection");
            if (iinterface != null && (iinterface instanceof IConnection))
            {
                return (IConnection)iinterface;
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
            boolean flag = false;
            switch (i)
            {
            default:
                return super.onTransact(i, parcel, parcel1, j);

            case 1598968902: 
                parcel1.writeString("com.amazon.communication.IConnection");
                return true;

            case 1: // '\001'
                parcel.enforceInterface("com.amazon.communication.IConnection");
                MessageEnvelope messageenvelope;
                if (parcel.readInt() != 0)
                {
                    messageenvelope = (MessageEnvelope)MessageEnvelope.CREATOR.createFromParcel(parcel);
                } else
                {
                    messageenvelope = null;
                }
                parcel = sendMessage(messageenvelope, parcel.readInt());
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 2: // '\002'
                parcel.enforceInterface("com.amazon.communication.IConnection");
                MessageEnvelope messageenvelope1;
                if (parcel.readInt() != 0)
                {
                    messageenvelope1 = (MessageEnvelope)MessageEnvelope.CREATOR.createFromParcel(parcel);
                } else
                {
                    messageenvelope1 = null;
                }
                parcel = sendRequest(messageenvelope1, IResponseHandler.Stub.asInterface(parcel.readStrongBinder()));
                parcel1.writeNoException();
                if (parcel != null)
                {
                    parcel1.writeInt(1);
                    parcel.writeToParcel(parcel1, 1);
                    return true;
                } else
                {
                    parcel1.writeInt(0);
                    return true;
                }

            case 3: // '\003'
                parcel.enforceInterface("com.amazon.communication.IConnection");
                release();
                parcel1.writeNoException();
                return true;

            case 4: // '\004'
                parcel.enforceInterface("com.amazon.communication.IConnection");
                boolean flag1 = isValidConnection();
                parcel1.writeNoException();
                i = ((flag) ? 1 : 0);
                if (flag1)
                {
                    i = 1;
                }
                parcel1.writeInt(i);
                return true;

            case 5: // '\005'
                parcel.enforceInterface("com.amazon.communication.IConnection");
                break;
            }
            MessageEnvelope messageenvelope2;
            if (parcel.readInt() != 0)
            {
                messageenvelope2 = (MessageEnvelope)MessageEnvelope.CREATOR.createFromParcel(parcel);
            } else
            {
                messageenvelope2 = null;
            }
            parcel = sendReliableMessage(messageenvelope2, parcel.readInt(), parcel.readInt());
            parcel1.writeNoException();
            if (parcel != null)
            {
                parcel1.writeInt(1);
                parcel.writeToParcel(parcel1, 1);
                return true;
            } else
            {
                parcel1.writeInt(0);
                return true;
            }
        }

        public Stub()
        {
            attachInterface(this, "com.amazon.communication.IConnection");
        }
    }

    private static class Stub.Proxy
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
            messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.createFromParcel(parcel1);
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
            messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.createFromParcel(parcel1);
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
            messageenvelope = (ErrorCodeWithDataPointsEnvelope)ErrorCodeWithDataPointsEnvelope.CREATOR.createFromParcel(parcel1);
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

        Stub.Proxy(IBinder ibinder)
        {
            mRemote = ibinder;
        }
    }


    public abstract boolean isValidConnection()
        throws RemoteException;

    public abstract void release()
        throws RemoteException;

    public abstract ErrorCodeWithDataPointsEnvelope sendMessage(MessageEnvelope messageenvelope, int i)
        throws RemoteException;

    public abstract ErrorCodeWithDataPointsEnvelope sendReliableMessage(MessageEnvelope messageenvelope, int i, int j)
        throws RemoteException;

    public abstract ErrorCodeWithDataPointsEnvelope sendRequest(MessageEnvelope messageenvelope, IResponseHandler iresponsehandler)
        throws RemoteException;
}
