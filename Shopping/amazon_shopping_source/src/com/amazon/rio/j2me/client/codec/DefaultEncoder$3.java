// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.rio.j2me.client.codec;

import java.io.DataOutputStream;
import java.io.IOException;

// Referenced classes of package com.amazon.rio.j2me.client.codec:
//            Encoder, DefaultEncoder

static final class 
    implements Encoder
{

    public void encode(Byte byte1, DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeByte(byte1.byteValue());
    }

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((Byte)obj, dataoutputstream);
    }

    ()
    {
    }
}
