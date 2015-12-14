// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import com.squareup.okhttp.internal.Internal;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import okio.ByteString;
import okio.d;
import okio.e;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Settings, Http20Draft14, ErrorCode

final class maxFrameSize
    implements FrameWriter
{

    private final boolean client;
    private boolean closed;
    private final d hpackBuffer = new d();
    private final sink hpackWriter;
    private int maxFrameSize;
    private final e sink;

    private void writeContinuationFrames(int i, long l)
    {
        while (l > 0L) 
        {
            int j = (int)Math.min(maxFrameSize, l);
            l -= j;
            byte byte0;
            if (l == 0L)
            {
                byte0 = 4;
            } else
            {
                byte0 = 0;
            }
            frameHeader(i, j, (byte)9, byte0);
            sink.write(hpackBuffer, j);
        }
    }

    public void ackSettings(Settings settings1)
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
        maxFrameSize = settings1.getMaxFrameSize(maxFrameSize);
        frameHeader(0, 0, (byte)4, (byte)1);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void close()
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

    public void connectionPreface()
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
        if (Internal.logger.isLoggable(Level.FINE))
        {
            Internal.logger.fine(String.format(">> CONNECTION %s", new Object[] {
                Http20Draft14.access$000().c()
            }));
        }
        sink.c(Http20Draft14.access$000().f());
        sink.flush();
          goto _L1
    }

    public void data(boolean flag, int i, d d1, int j)
    {
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_24;
        d1;
        this;
        JVM INSTR monitorexit ;
        throw d1;
        byte byte0;
        byte0 = 0;
        if (flag)
        {
            byte0 = (byte)1;
        }
        dataFrame(i, byte0, d1, j);
        this;
        JVM INSTR monitorexit ;
    }

    void dataFrame(int i, byte byte0, d d1, int j)
    {
        frameHeader(i, j, (byte)0, byte0);
        if (j > 0)
        {
            sink.write(d1, j);
        }
    }

    public void flush()
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

    void frameHeader(int i, int j, byte byte0, byte byte1)
    {
        if (Internal.logger.isLoggable(Level.FINE))
        {
            Internal.logger.fine(gger.formatHeader(false, i, j, byte0, byte1));
        }
        if (j > maxFrameSize)
        {
            throw Http20Draft14.access$400("FRAME_SIZE_ERROR length > %d: %d", new Object[] {
                Integer.valueOf(maxFrameSize), Integer.valueOf(j)
            });
        }
        if ((0x80000000 & i) != 0)
        {
            throw Http20Draft14.access$400("reserved bit set: %s", new Object[] {
                Integer.valueOf(i)
            });
        } else
        {
            Http20Draft14.access$500(sink, j);
            sink.g(byte0 & 0xff);
            sink.g(byte1 & 0xff);
            sink.e(0x7fffffff & i);
            return;
        }
    }

    public void goAway(int i, ErrorCode errorcode, byte abyte0[])
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
            throw Http20Draft14.access$400("errorCode.httpCode == -1", new Object[0]);
        }
        frameHeader(0, abyte0.length + 8, (byte)7, (byte)0);
        sink.e(i);
        sink.e(errorcode.httpCode);
        if (abyte0.length > 0)
        {
            sink.c(abyte0);
        }
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void headers(int i, List list)
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
        headers(false, i, list);
        this;
        JVM INSTR monitorexit ;
    }

    void headers(boolean flag, int i, List list)
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        if (hpackBuffer.a() != 0L)
        {
            throw new IllegalStateException();
        }
        hpackWriter.riteHeaders(list);
        long l = hpackBuffer.a();
        int j = (int)Math.min(maxFrameSize, l);
        byte byte0;
        byte byte1;
        if (l == (long)j)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        byte1 = byte0;
        if (flag)
        {
            byte1 = (byte)(byte0 | 1);
        }
        frameHeader(i, j, (byte)1, byte1);
        sink.write(hpackBuffer, j);
        if (l > (long)j)
        {
            writeContinuationFrames(i, l - (long)j);
        }
    }

    public int maxDataLength()
    {
        return maxFrameSize;
    }

    public void ping(boolean flag, int i, int j)
    {
        byte byte0 = 0;
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_29;
        Exception exception;
        exception;
        this;
        JVM INSTR monitorexit ;
        throw exception;
        if (flag)
        {
            byte0 = 1;
        }
        frameHeader(0, 8, (byte)6, byte0);
        sink.e(i);
        sink.e(j);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void pushPromise(int i, int j, List list)
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
        int k;
        long l;
        if (hpackBuffer.a() != 0L)
        {
            throw new IllegalStateException();
        }
        hpackWriter.riteHeaders(list);
        l = hpackBuffer.a();
        k = (int)Math.min(maxFrameSize - 4, l);
        byte byte0;
        if (l == (long)k)
        {
            byte0 = 4;
        } else
        {
            byte0 = 0;
        }
        frameHeader(i, k + 4, (byte)5, byte0);
        sink.e(0x7fffffff & j);
        sink.write(hpackBuffer, k);
        if (l <= (long)k)
        {
            break MISSING_BLOCK_LABEL_150;
        }
        writeContinuationFrames(i, l - (long)k);
        this;
        JVM INSTR monitorexit ;
    }

    public void rstStream(int i, ErrorCode errorcode)
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
        frameHeader(i, 4, (byte)3, (byte)0);
        sink.e(errorcode.httpCode);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void settings(Settings settings1)
    {
        int i = 0;
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_26;
        settings1;
        this;
        JVM INSTR monitorexit ;
        throw settings1;
        frameHeader(0, settings1.size() * 6, (byte)4, (byte)0);
_L6:
        if (i >= 10) goto _L2; else goto _L1
_L1:
        if (settings1.isSet(i)) goto _L4; else goto _L3
_L5:
        int j;
        sink.f(j);
        sink.e(settings1.get(i));
          goto _L3
_L2:
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
_L8:
        j = i;
          goto _L5
_L3:
        i++;
          goto _L6
_L4:
        if (i != 4)
        {
            continue; /* Loop/switch isn't completed */
        }
        j = 3;
          goto _L5
        if (i != 7) goto _L8; else goto _L7
_L7:
        j = 4;
          goto _L5
    }

    public void synReply(boolean flag, int i, List list)
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
        headers(flag, i, list);
        this;
        JVM INSTR monitorexit ;
    }

    public void synStream(boolean flag, boolean flag1, int i, int j, List list)
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
        headers(flag, i, list);
        this;
        JVM INSTR monitorexit ;
    }

    public void windowUpdate(int i, long l)
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
        throw Http20Draft14.access$400("windowSizeIncrement == 0 || windowSizeIncrement > 0x7fffffffL: %s", new Object[] {
            Long.valueOf(l)
        });
        frameHeader(i, 4, (byte)8, (byte)0);
        sink.e((int)l);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    gger(e e1, boolean flag)
    {
        sink = e1;
        client = flag;
        hpackWriter = new init>(hpackBuffer);
        maxFrameSize = 16384;
    }
}
