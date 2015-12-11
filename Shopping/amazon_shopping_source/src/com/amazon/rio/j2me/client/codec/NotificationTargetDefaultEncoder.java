// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.NotificationTarget;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

public class NotificationTargetDefaultEncoder
    implements Encoder
{

    public NotificationTargetDefaultEncoder()
    {
    }

    public void encode(NotificationTarget notificationtarget, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getStringInstance().encode(notificationtarget.getDestination(), dataoutputstream);
        DefaultEncoder.getStringInstance().encode(notificationtarget.getApplicationId(), dataoutputstream);
        DefaultEncoder.getEnumInstance(4).encode(new Integer(notificationtarget.getType()), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((NotificationTarget)obj, dataoutputstream);
    }
}
