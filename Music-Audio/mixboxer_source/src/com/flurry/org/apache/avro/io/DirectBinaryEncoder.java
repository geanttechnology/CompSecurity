// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryEncoder, BinaryData

public class DirectBinaryEncoder extends BinaryEncoder
{

    private final byte buf[] = new byte[12];
    private OutputStream out;

    DirectBinaryEncoder(OutputStream outputstream)
    {
        configure(outputstream);
    }

    public int bytesBuffered()
    {
        return 0;
    }

    DirectBinaryEncoder configure(OutputStream outputstream)
    {
        if (outputstream == null)
        {
            throw new NullPointerException("OutputStream cannot be null!");
        } else
        {
            out = outputstream;
            return this;
        }
    }

    public void flush()
        throws IOException
    {
        out.flush();
    }

    public void writeBoolean(boolean flag)
        throws IOException
    {
        OutputStream outputstream = out;
        int i;
        if (flag)
        {
            i = 1;
        } else
        {
            i = 0;
        }
        outputstream.write(i);
    }

    public void writeDouble(double d)
        throws IOException
    {
        byte abyte0[] = new byte[8];
        int i = BinaryData.encodeDouble(d, abyte0, 0);
        out.write(abyte0, 0, i);
    }

    public void writeFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        out.write(abyte0, i, j);
    }

    public void writeFloat(float f)
        throws IOException
    {
        int i = BinaryData.encodeFloat(f, buf, 0);
        out.write(buf, 0, i);
    }

    public void writeInt(int i)
        throws IOException
    {
        int j = i << 1 ^ i >> 31;
        if ((j & 0xffffff80) == 0)
        {
            out.write(j);
            return;
        }
        if ((j & 0xffffc000) == 0)
        {
            out.write(j | 0x80);
            out.write(j >>> 7);
            return;
        } else
        {
            i = BinaryData.encodeInt(i, buf, 0);
            out.write(buf, 0, i);
            return;
        }
    }

    public void writeLong(long l)
        throws IOException
    {
        long l1 = l << 1 ^ l >> 63;
        if ((0xffffffff80000000L & l1) == 0L)
        {
            int i;
            for (i = (int)l1; (i & 0xffffff80) != 0; i >>>= 7)
            {
                out.write((byte)((i | 0x80) & 0xff));
            }

            out.write((byte)i);
            return;
        } else
        {
            int j = BinaryData.encodeLong(l, buf, 0);
            out.write(buf, 0, j);
            return;
        }
    }

    protected void writeZero()
        throws IOException
    {
        out.write(0);
    }
}
