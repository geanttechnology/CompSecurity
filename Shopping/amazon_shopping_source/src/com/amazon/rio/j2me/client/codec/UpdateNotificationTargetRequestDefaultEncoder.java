// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.UpdateNotificationTargetRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, NotificationTargetDefaultEncoder

public class UpdateNotificationTargetRequestDefaultEncoder
    implements Encoder
{

    public UpdateNotificationTargetRequestDefaultEncoder()
    {
    }

    public void encode(UpdateNotificationTargetRequest updatenotificationtargetrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        (new NotificationTargetDefaultEncoder()).encode(updatenotificationtargetrequest.getOldNotificationTarget(), dataoutputstream);
        (new NotificationTargetDefaultEncoder()).encode(updatenotificationtargetrequest.getNewNotificationTarget(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((UpdateNotificationTargetRequest)obj, dataoutputstream);
    }
}
