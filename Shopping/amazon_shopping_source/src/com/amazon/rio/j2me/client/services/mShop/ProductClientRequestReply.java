// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.ProductRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.ProductResponseDefaultDecoder;
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
//            ProductResponseListener, PrimeOneClickStatus, BasicProductInfo, Savings, 
//            BasicOfferListing, PrimeOneClickShippingOffers, ExtraProductInfo, ExtraOfferListing, 
//            MultiImage, Dimension, VariationProductInfo, VisualBucket, 
//            WebLink, ProductRequest

public class ProductClientRequestReply extends BaseClientRequestReply
    implements StreamedResponseListener
{

    private final ProductResponseListener callback;
    private final ProductRequest request;

    public ProductClientRequestReply(ServiceCallImpl servicecallimpl, ProductRequest productrequest, ProductResponseListener productresponselistener)
    {
        super(servicecallimpl);
        request = productrequest;
        callback = productresponselistener;
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
            (new ProductResponseDefaultDecoder()).decode(inputstream, this);
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
        (new ProductRequestDefaultEncoder()).encode(request, outputstream);
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
            throw new RuntimeException((new StringBuilder()).append("Unexpected field number ").append(ai[0]).append(" for record of Rio type 'Product_Response'").toString());

        case 0: // '\0'
            callback.receivedPrimeOneClickStatus((PrimeOneClickStatus)obj, serviceCall);
            return;

        case 1: // '\001'
            callback.receivedBasicProduct((BasicProductInfo)obj, serviceCall);
            return;

        case 2: // '\002'
            callback.receivedSavings((Savings)obj, serviceCall);
            return;

        case 3: // '\003'
            callback.receivedBasicOffer((BasicOfferListing)obj, serviceCall);
            return;

        case 4: // '\004'
            callback.receivedPrimeOneClickShippingOffers((PrimeOneClickShippingOffers)obj, serviceCall);
            return;

        case 5: // '\005'
            callback.receivedExtraProduct((ExtraProductInfo)obj, serviceCall);
            return;

        case 6: // '\006'
            callback.receivedExtraOffer((ExtraOfferListing)obj, serviceCall);
            return;

        case 7: // '\007'
            callback.receivedImage((byte[])(byte[])obj, serviceCall);
            return;

        case 8: // '\b'
            if (ai.length > 1)
            {
                callback.receivedMultiImage((MultiImage)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 9: // '\t'
            if (ai.length > 1)
            {
                callback.receivedDimension((Dimension)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 10: // '\n'
            if (ai.length > 1)
            {
                callback.receivedVariationProductInfo((VariationProductInfo)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 11: // '\013'
            if (ai.length > 1)
            {
                callback.receivedVisualBucket((VisualBucket)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 12: // '\f'
            if (ai.length > 1)
            {
                callback.receivedWebLink((WebLink)obj, ai[1], serviceCall);
                return;
            }
            break;

        case 13: // '\r'
            callback.receivedExternalBuyLink((WebLink)obj, serviceCall);
            return;

        case 14: // '\016'
            callback.receivedDealId((String)obj, serviceCall);
            return;
        }
        if (true) goto _L4; else goto _L3
_L3:
    }
}
