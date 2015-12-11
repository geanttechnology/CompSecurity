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

    public volatile void encode(Object obj, DataOutputStream dataoutputstream)
        throws IOException
    {
        encode((byte[])obj, dataoutputstream);
    }

    public void encode(byte abyte0[], DataOutputStream dataoutputstream)
        throws IOException
    {
        dataoutputstream.writeInt(abyte0.length);
        dataoutputstream.write(abyte0);
    }

    ()
    {
    }
}
