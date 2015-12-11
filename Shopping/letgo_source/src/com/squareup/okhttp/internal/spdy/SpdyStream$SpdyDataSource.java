// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import android.support.v7.apv;
import android.support.v7.apx;
import android.support.v7.aqk;
import android.support.v7.aql;
import java.io.EOFException;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream, SpdyConnection, Settings, ErrorCode

private final class <init>
    implements aqk
{

    static final boolean $assertionsDisabled;
    private boolean closed;
    private boolean finished;
    private final long maxByteCount;
    private final apv readBuffer;
    private final apv receiveBuffer;
    final SpdyStream this$0;

    private void checkNotClosed()
        throws IOException
    {
        if (closed)
        {
            throw new IOException("stream closed");
        }
        if (SpdyStream.access$800(SpdyStream.this) != null)
        {
            throw new IOException((new StringBuilder()).append("stream was reset: ").append(SpdyStream.access$800(SpdyStream.this)).toString());
        } else
        {
            return;
        }
    }

    private void waitUntilReadable()
        throws IOException
    {
        SpdyStream.access$700(SpdyStream.this).er();
        for (; readBuffer.a() == 0L && !finished && !closed && SpdyStream.access$800(SpdyStream.this) == null; SpdyStream.access$900(SpdyStream.this)) { }
        break MISSING_BLOCK_LABEL_69;
        Exception exception;
        exception;
        SpdyStream.access$700(SpdyStream.this).tAndThrowIfTimedOut();
        throw exception;
        SpdyStream.access$700(SpdyStream.this).tAndThrowIfTimedOut();
        return;
    }

    public void close()
        throws IOException
    {
        synchronized (SpdyStream.this)
        {
            closed = true;
            readBuffer.t();
            notifyAll();
        }
        SpdyStream.access$1000(SpdyStream.this);
        return;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
    }

    public long read(apv apv1, long l)
        throws IOException
    {
label0:
        {
            if (l < 0L)
            {
                throw new IllegalArgumentException((new StringBuilder()).append("byteCount < 0: ").append(l).toString());
            }
            synchronized (SpdyStream.this)
            {
                waitUntilReadable();
                checkNotClosed();
                if (readBuffer.a() != 0L)
                {
                    break label0;
                }
            }
            return -1L;
        }
        l = readBuffer.read(apv1, Math.min(l, readBuffer.a()));
        apv1 = SpdyStream.this;
        apv1.unacknowledgedBytesRead = ((SpdyStream) (apv1)).unacknowledgedBytesRead + l;
        if (unacknowledgedBytesRead >= (long)(SpdyStream.access$500(SpdyStream.this).okHttpSettings.getInitialWindowSize(0x10000) / 2))
        {
            SpdyStream.access$500(SpdyStream.this).writeWindowUpdateLater(SpdyStream.access$600(SpdyStream.this), unacknowledgedBytesRead);
            unacknowledgedBytesRead = 0L;
        }
        obj;
        JVM INSTR monitorexit ;
        synchronized (SpdyStream.access$500(SpdyStream.this))
        {
            obj = SpdyStream.access$500(SpdyStream.this);
            obj.unacknowledgedBytesRead = ((SpdyConnection) (obj)).unacknowledgedBytesRead + l;
            if (SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead >= (long)(SpdyStream.access$500(SpdyStream.this).okHttpSettings.getInitialWindowSize(0x10000) / 2))
            {
                SpdyStream.access$500(SpdyStream.this).writeWindowUpdateLater(0, SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead);
                SpdyStream.access$500(SpdyStream.this).unacknowledgedBytesRead = 0L;
            }
        }
        return l;
        obj;
        apv1;
        JVM INSTR monitorexit ;
        throw obj;
        apv1;
        obj;
        JVM INSTR monitorexit ;
        throw apv1;
    }

    void receive(apx apx1, long l)
        throws IOException
    {
        long l1;
        l1 = l;
        if (!$assertionsDisabled)
        {
            l1 = l;
            if (Thread.holdsLock(SpdyStream.this))
            {
                throw new AssertionError();
            }
        }
          goto _L1
_L3:
        l1 -= l;
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        boolean flag;
        boolean flag1;
        if (readBuffer.a() == 0L)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        readBuffer.a(receiveBuffer);
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_84;
        }
        notifyAll();
        spdystream;
        JVM INSTR monitorexit ;
_L1:
        if (l1 <= 0L)
        {
            break MISSING_BLOCK_LABEL_156;
        }
        spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        flag1 = finished;
        if (readBuffer.a() + l1 > maxByteCount)
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spdystream;
        JVM INSTR monitorexit ;
        if (!flag)
        {
            break MISSING_BLOCK_LABEL_169;
        }
        apx1.g(l1);
        closeLater(ErrorCode.FLOW_CONTROL_ERROR);
        return;
        apx1;
        spdystream;
        JVM INSTR monitorexit ;
        throw apx1;
        if (flag1)
        {
            apx1.g(l1);
            return;
        }
        l = apx1.read(receiveBuffer, l1);
        if (l != -1L) goto _L3; else goto _L2
_L2:
        throw new EOFException();
        apx1;
        spdystream;
        JVM INSTR monitorexit ;
        throw apx1;
    }

    public aql timeout()
    {
        return SpdyStream.access$700(SpdyStream.this);
    }

    static 
    {
        boolean flag;
        if (!com/squareup/okhttp/internal/spdy/SpdyStream.desiredAssertionStatus())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        $assertionsDisabled = flag;
    }



/*
    static boolean access$102(A a, boolean flag)
    {
        a.finished = flag;
        return flag;
    }

*/


    private finished(long l)
    {
        this$0 = SpdyStream.this;
        super();
        receiveBuffer = new apv();
        readBuffer = new apv();
        maxByteCount = l;
    }

    maxByteCount(long l, maxByteCount maxbytecount)
    {
        this(l);
    }
}
