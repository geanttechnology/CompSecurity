// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.file;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.flurry.org.apache.avro.file:
//            SeekableInput, DataFileReader

static class in extends InputStream
    implements SeekableInput
{

    private SeekableInput in;
    private final byte oneByte[] = new byte[1];

    public int available()
        throws IOException
    {
        long l = in.length() - in.tell();
        if (l > 0x7fffffffL)
        {
            return 0x7fffffff;
        } else
        {
            return (int)l;
        }
    }

    public void close()
        throws IOException
    {
        in.close();
        super.close();
    }

    public long length()
        throws IOException
    {
        return in.length();
    }

    public int read()
        throws IOException
    {
        int j = read(oneByte, 0, 1);
        int i = j;
        if (j == 1)
        {
            i = oneByte[0] & 0xff;
        }
        return i;
    }

    public int read(byte abyte0[])
        throws IOException
    {
        return in.read(abyte0, 0, abyte0.length);
    }

    public int read(byte abyte0[], int i, int j)
        throws IOException
    {
        return in.read(abyte0, i, j);
    }

    public void seek(long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IOException((new StringBuilder()).append("Illegal seek: ").append(l).toString());
        } else
        {
            in.seek(l);
            return;
        }
    }

    public long skip(long l)
        throws IOException
    {
        long l1 = in.tell();
        long l2 = in.length() - l1;
        if (l2 > l)
        {
            in.seek(l);
            return in.tell() - l1;
        } else
        {
            in.seek(l2);
            return in.tell() - l1;
        }
    }

    public long tell()
        throws IOException
    {
        return in.tell();
    }

    (SeekableInput seekableinput)
        throws IOException
    {
        in = seekableinput;
    }
}
