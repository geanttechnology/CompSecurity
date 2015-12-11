// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication.rmr;

import amazon.communication.ConnectionAcquisitionFailedException;
import amazon.communication.Message;
import amazon.communication.MissingCredentialsException;
import amazon.communication.connection.IllegalConnectionStateException;
import amazon.communication.connection.TransmissionFailedException;
import amazon.communication.identity.EndpointIdentity;
import amazon.communication.rmr.RmrRequest;
import amazon.communication.rmr.RmrResponseCanceledException;
import amazon.communication.rmr.RmrResponseException;
import amazon.communication.rmr.RmrResponseHandler;
import com.amazon.client.metrics.MetricEvent;
import com.amazon.dp.logger.DPLogger;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

// Referenced classes of package com.amazon.communication.rmr:
//            RmrManagerBase

private class mMetricEvent
    implements RmrRequest
{

    private final EndpointIdentity mEndpoint;
    private final RmrResponseHandler mHandler;
    private final Message mMessage;
    private final MetricEvent mMetricEvent;
    private int mRequestId;
    private final AtomicBoolean mStarted = new AtomicBoolean(false);
    final RmrManagerBase this$0;

    public void cancelRequest()
    {
        cancelRequest(((RmrResponseException) (new RmrResponseCanceledException())));
    }

    public void cancelRequest(RmrResponseException rmrresponseexception)
    {
        if (RmrManagerBase.access$200(RmrManagerBase.this).get())
        {
            RmrManagerBase.access$000().info("RmrRequestImpl.cancelRequest", "cleanUp is called, give up cancelling request", new Object[] {
                "mRequestId", Integer.valueOf(mRequestId)
            });
            return;
        }
        RmrManagerBase.access$300(RmrManagerBase.this).acquireUninterruptibly();
        if (mStarted.get())
        {
            break MISSING_BLOCK_LABEL_103;
        }
        RmrManagerBase.access$000().error("RmrRequestImpl.cancelRequest", "request has not been started", new Object[] {
            "mRequestId", Integer.valueOf(mRequestId)
        });
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        return;
        RmrManagerBase.access$600(RmrManagerBase.this, mRequestId, this, mHandler, rmrresponseexception);
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        return;
        rmrresponseexception;
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        throw rmrresponseexception;
    }

    public void startRequest()
        throws ConnectionAcquisitionFailedException, MissingCredentialsException, TransmissionFailedException, IllegalConnectionStateException
    {
        if (RmrManagerBase.access$200(RmrManagerBase.this).get())
        {
            RmrManagerBase.access$000().info("RmrRequestImpl.startRequest", "cleanUp is called, give up starting request", new Object[] {
                "mRequestId", Integer.valueOf(mRequestId)
            });
            return;
        }
        RmrManagerBase.access$300(RmrManagerBase.this).acquireUninterruptibly();
        if (!mStarted.getAndSet(true))
        {
            break MISSING_BLOCK_LABEL_104;
        }
        RmrManagerBase.access$000().error("RmrRequestImpl.startRequest", "request has already been started", new Object[] {
            "mRequestId", Integer.valueOf(mRequestId)
        });
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        return;
        mRequestId = RmrManagerBase.access$400(RmrManagerBase.this).getAndIncrement();
        RmrManagerBase.access$500(RmrManagerBase.this, mRequestId, this, mEndpoint, mMessage, mHandler, mMetricEvent);
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        return;
        Exception exception;
        exception;
        RmrManagerBase.access$300(RmrManagerBase.this).release();
        throw exception;
    }

    public String toString()
    {
        return (new StringBuilder()).append("RmrRequestImpl [message=").append(mMessage).append(", handler=").append(mHandler).append(", endpoint=").append(EndpointIdentity.logSafe(mEndpoint)).append(", started=").append(mStarted).append(", requestId=").append(mRequestId).append("]").toString();
    }

    public tion(EndpointIdentity endpointidentity, Message message, RmrResponseHandler rmrresponsehandler, MetricEvent metricevent)
    {
        this$0 = RmrManagerBase.this;
        super();
        mEndpoint = endpointidentity;
        mMessage = message;
        mHandler = rmrresponsehandler;
        mMetricEvent = metricevent;
    }
}
