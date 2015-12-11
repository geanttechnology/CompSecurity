// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.ByteString;
import com.squareup.okhttp.internal.okio.OkBuffer;
import java.io.IOException;
import java.util.List;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Http20Draft09, ErrorCode, Settings

static final class hpackBuffer
    implements FrameWriter
{

    private final boolean client;
    private boolean closed;
    private final OkBuffer hpackBuffer = new OkBuffer();
    private final sink hpackWriter;
    private final BufferedSink sink;

    private void headers(boolean flag, int i, int j, List list)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        if (hpackBuffer.size() != 0L)
        {
            throw new IllegalStateException();
        }
        hpackWriter.riteHeaders(list);
        int l = (int)hpackBuffer.size();
        byte byte0 = 4;
        if (flag)
        {
            byte0 = (byte)5;
        }
        byte byte1 = byte0;
        if (j != -1)
        {
            byte1 = (byte)(byte0 | 8);
        }
        int k = l;
        if (j != -1)
        {
            k = l + 4;
        }
        frameHeader(k, (byte)1, byte1, i);
        if (j != -1)
        {
            sink.writeInt(0x7fffffff & j);
        }
        sink.write(hpackBuffer, hpackBuffer.size());
    }

    public void ackSettings()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        frameHeader(0, (byte)4, (byte)1, 0);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        closed = true;
        sink.close();
        this;
        JVM INSTR monitorexit ;
        return;
        Exception exception;
        exception;
        throw exception;
    }

    public void connectionHeader()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        boolean flag = client;
        if (flag)
        {
            break MISSING_BLOCK_LABEL_36;
        }
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
        sink.write(Http20Draft09.access$000().toByteArray());
        sink.flush();
          goto _L1
    }

    public void data(boolean flag, int i, OkBuffer okbuffer)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        data(flag, i, okbuffer, (int)okbuffer.size());
        this;
        JVM INSTR monitorexit ;
        return;
        okbuffer;
        throw okbuffer;
    }

    public void data(boolean flag, int i, OkBuffer okbuffer, int j)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        okbuffer;
        this;
        JVM INSTR monitorexit ;
        throw okbuffer;
        byte byte0;
        byte0 = 0;
        if (flag)
        {
            byte0 = (byte)1;
        }
        dataFrame(i, byte0, okbuffer, j);
        this;
        JVM INSTR monitorexit ;
    }

    void dataFrame(int i, byte byte0, OkBuffer okbuffer, int j)
        throws IOException
    {
        frameHeader(j, (byte)0, byte0, i);
        if (j > 0)
        {
            sink.write(okbuffer, j);
        }
    }

    public void flush()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    void frameHeader(int i, byte byte0, byte byte1, int j)
        throws IOException
    {
        if (i > 16383)
        {
            throw Http20Draft09.access$200("FRAME_SIZE_ERROR length > 16383: %s", new Object[] {
                Integer.valueOf(i)
            });
        }
        if ((0x80000000 & j) != 0)
        {
            throw Http20Draft09.access$200("reserved bit set: %s", new Object[] {
                Integer.valueOf(j)
            });
        } else
        {
            sink.writeInt((i & 0x3fff) << 16 | (byte0 & 0xff) << 8 | byte1 & 0xff);
            sink.writeInt(0x7fffffff & j);
            return;
        }
    }

    public void goAway(int i, ErrorCode errorcode, byte abyte0[])
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        if (errorcode.httpCode == -1)
        {
            throw Http20Draft09.access$200("errorCode.httpCode == -1", new Object[0]);
        }
        frameHeader(abyte0.length + 8, (byte)7, (byte)0, 0);
        sink.writeInt(i);
        sink.writeInt(errorcode.httpCode);
        if (abyte0.length > 0)
        {
            sink.write(abyte0);
        }
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void headers(int i, List list)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        headers(false, i, -1, list);
        this;
        JVM INSTR monitorexit ;
    }

    public void ping(boolean flag, int i, int j)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        byte byte0;
        if (flag)
        {
            byte0 = 1;
        } else
        {
            byte0 = 0;
        }
        frameHeader(8, (byte)6, byte0, 0);
        sink.writeInt(i);
        sink.writeInt(j);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void pushPromise(int i, int j, List list)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        if (hpackBuffer.size() != 0L)
        {
            throw new IllegalStateException();
        }
        hpackWriter.riteHeaders(list);
        frameHeader((int)(4L + hpackBuffer.size()), (byte)5, (byte)4, i);
        sink.writeInt(0x7fffffff & j);
        sink.write(hpackBuffer, hpackBuffer.size());
        this;
        JVM INSTR monitorexit ;
    }

    public void rstStream(int i, ErrorCode errorcode)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        errorcode;
        this;
        JVM INSTR monitorexit ;
        throw errorcode;
        if (errorcode.spdyRstCode == -1)
        {
            throw new IllegalArgumentException();
        }
        frameHeader(4, (byte)3, (byte)0, i);
        sink.writeInt(errorcode.httpCode);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void settings(Settings settings1)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        settings1;
        this;
        JVM INSTR monitorexit ;
        throw settings1;
        frameHeader(settings1.size() * 8, (byte)4, (byte)0, 0);
        int i = 0;
_L2:
        if (i >= 10)
        {
            break MISSING_BLOCK_LABEL_89;
        }
        if (!settings1.isSet(i))
        {
            break MISSING_BLOCK_LABEL_101;
        }
        sink.writeInt(0xffffff & i);
        sink.writeInt(settings1.get(i));
        break MISSING_BLOCK_LABEL_101;
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        i++;
        if (true) goto _L2; else goto _L1
_L1:
    }

    public void synReply(boolean flag, int i, List list)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        headers(flag, i, -1, list);
        this;
        JVM INSTR monitorexit ;
    }

    public void synStream(boolean flag, boolean flag1, int i, int j, int k, int l, List list)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (!flag1)
        {
            break MISSING_BLOCK_LABEL_21;
        }
        throw new UnsupportedOperationException();
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        if (closed)
        {
            throw new IOException("closed");
        }
        headers(flag, i, k, list);
        this;
        JVM INSTR monitorexit ;
    }

    public void windowUpdate(int i, long l)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_26;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (l != 0L && l <= 0x7fffffffL)
        {
            break MISSING_BLOCK_LABEL_57;
        }
        throw Http20Draft09.access$200("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
            Long.valueOf(l)
        });
        frameHeader(4, (byte)9, (byte)0, i);
        sink.writeInt((int)l);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    (BufferedSink bufferedsink, boolean flag)
    {
        sink = bufferedsink;
        client = flag;
        hpackWriter = new init>(hpackBuffer);
    }
}
