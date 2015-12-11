// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscription;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, HyperTextDefaultEncoder

public class PushNotificationSubscriptionDefaultEncoder
    implements Encoder
{

    public PushNotificationSubscriptionDefaultEncoder()
    {
    }

    public void encode(PushNotificationSubscription pushnotificationsubscription, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(pushnotificationsubscription.getSubscriptionId(), dataoutputstream);
        Boolean boolean1;
        Encoder encoder;
        boolean flag;
        if (pushnotificationsubscription.getGroupId() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(pushnotificationsubscription.getGroupId(), dataoutputstream);
        }
        if (pushnotificationsubscription.getTitle() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(pushnotificationsubscription.getTitle(), dataoutputstream);
        }
        encoder = DefaultEncoder.getBooleanInstance();
        if (pushnotificationsubscription.getSubscribed())
        {
            boolean1 = Boolean.TRUE;
        } else
        {
            boolean1 = Boolean.FALSE;
        }
        encoder.encode(boolean1, dataoutputstream);
        if (pushnotificationsubscription.getRequiresUserRecognized() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(pushnotificationsubscription.getRequiresUserRecognized(), dataoutputstream);
        }
        if (pushnotificationsubscription.getDetails() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new HyperTextDefaultEncoder()).encode(pushnotificationsubscription.getDetails(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((PushNotificationSubscription)obj, dataoutputstream);
    }
}
