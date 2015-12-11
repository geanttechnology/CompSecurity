// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

static final class val.elementEncoder
    implements Encoder
{

    final Encoder val$elementEncoder;

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((List)obj, dataoutputstream);
    }

    public void encode(List list, DataOutputStream dataoutputstream)
        throws IOException
    {
        int j = list.size();
        dataoutputstream.writeInt(j);
        for (int i = 0; i < j; i++)
        {
            val$elementEncoder.encode(list.get(i), dataoutputstream);
        }

    }

    (Encoder encoder)
    {
        val$elementEncoder = encoder;
        super();
    }
}
