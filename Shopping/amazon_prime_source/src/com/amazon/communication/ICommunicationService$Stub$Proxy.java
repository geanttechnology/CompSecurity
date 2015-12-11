// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.amazon.communication.ir.IIdentityResolver;
import com.amazon.communication.rlm.IAckHandler;

// Referenced classes of package com.amazon.communication:
//            ICommunicationService, ParcelableEndpointIdentity, ParcelableConnectionPolicy, IConnectionListener, 
//            ParcelableStatus, ParcelablePolicy, IMessageHandler, MessageEnvelope, 
//            IConnection, IGatewayConnectivity

private static class mRemote
    implements ICommunicationService
{

    private IBinder mRemote;

    public IConnection acquireConnection(ParcelableEndpointIdentity parcelableendpointidentity, ParcelableConnectionPolicy parcelableconnectionpolicy, IConnectionListener iconnectionlistener, ParcelableStatus parcelablestatus)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L5:
        if (parcelableconnectionpolicy == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        parcelableconnectionpolicy.writeToParcel(parcel, 0);
_L6:
        if (iconnectionlistener == null)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        parcelableendpointidentity = iconnectionlistener.asBinder();
_L7:
        parcel.writeStrongBinder(parcelableendpointidentity);
        mRemote.transact(1, parcel, parcel1, 0);
        parcel1.readException();
        parcelableendpointidentity = mRemote(parcel1.readStrongBinder());
        if (parcel1.readInt() != 0)
        {
            parcelablestatus.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return parcelableendpointidentity;
_L2:
        parcel.writeInt(0);
          goto _L5
        parcelableendpointidentity;
        parcel1.recycle();
        parcel.recycle();
        throw parcelableendpointidentity;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcelableendpointidentity = null;
          goto _L7
    }

    public IConnection acquireConnectionEx(ParcelableEndpointIdentity parcelableendpointidentity, ParcelablePolicy parcelablepolicy, IConnectionListener iconnectionlistener, ParcelableStatus parcelablestatus)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L5:
        if (parcelablepolicy == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        parcelablepolicy.writeToParcel(parcel, 0);
_L6:
        if (iconnectionlistener == null)
        {
            break MISSING_BLOCK_LABEL_157;
        }
        parcelableendpointidentity = iconnectionlistener.asBinder();
_L7:
        parcel.writeStrongBinder(parcelableendpointidentity);
        mRemote.transact(8, parcel, parcel1, 0);
        parcel1.readException();
        parcelableendpointidentity = mRemote(parcel1.readStrongBinder());
        if (parcel1.readInt() != 0)
        {
            parcelablestatus.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return parcelableendpointidentity;
_L2:
        parcel.writeInt(0);
          goto _L5
        parcelableendpointidentity;
        parcel1.recycle();
        parcel.recycle();
        throw parcelableendpointidentity;
_L4:
        parcel.writeInt(0);
          goto _L6
        parcelableendpointidentity = null;
          goto _L7
    }

    public IBinder asBinder()
    {
        return mRemote;
    }

    public void deregisterMessageHandler(int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        parcel.writeInt(i);
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

    public IGatewayConnectivity getGatewayConnectivity(IConnectionListener iconnectionlistener, ParcelableStatus parcelablestatus)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (iconnectionlistener == null)
        {
            break MISSING_BLOCK_LABEL_86;
        }
        iconnectionlistener = iconnectionlistener.asBinder();
_L1:
        parcel.writeStrongBinder(iconnectionlistener);
        mRemote.transact(9, parcel, parcel1, 0);
        parcel1.readException();
        iconnectionlistener = face(parcel1.readStrongBinder());
        if (parcel1.readInt() != 0)
        {
            parcelablestatus.readFromParcel(parcel1);
        }
        parcel1.recycle();
        parcel.recycle();
        return iconnectionlistener;
        iconnectionlistener = null;
          goto _L1
        iconnectionlistener;
        parcel1.recycle();
        parcel.recycle();
        throw iconnectionlistener;
    }

    public IIdentityResolver getIdentityResolver()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        IIdentityResolver iidentityresolver;
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        mRemote.transact(6, parcel, parcel1, 0);
        parcel1.readException();
        iidentityresolver = com.amazon.communication.ir.e(parcel1.readStrongBinder());
        parcel1.recycle();
        parcel.recycle();
        return iidentityresolver;
        Exception exception;
        exception;
        parcel1.recycle();
        parcel.recycle();
        throw exception;
    }

    public String getInterfaceDescriptor()
    {
        return "com.amazon.communication.ICommunicationService";
    }

    public boolean isInitialized()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag;
        flag = false;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        int i;
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        mRemote.transact(7, parcel, parcel1, 0);
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

    public int registerMessageHandler(int i, IMessageHandler imessagehandler)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        parcel.writeInt(i);
        if (imessagehandler == null)
        {
            break MISSING_BLOCK_LABEL_73;
        }
        imessagehandler = imessagehandler.asBinder();
_L1:
        parcel.writeStrongBinder(imessagehandler);
        mRemote.transact(2, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        imessagehandler = null;
          goto _L1
        imessagehandler;
        parcel1.recycle();
        parcel.recycle();
        throw imessagehandler;
    }

    public void removeAckHandler()
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        mRemote.transact(11, parcel, parcel1, 0);
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

    public void routeMessage(ParcelableEndpointIdentity parcelableendpointidentity, MessageEnvelope messageenvelope, int i)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L3:
        if (messageenvelope == null)
        {
            break MISSING_BLOCK_LABEL_111;
        }
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
_L4:
        parcel.writeInt(i);
        mRemote.transact(4, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L3
        parcelableendpointidentity;
        parcel1.recycle();
        parcel.recycle();
        throw parcelableendpointidentity;
        parcel.writeInt(0);
          goto _L4
    }

    public void routeMessageFragment(ParcelableEndpointIdentity parcelableendpointidentity, int i, MessageEnvelope messageenvelope, boolean flag, int j)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        boolean flag1;
        flag1 = true;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (parcelableendpointidentity == null) goto _L2; else goto _L1
_L1:
        parcel.writeInt(1);
        parcelableendpointidentity.writeToParcel(parcel, 0);
_L6:
        parcel.writeInt(i);
        if (messageenvelope == null) goto _L4; else goto _L3
_L3:
        parcel.writeInt(1);
        messageenvelope.writeToParcel(parcel, 0);
          goto _L5
_L7:
        parcel.writeInt(i);
        parcel.writeInt(j);
        mRemote.transact(5, parcel, parcel1, 0);
        parcel1.readException();
        parcel1.recycle();
        parcel.recycle();
        return;
_L2:
        parcel.writeInt(0);
          goto _L6
        parcelableendpointidentity;
        parcel1.recycle();
        parcel.recycle();
        throw parcelableendpointidentity;
_L4:
        parcel.writeInt(0);
          goto _L5
_L9:
        i = 0;
          goto _L7
_L5:
        if (!flag) goto _L9; else goto _L8
_L8:
        i = ((flag1) ? 1 : 0);
          goto _L7
    }

    public int setAckHandler(IAckHandler iackhandler)
        throws RemoteException
    {
        Parcel parcel;
        Parcel parcel1;
        parcel = Parcel.obtain();
        parcel1 = Parcel.obtain();
        parcel.writeInterfaceToken("com.amazon.communication.ICommunicationService");
        if (iackhandler == null)
        {
            break MISSING_BLOCK_LABEL_66;
        }
        iackhandler = iackhandler.asBinder();
_L1:
        int i;
        parcel.writeStrongBinder(iackhandler);
        mRemote.transact(10, parcel, parcel1, 0);
        parcel1.readException();
        i = parcel1.readInt();
        parcel1.recycle();
        parcel.recycle();
        return i;
        iackhandler = null;
          goto _L1
        iackhandler;
        parcel1.recycle();
        parcel.recycle();
        throw iackhandler;
    }

    (IBinder ibinder)
    {
        mRemote = ibinder;
    }
}
