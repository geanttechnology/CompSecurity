// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.common.io;

import com.google.common.base.Ascii;
import com.google.common.base.Optional;
import com.google.common.base.Preconditions;
import com.google.common.hash.HashCode;
import com.google.common.hash.HashFunction;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Arrays;

// Referenced classes of package com.google.common.io:
//            ByteSource, ByteProcessor, BaseEncoding

private static class length extends ByteSource
{

    final byte bytes[];
    final int length;
    final int offset;

    public long copyTo(OutputStream outputstream)
        throws IOException
    {
        outputstream.write(bytes, offset, length);
        return (long)length;
    }

    public HashCode hash(HashFunction hashfunction)
        throws IOException
    {
        return hashfunction.hashBytes(bytes, offset, length);
    }

    public boolean isEmpty()
    {
        return length == 0;
    }

    public InputStream openBufferedStream()
        throws IOException
    {
        return openStream();
    }

    public InputStream openStream()
    {
        return new ByteArrayInputStream(bytes, offset, length);
    }

    public Object read(ByteProcessor byteprocessor)
        throws IOException
    {
        byteprocessor.processBytes(bytes, offset, length);
        return byteprocessor.getResult();
    }

    public byte[] read()
    {
        return Arrays.copyOfRange(bytes, offset, offset + length);
    }

    public long size()
    {
        return (long)length;
    }

    public Optional sizeIfKnown()
    {
        return Optional.of(Long.valueOf(length));
    }

    public ByteSource slice(long l, long l1)
    {
        int i;
        int j;
        boolean flag;
        if (l >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "offset (%s) may not be negative", new Object[] {
            Long.valueOf(l)
        });
        if (l1 >= 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        Preconditions.checkArgument(flag, "length (%s) may not be negative", new Object[] {
            Long.valueOf(l1)
        });
        l = Math.min(l, length);
        l1 = Math.min(l1, (long)length - l);
        i = offset;
        j = (int)l;
        return new <init>(bytes, i + j, (int)l1);
    }

    public String toString()
    {
        String s = Ascii.truncate(BaseEncoding.base16().encode(bytes, offset, length), 30, "...");
        return (new StringBuilder(String.valueOf(s).length() + 17)).append("ByteSource.wrap(").append(s).append(")").toString();
    }

    _cls9(byte abyte0[])
    {
        this(abyte0, 0, abyte0.length);
    }

    <init>(byte abyte0[], int i, int j)
    {
        bytes = abyte0;
        offset = i;
        length = j;
    }
}
