// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

static final class val.upperBound
    implements Encoder
{

    final long val$lowerBound;
    final long val$upperBound;

    public void encode(Integer integer, DataOutputStream dataoutputstream)
        throws IOException
    {
        DefaultEncoder.access$000(integer.intValue(), val$lowerBound, val$upperBound, dataoutputstream);
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((Integer)obj, dataoutputstream);
    }

    (long l, long l1)
    {
        val$lowerBound = l;
        val$upperBound = l1;
        super();
    }
}
