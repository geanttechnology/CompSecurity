// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BufferedBinaryEncoder

static class <init> extends <init>
{

    private final OutputStream out;

    protected void innerFlush()
        throws IOException
    {
        out.flush();
    }

    protected void innerWrite(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
    }

    private (OutputStream outputstream)
    {
        out = outputstream;
    }

    out(OutputStream outputstream, out out1)
    {
        this(outputstream);
    }
}
