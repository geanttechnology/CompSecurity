// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.flurry.org.apache.avro.io;

import com.flurry.org.apache.avro.AvroRuntimeException;
import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.flurry.org.apache.avro.io:
//            BinaryEncoder, BinaryData

public class BufferedBinaryEncoder extends BinaryEncoder
{
    private static abstract class ByteSink
    {

        protected abstract void innerFlush()
            throws IOException;

        protected abstract void innerWrite(byte abyte0[], int i, int j)
            throws IOException;

        protected ByteSink()
        {
        }
    }

    static class OutputStreamSink extends ByteSink
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

        private OutputStreamSink(OutputStream outputstream)
        {
            out = outputstream;
        }

    }


    private byte buf[];
    private int bulkLimit;
    private int pos;
    private ByteSink sink;

    BufferedBinaryEncoder(OutputStream outputstream, int i)
    {
        configure(outputstream, i);
    }

    private void ensureBounds(int i)
        throws IOException
    {
        if (buf.length - pos < i)
        {
            flushBuffer();
        }
    }

    private void flushBuffer()
        throws IOException
    {
        if (pos > 0)
        {
            sink.innerWrite(buf, 0, pos);
            pos = 0;
        }
    }

    private void writeByte(int i)
        throws IOException
    {
        if (pos == buf.length)
        {
            flushBuffer();
        }
        byte abyte0[] = buf;
        int j = pos;
        pos = j + 1;
        abyte0[j] = (byte)(i & 0xff);
    }

    public int bytesBuffered()
    {
        return pos;
    }

    BufferedBinaryEncoder configure(OutputStream outputstream, int i)
    {
        if (outputstream == null)
        {
            throw new NullPointerException("OutputStream cannot be null!");
        }
        if (sink != null && pos > 0)
        {
            try
            {
                flushBuffer();
            }
            // Misplaced declaration of an exception variable
            catch (OutputStream outputstream)
            {
                throw new AvroRuntimeException("Failure flushing old output", outputstream);
            }
        }
        sink = new OutputStreamSink(outputstream);
        pos = 0;
        if (buf == null || buf.length != i)
        {
            buf = new byte[i];
        }
        bulkLimit = buf.length >>> 1;
        if (bulkLimit > 512)
        {
            bulkLimit = 512;
        }
        return this;
    }

    public void flush()
        throws IOException
    {
        flushBuffer();
        sink.innerFlush();
    }

    public void writeBoolean(boolean flag)
        throws IOException
    {
        if (buf.length == pos)
        {
            flushBuffer();
        }
        pos = pos + BinaryData.encodeBoolean(flag, buf, pos);
    }

    public void writeDouble(double d)
        throws IOException
    {
        ensureBounds(8);
        pos = pos + BinaryData.encodeDouble(d, buf, pos);
    }

    public void writeFixed(byte abyte0[], int i, int j)
        throws IOException
    {
        if (j > bulkLimit)
        {
            flushBuffer();
            sink.innerWrite(abyte0, i, j);
            return;
        } else
        {
            ensureBounds(j);
            System.arraycopy(abyte0, i, buf, pos, j);
            pos = pos + j;
            return;
        }
    }

    public void writeFloat(float f)
        throws IOException
    {
        ensureBounds(4);
        pos = pos + BinaryData.encodeFloat(f, buf, pos);
    }

    public void writeInt(int i)
        throws IOException
    {
        ensureBounds(5);
        pos = pos + BinaryData.encodeInt(i, buf, pos);
    }

    public void writeLong(long l)
        throws IOException
    {
        ensureBounds(10);
        pos = pos + BinaryData.encodeLong(l, buf, pos);
    }

    protected void writeZero()
        throws IOException
    {
        writeByte(0);
    }
}
