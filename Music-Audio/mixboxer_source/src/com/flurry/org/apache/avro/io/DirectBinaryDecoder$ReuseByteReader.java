// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.ByteBufferInputStream;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            DirectBinaryDecoder

private class bbi extends bbi
{

    private final ByteBufferInputStream bbi;
    final DirectBinaryDecoder this$0;

    public ByteBuffer read(ByteBuffer bytebuffer, int i)
        throws IOException
    {
        if (bytebuffer != null)
        {
            return super.bbi(bytebuffer, i);
        } else
        {
            return bbi.readBuffer(i);
        }
    }

    public (ByteBufferInputStream bytebufferinputstream)
    {
        this$0 = DirectBinaryDecoder.this;
        super(DirectBinaryDecoder.this, null);
        bbi = bytebufferinputstream;
    }
}
