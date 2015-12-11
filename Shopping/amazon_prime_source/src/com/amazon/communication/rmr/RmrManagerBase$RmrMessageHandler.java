// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.CommunicationBaseException;
import amazon.communication.Message;
import amazon.communication.MessageHandler;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.dp.logger.DPLogger;

// Referenced classes of package com.amazon.communication.rmr:
//            RmrManagerBase, RmrProtocolHandler

private class <init>
    implements MessageHandler
{

    final RmrManagerBase this$0;

    public void onMessage(EndpointIdentity endpointidentity, Message message)
    {
        try
        {
            RmrManagerBase.access$100(RmrManagerBase.this).decodeMessage(endpointidentity, message);
            return;
        }
        // Misplaced declaration of an exception variable
        catch (EndpointIdentity endpointidentity)
        {
            RmrManagerBase.access$000().warn("RmrMessageHandler.onMessage", "error occurred handling RMR message", new Object[] {
                endpointidentity
            });
        }
    }

    public void onMessageFragment(EndpointIdentity endpointidentity, int i, Message message, boolean flag)
    {
        throw new UnsupportedOperationException("No fragmentation support in RMR yet");
    }

    private ()
    {
        this$0 = RmrManagerBase.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
