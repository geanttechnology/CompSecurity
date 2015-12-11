// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import com.squareup.okhttp.internal.okio.BufferedSink;
import com.squareup.okhttp.internal.okio.OkBuffer;
import com.squareup.okhttp.internal.okio.Sink;
import java.io.IOException;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

private final class <init>
    implements Sink
{

    private boolean closed;
    private final byte hex[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 13, 10
    };
    final HttpConnection this$0;

    private void writeHex(long l)
        throws IOException
    {
        int i = 16;
        int j;
        long l1;
        do
        {
            byte abyte0[] = hex;
            j = i - 1;
            abyte0[j] = HttpConnection.access$500()[(int)(15L & l)];
            l1 = l >>> 4;
            i = j;
            l = l1;
        } while (l1 != 0L);
        HttpConnection.access$200(HttpConnection.this).write(hex, j, hex.length - j);
    }

    public void close()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = closed;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        closed = true;
        HttpConnection.access$200(HttpConnection.this).write(HttpConnection.access$400());
        HttpConnection.access$302(HttpConnection.this, 3);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void flush()
        throws IOException
    {
        this;
        JVM INSTR monitorenter ;
        boolean flag = closed;
        if (!flag) goto _L2; else goto _L1
_L1:
        this;
        JVM INSTR monitorexit ;
        return;
_L2:
        HttpConnection.access$200(HttpConnection.this).flush();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void write(OkBuffer okbuffer, long l)
        throws IOException
    {
        if (closed)
        {
            throw new IllegalStateException("closed");
        }
        if (l == 0L)
        {
            return;
        } else
        {
            writeHex(l);
            HttpConnection.access$200(HttpConnection.this).write(okbuffer, l);
            HttpConnection.access$200(HttpConnection.this).writeUtf8("\r\n");
            return;
        }
    }

    private ()
    {
        this$0 = HttpConnection.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
