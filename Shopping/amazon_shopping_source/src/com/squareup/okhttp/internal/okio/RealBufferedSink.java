// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.IOException;
import java.io.OutputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            BufferedSink, OkBuffer, Sink, Util, 
//            Deadline, ByteString

final class RealBufferedSink
    implements BufferedSink
{

    public final OkBuffer buffer;
    private boolean closed;
    public final Sink sink;

    public RealBufferedSink(Sink sink1)
    {
        this(sink1, new OkBuffer());
    }

    public RealBufferedSink(Sink sink1, OkBuffer okbuffer)
    {
        if (sink1 == null)
        {
            throw new IllegalArgumentException("sink == null");
        } else
        {
            buffer = okbuffer;
            sink = sink1;
            return;
        }
    }

    private void checkNotClosed()
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        } else
        {
            return;
        }
    }

    public OkBuffer buffer()
    {
        return buffer;
    }

    public void close()
        throws IOException
    {
        if (!closed) goto _L2; else goto _L1
_L1:
        return;
_L2:
        Throwable throwable;
        Throwable throwable1;
        throwable1 = null;
        throwable = throwable1;
        if (buffer.size <= 0L)
        {
            break MISSING_BLOCK_LABEL_46;
        }
        sink.write(buffer, buffer.size);
        throwable = throwable1;
_L3:
        sink.close();
        throwable1 = throwable;
_L4:
        closed = true;
        if (throwable1 != null)
        {
            Util.sneakyRethrow(throwable1);
            return;
        }
          goto _L1
        throwable;
          goto _L3
        Throwable throwable2;
        throwable2;
        throwable1 = throwable;
        if (throwable == null)
        {
            throwable1 = throwable2;
        }
          goto _L4
    }

    public Sink deadline(Deadline deadline1)
    {
        sink.deadline(deadline1);
        return this;
    }

    public BufferedSink emitCompleteSegments()
        throws IOException
    {
        checkNotClosed();
        long l = buffer.completeSegmentByteCount();
        if (l > 0L)
        {
            sink.write(buffer, l);
        }
        return this;
    }

    public void flush()
        throws IOException
    {
        checkNotClosed();
        if (buffer.size > 0L)
        {
            sink.write(buffer, buffer.size);
        }
        sink.flush();
    }

    public OutputStream outputStream()
    {
        return new OutputStream() {

            final RealBufferedSink this$0;

            private void checkNotClosed()
                throws IOException
            {
                if (closed)
                {
                    throw new IOException("closed");
                } else
                {
                    return;
                }
            }

            public void close()
                throws IOException
            {
                RealBufferedSink.this.close();
            }

            public void flush()
                throws IOException
            {
                if (!closed)
                {
                    RealBufferedSink.this.flush();
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append(RealBufferedSink.this).append(".outputStream()").toString();
            }

            public void write(int i)
                throws IOException
            {
                checkNotClosed();
                buffer.writeByte((byte)i);
                emitCompleteSegments();
            }

            public void write(byte abyte0[], int i, int j)
                throws IOException
            {
                checkNotClosed();
                buffer.write(abyte0, i, j);
                emitCompleteSegments();
            }

            
            {
                this$0 = RealBufferedSink.this;
                super();
            }
        };
    }

    public String toString()
    {
        return (new StringBuilder()).append("buffer(").append(sink).append(")").toString();
    }

    public BufferedSink write(ByteString bytestring)
        throws IOException
    {
        checkNotClosed();
        buffer.write(bytestring);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte abyte0[])
        throws IOException
    {
        checkNotClosed();
        buffer.write(abyte0);
        return emitCompleteSegments();
    }

    public BufferedSink write(byte abyte0[], int i, int j)
        throws IOException
    {
        checkNotClosed();
        buffer.write(abyte0, i, j);
        return emitCompleteSegments();
    }

    public void write(OkBuffer okbuffer, long l)
        throws IOException
    {
        checkNotClosed();
        buffer.write(okbuffer, l);
        emitCompleteSegments();
    }

    public BufferedSink writeByte(int i)
        throws IOException
    {
        checkNotClosed();
        buffer.writeByte(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeInt(int i)
        throws IOException
    {
        checkNotClosed();
        buffer.writeInt(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeShort(int i)
        throws IOException
    {
        checkNotClosed();
        buffer.writeShort(i);
        return emitCompleteSegments();
    }

    public BufferedSink writeUtf8(String s)
        throws IOException
    {
        checkNotClosed();
        buffer.writeUtf8(s);
        return emitCompleteSegments();
    }

}
