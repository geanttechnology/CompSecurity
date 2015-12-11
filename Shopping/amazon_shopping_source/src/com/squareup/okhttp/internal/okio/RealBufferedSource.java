// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.okio;

import java.io.EOFException;
import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.squareup.okhttp.internal.okio:
//            BufferedSource, OkBuffer, Source, Deadline, 
//            ByteString, Util

final class RealBufferedSource
    implements BufferedSource
{

    public final OkBuffer buffer;
    private boolean closed;
    public final Source source;

    public RealBufferedSource(Source source1)
    {
        this(source1, new OkBuffer());
    }

    public RealBufferedSource(Source source1, OkBuffer okbuffer)
    {
        if (source1 == null)
        {
            throw new IllegalArgumentException("source == null");
        } else
        {
            buffer = okbuffer;
            source = source1;
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
        if (closed)
        {
            return;
        } else
        {
            closed = true;
            source.close();
            buffer.clear();
            return;
        }
    }

    public Source deadline(Deadline deadline1)
    {
        source.deadline(deadline1);
        return this;
    }

    public boolean exhausted()
        throws IOException
    {
        checkNotClosed();
        return buffer.exhausted() && source.read(buffer, 2048L) == -1L;
    }

    public InputStream inputStream()
    {
        return new InputStream() {

            final RealBufferedSource this$0;

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

            public int available()
                throws IOException
            {
                checkNotClosed();
                return (int)Math.min(buffer.size, 0x7fffffffL);
            }

            public void close()
                throws IOException
            {
                RealBufferedSource.this.close();
            }

            public int read()
                throws IOException
            {
                checkNotClosed();
                if (buffer.size == 0L && source.read(buffer, 2048L) == -1L)
                {
                    return -1;
                } else
                {
                    return buffer.readByte() & 0xff;
                }
            }

            public int read(byte abyte0[], int i, int j)
                throws IOException
            {
                checkNotClosed();
                Util.checkOffsetAndCount(abyte0.length, i, j);
                if (buffer.size == 0L && source.read(buffer, 2048L) == -1L)
                {
                    return -1;
                } else
                {
                    return buffer.read(abyte0, i, j);
                }
            }

            public String toString()
            {
                return (new StringBuilder()).append(RealBufferedSource.this).append(".inputStream()").toString();
            }

            
            {
                this$0 = RealBufferedSource.this;
                super();
            }
        };
    }

    public long read(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (l < 0L)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
        }
        checkNotClosed();
        if (buffer.size == 0L && source.read(buffer, 2048L) == -1L)
        {
            return -1L;
        } else
        {
            l = Math.min(l, buffer.size);
            return buffer.read(okbuffer, l);
        }
    }

    public byte readByte()
        throws IOException
    {
        require(1L);
        return buffer.readByte();
    }

    public ByteString readByteString(long l)
        throws IOException
    {
        require(l);
        return buffer.readByteString(l);
    }

    public int readInt()
        throws IOException
    {
        require(4L);
        return buffer.readInt();
    }

    public int readIntLe()
        throws IOException
    {
        require(4L);
        return buffer.readIntLe();
    }

    public short readShort()
        throws IOException
    {
        require(2L);
        return buffer.readShort();
    }

    public int readShortLe()
        throws IOException
    {
        require(2L);
        return buffer.readShortLe();
    }

    public String readUtf8(long l)
        throws IOException
    {
        require(l);
        return buffer.readUtf8(l);
    }

    public String readUtf8Line(boolean flag)
        throws IOException
    {
        checkNotClosed();
        long l = 0L;
        do
        {
            l = buffer.indexOf((byte)10, l);
            if (l == -1L)
            {
                l = buffer.size;
                if (source.read(buffer, 2048L) == -1L)
                {
                    if (flag)
                    {
                        throw new EOFException();
                    }
                    String s;
                    if (buffer.size != 0L)
                    {
                        s = readUtf8(buffer.size);
                    } else
                    {
                        s = null;
                    }
                    return s;
                }
            } else
            if (l > 0L && buffer.getByte(l - 1L) == 13)
            {
                String s1 = readUtf8(l - 1L);
                skip(2L);
                return s1;
            } else
            {
                String s2 = readUtf8(l);
                skip(1L);
                return s2;
            }
        } while (true);
    }

    public void require(long l)
        throws IOException
    {
        checkNotClosed();
        while (buffer.size < l) 
        {
            if (source.read(buffer, 2048L) == -1L)
            {
                throw new EOFException();
            }
        }
    }

    public long seek(byte byte0)
        throws IOException
    {
        checkNotClosed();
        long l = 0L;
        do
        {
            l = buffer.indexOf(byte0, l);
            if (l == -1L)
            {
                l = buffer.size;
                if (source.read(buffer, 2048L) == -1L)
                {
                    throw new EOFException();
                }
            } else
            {
                return l;
            }
        } while (true);
    }

    public void skip(long l)
        throws IOException
    {
        checkNotClosed();
        long l1;
        for (; l > 0L; l -= l1)
        {
            if (buffer.size == 0L && source.read(buffer, 2048L) == -1L)
            {
                throw new EOFException();
            }
            l1 = Math.min(l, buffer.size());
            buffer.skip(l1);
        }

    }

    public String toString()
    {
        return (new StringBuilder()).append("buffer(").append(source).append(")").toString();
    }

}
