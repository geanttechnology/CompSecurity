// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import java.io.IOException;
import java.io.OutputStream;
import java.io.Writer;

// Referenced classes of package com.google.common.io:
//            BaseEncoding

class writtenChars extends OutputStream
{

    int bitBuffer;
    int bitBufferLength;
    final writtenChars this$0;
    final Writer val$out;
    int writtenChars;

    public void close()
        throws IOException
    {
        if (bitBufferLength > 0)
        {
            int i = bitBuffer;
            int j = phabet.phabet;
            int k = bitBufferLength;
            int l = phabet.phabet;
            val$out.write(phabet.phabet(i << j - k & l));
            writtenChars = writtenChars + 1;
            if (ddingChar != null)
            {
                for (; writtenChars % phabet.phabet != 0; writtenChars = writtenChars + 1)
                {
                    val$out.write(ddingChar.charValue());
                }

            }
        }
        val$out.close();
    }

    public void flush()
        throws IOException
    {
        val$out.flush();
    }

    public void write(int i)
        throws IOException
    {
        bitBuffer = bitBuffer << 8;
        bitBuffer = bitBuffer | i & 0xff;
        for (bitBufferLength = bitBufferLength + 8; bitBufferLength >= phabet.phabet; bitBufferLength = bitBufferLength - phabet.phabet)
        {
            i = bitBuffer;
            int j = bitBufferLength;
            int k = phabet.phabet;
            int l = phabet.phabet;
            val$out.write(phabet.phabet(i >> j - k & l));
            writtenChars = writtenChars + 1;
        }

    }

    ()
    {
        this$0 = final_;
        val$out = Writer.this;
        super();
        bitBuffer = 0;
        bitBufferLength = 0;
        writtenChars = 0;
    }
}
