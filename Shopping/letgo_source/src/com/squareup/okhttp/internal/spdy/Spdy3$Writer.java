// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apw;
import android.support.v7.apy;
import android.support.v7.apz;
import android.support.v7.aqe;
import com.squareup.okhttp.internal.Util;
import java.io.IOException;
import java.util.List;
import java.util.zip.Deflater;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            FrameWriter, Spdy3, Header, ErrorCode, 
//            Settings

static final class headerBlockBuffer
    implements FrameWriter
{

    private final boolean client;
    private boolean closed;
    private final apv headerBlockBuffer = new apv();
    private final apw headerBlockOut;
    private final apw sink;

    private void writeNameValueBlockToBuffer(List list)
        throws IOException
    {
        if (headerBlockBuffer.a() != 0L)
        {
            throw new IllegalStateException();
        }
        headerBlockOut.e(list.size());
        int j = list.size();
        for (int i = 0; i < j; i++)
        {
            apy apy1 = ((Header)list.get(i)).name;
            headerBlockOut.e(apy1.f());
            headerBlockOut.b(apy1);
            apy1 = ((Header)list.get(i)).value;
            headerBlockOut.e(apy1.f());
            headerBlockOut.b(apy1);
        }

        headerBlockOut.flush();
    }

    public void ackSettings(Settings settings1)
    {
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        closed = true;
        Util.closeAll(sink, headerBlockOut);
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
    }

    public void data(boolean flag, int i, apv apv1, int j)
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        int k;
        if (flag)
        {
            k = 1;
        } else
        {
            k = 0;
        }
        sendDataFrame(i, k, apv1, j);
        this;
        JVM INSTR monitorexit ;
        return;
        apv1;
        throw apv1;
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
        if (errorcode.spdyGoAwayCode == -1)
        {
            throw new IllegalArgumentException("errorCode.spdyGoAwayCode == -1");
        }
        sink.e(0x80030007);
        sink.e(8);
        sink.e(i);
        sink.e(errorcode.spdyGoAwayCode);
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
        writeNameValueBlockToBuffer(list);
        int j = (int)(headerBlockBuffer.a() + 4L);
        sink.e(0x80030008);
        sink.e(j & 0xffffff | 0);
        sink.e(0x7fffffff & i);
        sink.a(headerBlockBuffer);
        this;
        JVM INSTR monitorexit ;
    }

    public int maxDataLength()
    {
        return 16383;
    }

    public void ping(boolean flag, int i, int j)
        throws IOException
    {
        boolean flag2 = true;
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
        boolean flag3 = client;
        boolean flag1;
        if ((i & 1) == 1)
        {
            flag1 = true;
        } else
        {
            flag1 = false;
        }
        if (flag3 != flag1)
        {
            flag1 = flag2;
        } else
        {
            flag1 = false;
        }
          goto _L1
_L3:
        if (flag == flag1)
        {
            break MISSING_BLOCK_LABEL_64;
        }
        throw new IllegalArgumentException("payload != reply");
        sink.e(0x80030006);
        sink.e(4);
        sink.e(i);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
_L1:
        if (true) goto _L3; else goto _L2
_L2:
    }

    public void pushPromise(int i, int j, List list)
        throws IOException
    {
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
        sink.e(0x80030003);
        sink.e(8);
        sink.e(0x7fffffff & i);
        sink.e(errorcode.spdyRstCode);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    void sendDataFrame(int i, int j, apv apv1, int k)
        throws IOException
    {
        if (closed)
        {
            throw new IOException("closed");
        }
        if ((long)k > 0xffffffL)
        {
            throw new IllegalArgumentException((new StringBuilder()).append("FRAME_TOO_LARGE max size is 16Mib: ").append(k).toString());
        }
        sink.e(0x7fffffff & i);
        sink.e((j & 0xff) << 24 | 0xffffff & k);
        if (k > 0)
        {
            sink.write(apv1, k);
        }
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
        int i = settings1.size();
        sink.e(0x80030004);
        sink.e(i * 8 + 4 & 0xffffff | 0);
        sink.e(i);
        int j = 0;
_L2:
        if (j > 10)
        {
            break MISSING_BLOCK_LABEL_139;
        }
        if (!settings1.isSet(j))
        {
            break MISSING_BLOCK_LABEL_151;
        }
        int k = settings1.flags(j);
        sink.e((k & 0xff) << 24 | j & 0xffffff);
        sink.e(settings1.get(j));
        break MISSING_BLOCK_LABEL_151;
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        j++;
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
        writeNameValueBlockToBuffer(list);
        int j;
        int k;
        if (flag)
        {
            j = 1;
        } else
        {
            j = 0;
        }
        k = (int)(headerBlockBuffer.a() + 4L);
        sink.e(0x80030002);
        sink.e((j & 0xff) << 24 | k & 0xffffff);
        sink.e(0x7fffffff & i);
        sink.a(headerBlockBuffer);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    public void synStream(boolean flag, boolean flag1, int i, int j, List list)
        throws IOException
    {
        byte byte0 = 0;
        this;
        JVM INSTR monitorenter ;
        if (closed)
        {
            throw new IOException("closed");
        }
        break MISSING_BLOCK_LABEL_29;
        list;
        this;
        JVM INSTR monitorexit ;
        throw list;
        int k;
        writeNameValueBlockToBuffer(list);
        k = (int)(10L + headerBlockBuffer.a());
        break MISSING_BLOCK_LABEL_49;
_L2:
        sink.e(0x80030001);
        sink.e(((byte0 | flag2) & 0xff) << 24 | k & 0xffffff);
        sink.e(i & 0x7fffffff);
        sink.e(j & 0x7fffffff);
        sink.f(0);
        sink.a(headerBlockBuffer);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
        return;
        boolean flag2;
        if (flag)
        {
            flag2 = true;
        } else
        {
            flag2 = false;
        }
        if (flag1)
        {
            byte0 = 2;
        }
        if (true) goto _L2; else goto _L1
_L1:
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
            break MISSING_BLOCK_LABEL_67;
        }
        throw new IllegalArgumentException((new StringBuilder()).append("windowSizeIncrement must be between 1 and 0x7fffffff: ").append(l).toString());
        sink.e(0x80030009);
        sink.e(8);
        sink.e(i);
        sink.e((int)l);
        sink.flush();
        this;
        JVM INSTR monitorexit ;
    }

    (apw apw1, boolean flag)
    {
        sink = apw1;
        client = flag;
        apw1 = new Deflater();
        apw1.setDictionary(Spdy3.DICTIONARY);
        headerBlockOut = aqe.a(new apz(headerBlockBuffer, apw1));
    }
}
