// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.DealRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.DealResponseDefaultDecoder;
import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.StreamedResponseListener;
import com.amazon.rio.j2me.client.rsc.ServiceCall;
import com.amazon.rio.j2me.client.services.BaseClientRequestReply;
import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCallImpl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            DealResponseListener, Deal, DealRequest

public class DealClientRequestReply extends BaseClientRequestReply
    implements StreamedResponseListener
{

    private final DealResponseListener callback;
    private final DealRequest request;

    public DealClientRequestReply(ServiceCallImpl servicecallimpl, DealRequest dealrequest, DealResponseListener dealresponselistener)
    {
        super(servicecallimpl);
        request = dealrequest;
        callback = dealresponselistener;
    }

    public void aboutToReceiveArrayOfSize(int i, int ai[])
    {
    }

    public void consumeReply(InputStream inputstream, ServiceCall servicecall)
        throws IOException
    {
        super.consumeReply(inputstream, servicecall);
        if (inputstream instanceof DataInputStream)
        {
            inputstream = (DataInputStream)inputstream;
        } else
        {
            inputstream = new DataInputStream(inputstream);
        }
        if (DefaultDecoder.isErrorResponse(inputstream))
        {
            inputstream = DefaultDecoder.decodeApplicationException(inputstream);
            callback.error(inputstream, serviceCall);
            return;
        } else
        {
            (new DealResponseDefaultDecoder()).decode(inputstream, this);
            return;
        }
    }

    protected ResponseListener getCallback()
    {
        return callback;
    }

    public void produceRequestData(OutputStream outputstream, ServiceCall servicecall)
        throws IOException
    {
        serviceCall.setUnderlyingCall(servicecall);
        if (outputstream instanceof DataOutputStream)
        {
            outputstream = (DataOutputStream)outputstream;
        } else
        {
            outputstream = new DataOutputStream(outputstream);
        }
        (new DealRequestDefaultEncoder()).encode(request, outputstream);
    }

    public void receivedObject(Object obj, int ai[])
    {
        if (ai.length < 1)
        {
            serviceCall.allDataReceived();
            callback.completed(serviceCall);
            return;
        }
        switch (ai[0])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unexpected field number ").append(ai[0]).append(" for record of Rio type 'Deal_Response'").toString());

        case 0: // '\0'
            callback.receivedDeal((Deal)obj, serviceCall);
            break;
        }
    }
}
