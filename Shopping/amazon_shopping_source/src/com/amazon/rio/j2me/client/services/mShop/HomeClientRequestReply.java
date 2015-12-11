// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.services.mShop;

import com.amazon.rio.j2me.client.codec.DefaultDecoder;
import com.amazon.rio.j2me.client.codec.HomeRequestDefaultEncoder;
import com.amazon.rio.j2me.client.codec.HomeResponseDefaultDecoder;
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
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.services.mShop:
//            HomeResponseListener, LoginData, PromoSlot, HomeShoveler, 
//            CartItems, Notification, HomeRequest

public class HomeClientRequestReply extends BaseClientRequestReply
    implements StreamedResponseListener
{

    private final HomeResponseListener callback;
    private final HomeRequest request;

    public HomeClientRequestReply(ServiceCallImpl servicecallimpl, HomeRequest homerequest, HomeResponseListener homeresponselistener)
    {
        super(servicecallimpl);
        request = homerequest;
        callback = homeresponselistener;
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
            (new HomeResponseDefaultDecoder()).decode(inputstream, this);
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
        (new HomeRequestDefaultEncoder()).encode(request, outputstream);
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
            throw new RuntimeException((new StringBuilder()).append("Unexpected field number ").append(ai[0]).append(" for record of Rio type 'Home_Response'").toString());

        case 0: // '\0'
            callback.receivedLoginData((LoginData)obj, serviceCall);
            return;

        case 1: // '\001'
            callback.receivedPromoSlot0((PromoSlot)obj, serviceCall);
            return;

        case 2: // '\002'
            callback.receivedPromoSlot1((PromoSlot)obj, serviceCall);
            return;

        case 3: // '\003'
            callback.receivedShoveler0((HomeShoveler)obj, serviceCall);
            return;

        case 4: // '\004'
            callback.receivedShoveler1((HomeShoveler)obj, serviceCall);
            return;

        case 5: // '\005'
            callback.receivedCompletedRemembersItemIds((List)obj, serviceCall);
            return;

        case 6: // '\006'
            callback.receivedCartItems((CartItems)obj, serviceCall);
            return;

        case 7: // '\007'
            callback.receivedNotification((Notification)obj, serviceCall);
            break;
        }
    }
}
