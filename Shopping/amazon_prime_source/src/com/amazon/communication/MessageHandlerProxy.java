// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.MessageHandler;
import amazon.communication.identity.EndpointIdentityFactory;
import android.os.RemoteException;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.communication:
//            ParcelableEndpointIdentity, MessageEnvelope

class MessageHandlerProxy extends IMessageHandler.Stub
{

    private static final DPLogger log = new DPLogger("TComm.MessageHandlerProxy");
    private final MessageHandler mMessageHandler;

    MessageHandlerProxy(MessageHandler messagehandler)
    {
        mMessageHandler = messagehandler;
    }

    public MessageHandler getClientHandler()
    {
        return mMessageHandler;
    }

    public void onMessage(ParcelableEndpointIdentity parcelableendpointidentity, MessageEnvelope messageenvelope)
        throws RemoteException
    {
        try
        {
            mMessageHandler.onMessage(EndpointIdentityFactory.createFromUrn(parcelableendpointidentity.toString()), messageenvelope.toMessage());
            return;
        }
        // Misplaced declaration of an exception variable
        catch (ParcelableEndpointIdentity parcelableendpointidentity)
        {
            log.warn("onMessage", "Exception occurred!", new Object[] {
                parcelableendpointidentity
            });
        }
        throw parcelableendpointidentity;
    }

    public void onMessageFragment(ParcelableEndpointIdentity parcelableendpointidentity, MessageEnvelope messageenvelope, int i, boolean flag)
        throws RemoteException
    {
        try
        {
            throw new UnsupportedOperationException("Message fragments not yet implemented");
        }
        // Misplaced declaration of an exception variable
        catch (ParcelableEndpointIdentity parcelableendpointidentity)
        {
            log.warn("onMessageFragment", "Exception occurred!", new Object[] {
                parcelableendpointidentity
            });
        }
        throw parcelableendpointidentity;
    }

}
