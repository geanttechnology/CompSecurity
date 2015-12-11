// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PushNotificationSubscriptionGroup;
import java.io.DataInputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Decoder, DefaultDecoder, HyperTextDefaultDecoder, StreamedResponseListener

public class PushNotificationSubscriptionGroupDefaultDecoder
    implements Decoder
{

    public PushNotificationSubscriptionGroupDefaultDecoder()
    {
    }

    public PushNotificationSubscriptionGroup decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        streamedresponselistener = new PushNotificationSubscriptionGroup();
        streamedresponselistener.setGroupId((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        streamedresponselistener.setTitle((String)DefaultDecoder.getStringInstance().decode(datainputstream, null));
        if (!datainputstream.readBoolean())
        {
            streamedresponselistener.setDetails((new HyperTextDefaultDecoder()).decode(datainputstream, null));
        }
        return streamedresponselistener;
    }

    public volatile Object decode(DataInputStream datainputstream, StreamedResponseListener streamedresponselistener)
        throws IOException
    {
        return decode(datainputstream, streamedresponselistener);
    }
}
