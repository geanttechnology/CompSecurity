// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.RecommendedItemsRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.RecommendedItemsResponseDefaultDecoder;
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
//            GetRecommendedItemsResponseListener, SearchResult, CategoryResult, RecommendedItemsRequest

public class GetRecommendedItemsClientRequestReply extends BaseClientRequestReply
    implements StreamedResponseListener
{

    private final GetRecommendedItemsResponseListener callback;
    private final RecommendedItemsRequest request;

    public GetRecommendedItemsClientRequestReply(ServiceCallImpl servicecallimpl, RecommendedItemsRequest recommendeditemsrequest, GetRecommendedItemsResponseListener getrecommendeditemsresponselistener)
    {
        super(servicecallimpl);
        request = recommendeditemsrequest;
        callback = getrecommendeditemsresponselistener;
    }

    public void aboutToReceiveArrayOfSize(int i, int ai[])
    {
        callback.aboutToReceiveArrayOfSize(i, serviceCall);
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
            (new RecommendedItemsResponseDefaultDecoder()).decode(inputstream, this);
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
        (new RecommendedItemsRequestDefaultEncoder()).encode(request, outputstream);
    }

    public void receivedObject(Object obj, int ai[])
    {
        if (ai.length >= 1) goto _L2; else goto _L1
_L1:
        serviceCall.allDataReceived();
        callback.completed(serviceCall);
_L4:
        return;
_L2:
        switch (ai[0])
        {
        default:
            throw new RuntimeException((new StringBuilder()).append("Unexpected field number ").append(ai[0]).append(" for record of Rio type 'Recommended_Items_Response'").toString());

        case 0: // '\0'
            callback.receivedAvailableCount((Integer)obj, serviceCall);
            return;

        case 1: // '\001'
            if (ai.length > 1)
            {
                callback.receivedSearchResult((SearchResult)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 2: // '\002'
            if (ai.length > 1)
            {
                callback.receivedImage((byte[])(byte[])obj, ai[1], serviceCall);
                return;
            }
            break;

        case 3: // '\003'
            if (ai.length > 1)
            {
                callback.receivedCategoryResult((CategoryResult)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 4: // '\004'
            callback.receivedNoRecommendationsExplanation((String)obj, serviceCall);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
