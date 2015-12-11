// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.ToggleMarketplaceNotificationsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, NotificationTargetDefaultEncoder

public class ToggleMarketplaceNotificationsRequestDefaultEncoder
    implements Encoder
{

    public ToggleMarketplaceNotificationsRequestDefaultEncoder()
    {
    }

    public void encode(ToggleMarketplaceNotificationsRequest togglemarketplacenotificationsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (togglemarketplacenotificationsrequest.getEnableNotifications() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(togglemarketplacenotificationsrequest.getEnableNotifications(), dataoutputstream);
        }
        if (togglemarketplacenotificationsrequest.getNotificationTarget() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new NotificationTargetDefaultEncoder()).encode(togglemarketplacenotificationsrequest.getNotificationTarget(), dataoutputstream);
        }
        if (togglemarketplacenotificationsrequest.getRecognizedRequiredOnly() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getBooleanInstance().encode(togglemarketplacenotificationsrequest.getRecognizedRequiredOnly(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((ToggleMarketplaceNotificationsRequest)obj, dataoutputstream);
    }
}
