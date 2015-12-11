// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.CommunicationBaseException;
import amazon.communication.Message;
import amazon.communication.identity.EndpointIdentity;
import com.amazon.communication.ProtocolException;
import com.dp.framework.StreamCodec;

// Referenced classes of package com.amazon.communication.rmr:
//            RmrProtocolHandler, RmrMessageRouter

public class DeviceRmrProtocolHandler extends RmrProtocolHandler
{

    private final RmrMessageRouter mRmrMessageRouter;

    public DeviceRmrProtocolHandler(RmrMessageRouter rmrmessagerouter, StreamCodec streamcodec)
    {
        super(streamcodec);
        mRmrMessageRouter = rmrmessagerouter;
    }

    protected void handleRmrMessage(EndpointIdentity endpointidentity, String s, int i, Message message, int j)
        throws CommunicationBaseException
    {
        if (s.equals("RQS"))
        {
            throw new ProtocolException("Unexpected RMR request on the device");
        } else
        {
            mRmrMessageRouter.routeRmrMessage(endpointidentity, s, i, message, j);
            return;
        }
    }
}
