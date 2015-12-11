// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.util.Utf8;
import java.io.IOException;
import java.nio.ByteBuffer;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            Encoder

public abstract class BinaryEncoder extends Encoder
{

    public BinaryEncoder()
    {
    }

    public abstract int bytesBuffered();

    public void setItemCount(long l)
        throws IOException
    {
        if (l > 0L)
        {
            writeLong(l);
        }
    }

    public void startItem()
        throws IOException
    {
    }

    public void writeArrayEnd()
        throws IOException
    {
        writeZero();
    }

    public void writeArrayStart()
        throws IOException
    {
    }

    public void writeBytes(ByteBuffer bytebuffer)
        throws IOException
    {
        int i = bytebuffer.position();
        int j = bytebuffer.arrayOffset();
        int k = bytebuffer.limit();
        writeBytes(bytebuffer.array(), j + i, k - i);
    }

    public void writeBytes(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j == 0)
        {
            writeZero();
            return;
        } else
        {
            writeInt(j);
            writeFixed(abyte0, i, j);
            return;
        }
    }

    public void writeEnum(int i)
        throws IOException
    {
        writeInt(i);
    }

    public void writeIndex(int i)
        throws IOException
    {
        writeInt(i);
    }

    public void writeMapEnd()
        throws IOException
    {
        writeZero();
    }

    public void writeMapStart()
        throws IOException
    {
    }

    public void writeNull()
        throws IOException
    {
    }

    public void writeString(Utf8 utf8)
        throws IOException
    {
        writeBytes(utf8.getBytes(), 0, utf8.getByteLength());
    }

    public void writeString(String s)
        throws IOException
    {
        if (s.length() == 0)
        {
            writeZero();
            return;
        } else
        {
            s = s.getBytes("UTF-8");
            writeInt(s.length);
            writeFixed(s, 0, s.length);
            return;
        }
    }

    protected abstract void writeZero()
        throws IOException;
}
