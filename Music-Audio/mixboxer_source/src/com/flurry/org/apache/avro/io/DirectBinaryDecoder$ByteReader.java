// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            DirectBinaryDecoder

private class <init>
{

    final DirectBinaryDecoder this$0;

    public ByteBuffer read(ByteBuffer bytebuffer, int i)
        throws IOException
    {
        if (bytebuffer != null && i <= bytebuffer.capacity())
        {
            bytebuffer.clear();
        } else
        {
            bytebuffer = ByteBuffer.allocate(i);
        }
        doReadBytes(bytebuffer.array(), bytebuffer.position(), i);
        bytebuffer.limit(i);
        return bytebuffer;
    }

    private ()
    {
        this$0 = DirectBinaryDecoder.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
