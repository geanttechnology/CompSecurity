// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.spdy;

import d.aa;
import d.ac;
import d.f;

// Referenced classes of package com.squareup.okhttp.internal.spdy:
//            SpdyStream, SpdyConnection

final class this._cls0
    implements aa
{

    static final boolean $assertionsDisabled;
    private static final long EMIT_BUFFER_SIZE = 16384L;
    private boolean closed;
    private boolean finished;
    private final f sendBuffer = new f();
    final SpdyStream this$0;

    private void emitDataFrame(boolean flag)
    {
        SpdyStream spdystream = SpdyStream.this;
        spdystream;
        JVM INSTR monitorenter ;
        SpdyStream.access$1100(SpdyStream.this).nter();
        for (; bytesLeftInWriteWindow <= 0L && !finished && !closed && SpdyStream.access$800(SpdyStream.this) == null; SpdyStream.access$900(SpdyStream.this)) { }
        break MISSING_BLOCK_LABEL_81;
        Exception exception;
        exception;
        SpdyStream.access$1100(SpdyStream.this).xitAndThrowIfTimedOut();
        throw exception;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
        long l;
        SpdyStream.access$1100(SpdyStream.this).xitAndThrowIfTimedOut();
        SpdyStream.access$1200(SpdyStream.this);
        l = Math.min(bytesLeftInWriteWindow, sendBuffer.a());
        SpdyStream spdystream1 = SpdyStream.this;
        spdystream1.bytesLeftInWriteWindow = spdystream1.bytesLeftInWriteWindow - l;
        spdystream;
        JVM INSTR monitorexit ;
        SpdyConnection spdyconnection = SpdyStream.access$500(SpdyStream.this);
        int i = SpdyStream.access$600(SpdyStream.this);
        if (flag && l == sendBuffer.a())
        {
            flag = true;
        } else
        {
            flag = false;
        }
        spdyconnection.writeData(i, flag, sendBuffer, l);
        return;
    }

    public final void close()
    {
label0:
        {
            if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
            {
                throw new AssertionError();
            }
            synchronized (SpdyStream.this)
            {
                if (!closed)
                {
                    break label0;
                }
            }
            return;
        }
        spdystream;
        JVM INSTR monitorexit ;
        if (!sink.finished)
        {
            if (sendBuffer.a() > 0L)
            {
                for (; sendBuffer.a() > 0L; emitDataFrame(true)) { }
            } else
            {
                SpdyStream.access$500(SpdyStream.this).writeData(SpdyStream.access$600(SpdyStream.this), true, null, 0L);
            }
        }
        break MISSING_BLOCK_LABEL_113;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
        synchronized (SpdyStream.this)
        {
            closed = true;
        }
        SpdyStream.access$500(SpdyStream.this).flush();
        SpdyStream.access$1000(SpdyStream.this);
        return;
        exception1;
        spdystream1;
        JVM INSTR monitorexit ;
        throw exception1;
    }

    public final void flush()
    {
        if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
        {
            throw new AssertionError();
        }
        synchronized (SpdyStream.this)
        {
            SpdyStream.access$1200(SpdyStream.this);
        }
        for (; sendBuffer.a() > 0L; emitDataFrame(false)) { }
        break MISSING_BLOCK_LABEL_65;
        exception;
        spdystream;
        JVM INSTR monitorexit ;
        throw exception;
        SpdyStream.access$500(SpdyStream.this).flush();
        return;
    }

    public final ac timeout()
    {
        return SpdyStream.access$1100(SpdyStream.this);
    }

    public final void write(f f1, long l)
    {
        if (!$assertionsDisabled && Thread.holdsLock(SpdyStream.this))
        {
            throw new AssertionError();
        }
        sendBuffer.write(f1, l);
        for (; sendBuffer.a() >= 16384L; emitDataFrame(false)) { }
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
    static boolean access$202( , boolean flag)
    {
        .finished = flag;
        return flag;
    }

*/


    finished()
    {
        this$0 = SpdyStream.this;
        super();
    }
}
