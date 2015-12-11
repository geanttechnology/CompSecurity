// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services;

import com.amazon.rio.j2me.client.rsc.ClientRequestReply;
import com.amazon.rio.j2me.client.rsc.ServiceCall;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.amazon.rio.j2me.client.services:
//            ServiceCallImpl, ResponseListener, RioEventListener

public abstract class BaseClientRequestReply
    implements ClientRequestReply
{

    protected final ServiceCallImpl serviceCall;

    protected BaseClientRequestReply(ServiceCallImpl servicecallimpl)
    {
        serviceCall = servicecallimpl;
    }

    public void cancelled(ServiceCall servicecall)
    {
        serviceCall.setUnderlyingCall(servicecall);
        getCallback().cancelled(serviceCall);
    }

    public void communicationError(Exception exception, ServiceCall servicecall)
    {
        serviceCall.setUnderlyingCall(servicecall);
        servicecall = serviceCall.getEventListener();
        if (servicecall != null)
        {
            servicecall.connectionFailed(serviceCall);
        }
        getCallback().error(exception, serviceCall);
    }

    public void consumeReply(InputStream inputstream, ServiceCall servicecall)
        throws IOException
    {
        serviceCall.setUnderlyingCall(servicecall);
        inputstream = serviceCall.getEventListener();
        if (inputstream != null)
        {
            inputstream.connectionSucceeded(serviceCall);
        }
    }

    protected abstract ResponseListener getCallback();

    public void internalError(Exception exception, ServiceCall servicecall)
    {
        serviceCall.setUnderlyingCall(servicecall);
        getCallback().error(exception, serviceCall);
    }
}
