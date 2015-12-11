// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.SetNotificationSubscriptionsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, NotificationTargetDefaultEncoder, PushNotificationSubscriptionDefaultEncoder, DefaultEncoder

public class SetNotificationSubscriptionsRequestDefaultEncoder
    implements Encoder
{

    public SetNotificationSubscriptionsRequestDefaultEncoder()
    {
    }

    public void encode(SetNotificationSubscriptionsRequest setnotificationsubscriptionsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        (new NotificationTargetDefaultEncoder()).encode(setnotificationsubscriptionsrequest.getNotificationTarget(), dataoutputstream);
        DefaultEncoder.getArrayInstance(new PushNotificationSubscriptionDefaultEncoder()).encode(setnotificationsubscriptionsrequest.getSubscriptions(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((SetNotificationSubscriptionsRequest)obj, dataoutputstream);
    }
}
