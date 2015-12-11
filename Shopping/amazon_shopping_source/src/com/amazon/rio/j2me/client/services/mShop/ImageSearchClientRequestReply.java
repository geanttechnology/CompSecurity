// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.Decoder;
import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.PhotoSearchRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.SearchResultDefaultDecoder;
import com.amazon.rio.j2me.client.rsc.ServiceCall;
import com.amazon.rio.j2me.client.services.BaseClientRequestReply;
import com.amazon.rio.j2me.client.services.ResponseListener;
import com.amazon.rio.j2me.client.services.ServiceCallImpl;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            ImageSearchResponseListener, PhotoSearchRequest

public class ImageSearchClientRequestReply extends BaseClientRequestReply
{

    private final ImageSearchResponseListener callback;
    private final PhotoSearchRequest request;

    public ImageSearchClientRequestReply(ServiceCallImpl servicecallimpl, PhotoSearchRequest photosearchrequest, ImageSearchResponseListener imagesearchresponselistener)
    {
        super(servicecallimpl);
        request = photosearchrequest;
        callback = imagesearchresponselistener;
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
            inputstream = (List)DefaultDecoder.getArrayInstance(new SearchResultDefaultDecoder()).decode(inputstream, null);
            serviceCall.allDataReceived();
            callback.completed(inputstream, serviceCall);
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
        (new PhotoSearchRequestDefaultEncoder()).encode(request, outputstream);
    }
}
