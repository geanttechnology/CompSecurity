// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.GetNotificationSubscriptionsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, NotificationTargetDefaultEncoder

public class GetNotificationSubscriptionsRequestDefaultEncoder
    implements Encoder
{

    public GetNotificationSubscriptionsRequestDefaultEncoder()
    {
    }

    public void encode(GetNotificationSubscriptionsRequest getnotificationsubscriptionsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        (new NotificationTargetDefaultEncoder()).encode(getnotificationsubscriptionsrequest.getNotificationTarget(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((GetNotificationSubscriptionsRequest)obj, dataoutputstream);
    }
}
