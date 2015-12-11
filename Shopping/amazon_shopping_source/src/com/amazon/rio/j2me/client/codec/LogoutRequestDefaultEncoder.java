// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.LogoutRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, NotificationTargetDefaultEncoder

public class LogoutRequestDefaultEncoder
    implements Encoder
{

    public LogoutRequestDefaultEncoder()
    {
    }

    public void encode(LogoutRequest logoutrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (logoutrequest.getNotificationTarget() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new NotificationTargetDefaultEncoder()).encode(logoutrequest.getNotificationTarget(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((LogoutRequest)obj, dataoutputstream);
    }
}
