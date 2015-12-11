// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.ByteArrayInputStream;
import java.io.IOException;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            SeekableInput

public class SeekableByteArrayInput extends ByteArrayInputStream
    implements SeekableInput
{

    public SeekableByteArrayInput(byte abyte0[])
    {
        super(abyte0);
    }

    public long length()
        throws IOException
    {
        return (long)count;
    }

    public void seek(long l)
        throws IOException
    {
        reset();
        skip(l);
    }

    public long tell()
        throws IOException
    {
        return (long)pos;
    }
}
