// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsResponse;
import java.io.DataInputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, PushNotificationSubscriptionGroupDefaultDecoder, DefaultDecoder, PushNotificationSubscriptionDefaultDecoder, 
//            HyperTextDefaultDecoder, StreamedResponseListener

public class GetNotificationSubscriptionsResponseDefaultDecoder
    implements Decoder
{

    public GetNotificationSubscriptionsResponseDefaultDecoder()
    {
    }

    public GetNotificationSubscriptionsResponse decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new GetNotificationSubscriptionsResponse();
        streamedresponselistener.setSubscriptionGroups((List)DefaultDecoder.getArrayInstance(new PushNotificationSubscriptionGroupDefaultDecoder()).decode(datainputstream, null));
        streamedresponselistener.setSubscriptions((List)DefaultDecoder.getArrayInstance(new PushNotificationSubscriptionDefaultDecoder()).decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setMessage((new HyperTextDefaultDecoder()).decode(datainputstream, null));
        }
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setHelpLink((new HyperTextDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
