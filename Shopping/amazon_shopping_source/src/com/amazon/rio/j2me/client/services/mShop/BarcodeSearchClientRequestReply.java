// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.BarcodeSearchRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.BarcodeSearchResponseDefaultDecoder;
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
//            BarcodeSearchResponseListener, SearchResult, QueryDescriptor, SearchResultsCounts, 
//            BarcodeSearchRequest

public class BarcodeSearchClientRequestReply extends BaseClientRequestReply
    implements StreamedResponseListener
{

    private final BarcodeSearchResponseListener callback;
    private final BarcodeSearchRequest request;

    public BarcodeSearchClientRequestReply(ServiceCallImpl servicecallimpl, BarcodeSearchRequest barcodesearchrequest, BarcodeSearchResponseListener barcodesearchresponselistener)
    {
        super(servicecallimpl);
        request = barcodesearchrequest;
        callback = barcodesearchresponselistener;
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
            (new BarcodeSearchResponseDefaultDecoder()).decode(inputstream, this);
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
        (new BarcodeSearchRequestDefaultEncoder()).encode(request, outputstream);
    }

    public void receivedObject(Object obj, int ai[])
    {
        if (ai.length >= 1) goto _L2; else goto _L1
_L1:
        serviceCall.allDataReceived();
        callback.completed(serviceCall);
_L13:
        return;
_L2:
        ai[0];
        JVM INSTR tableswitch 0 7: default 76
    //                   0 110
    //                   1 128
    //                   2 149
    //                   3 167
    //                   4 185
    //                   5 203
    //                   6 221
    //                   7 248;
           goto _L3 _L4 _L5 _L6 _L7 _L8 _L9 _L10 _L11
_L11:
        continue; /* Loop/switch isn't completed */
_L3:
        throw new RuntimeException((new StringBuilder()).append("Unexpected field number ").append(ai[0]).append(" for record of Rio type 'Barcode_Search_Response'").toString());
_L4:
        callback.receivedMatchedItem((SearchResult)obj, serviceCall);
        return;
_L5:
        callback.receivedMatchedItemThumbnail((byte[])(byte[])obj, serviceCall);
        return;
_L6:
        callback.receivedMatchedItemsReturned((Boolean)obj, serviceCall);
        return;
_L7:
        callback.receivedResultsTitle((String)obj, serviceCall);
        return;
_L8:
        callback.receivedQueryDescriptor((QueryDescriptor)obj, serviceCall);
        return;
_L9:
        callback.receivedCounts((SearchResultsCounts)obj, serviceCall);
        return;
_L10:
        if (ai.length <= 1) goto _L13; else goto _L12
_L12:
        callback.receivedSearchResult((SearchResult)obj, ai[1], serviceCall);
        return;
        if (ai.length <= 1) goto _L13; else goto _L14
_L14:
        callback.receivedImage((byte[])(byte[])obj, ai[1], serviceCall);
        return;
    }
}
