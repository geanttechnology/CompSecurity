// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import com.amazon.rio.j2me.client.services.mShop.PostEventsRequest;
import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DeviceEventDefaultEncoder, DefaultEncoder

public class PostEventsRequestDefaultEncoder
    implements Encoder
{

    public PostEventsRequestDefaultEncoder()
    {
    }

    public void encode(PostEventsRequest posteventsrequest, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.getArrayInstance(new DeviceEventDefaultEncoder()).encode(posteventsrequest.getEvents(), dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((PostEventsRequest)obj, dataoutputstream);
    }
}
