// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.communication;

import amazon.communication.ResponseHandler;
import com.amazon.client.metrics.DataPointEnvelope;
import com.amazon.dp.logger.DPLogger;
import java.util.List;

// Referenced classes of package com.amazon.communication:
//            MessageEnvelope, HttpRequestResponseConverter

public class ResponseHandlerProxy extends IResponseHandler.Stub
{

    private static final DPLogger log = new DPLogger("TComm.ResponseHandlerProxy");
    private final HttpRequestResponseConverter mHttpRequestResponseConverter;
    private ResponseHandler mResponseHandler;

    public ResponseHandlerProxy(ResponseHandler responsehandler, HttpRequestResponseConverter httprequestresponseconverter)
    {
        mResponseHandler = responsehandler;
        mHttpRequestResponseConverter = httprequestresponseconverter;
    }

    public ResponseHandler getClientHandler()
    {
        return mResponseHandler;
    }

    public void onResponse(MessageEnvelope messageenvelope, List list)
    {
        try
        {
            mResponseHandler.onResponse(null, mHttpRequestResponseConverter.convertMessageToResponse(messageenvelope.toMessage()), 0, DataPointEnvelope.convertFromEnvelopes(list));
            return;
        }
        // Misplaced declaration of an exception variable
        catch (MessageEnvelope messageenvelope)
        {
            log.warn("onResponse", "Caught exception for client on-response callback!", new Object[] {
                messageenvelope
            });
        }
    }

}
