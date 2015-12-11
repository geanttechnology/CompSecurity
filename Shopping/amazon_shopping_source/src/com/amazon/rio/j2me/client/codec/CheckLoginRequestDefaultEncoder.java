// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.CheckLoginRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder, NotificationTargetDefaultEncoder

public class CheckLoginRequestDefaultEncoder
    implements Encoder
{

    public CheckLoginRequestDefaultEncoder()
    {
    }

    public void encode(CheckLoginRequest checkloginrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        boolean flag;
        if (checkloginrequest.getOneClickDeviceName() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            DefaultEncoder.getStringInstance().encode(checkloginrequest.getOneClickDeviceName(), dataoutputstream);
        }
        if (checkloginrequest.getNotificationTarget() == null)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        dataoutputstream.writeBoolean(flag);
        if (!flag)
        {
            (new NotificationTargetDefaultEncoder()).encode(checkloginrequest.getNotificationTarget(), dataoutputstream);
        }
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((CheckLoginRequest)obj, dataoutputstream);
    }
}
