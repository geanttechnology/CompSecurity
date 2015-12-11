// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.Decoder;
import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.NullDefaultEncoder;
import com.amazon.rio.j2me.client.codec.OneClickAddressDefaultDecoder;
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
//            GetOneClickAddressesResponseListener, Null

public class GetOneClickAddressesClientRequestReply extends BaseClientRequestReply
{

    private final GetOneClickAddressesResponseListener callback;
    private final Null request;

    public GetOneClickAddressesClientRequestReply(ServiceCallImpl servicecallimpl, Null null1, GetOneClickAddressesResponseListener getoneclickaddressesresponselistener)
    {
        super(servicecallimpl);
        request = null1;
        callback = getoneclickaddressesresponselistener;
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
            inputstream = (List)DefaultDecoder.getArrayInstance(new OneClickAddressDefaultDecoder()).decode(inputstream, null);
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
        (new NullDefaultEncoder()).encode(request, outputstream);
    }
}
