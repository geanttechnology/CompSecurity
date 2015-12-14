// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import okio.d;
import okio.e;
import okio.q;
import okio.s;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements q
{

    private boolean closed;
    private final byte hex[] = {
        0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
        0, 0, 0, 0, 0, 0, 13, 10
    };
    final HttpConnection this$0;

    private void writeHex(long l)
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
        HttpConnection.access$200(HttpConnection.this).c(hex, j, hex.length - j);
    }

    public void close()
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
        HttpConnection.access$200(HttpConnection.this).c(HttpConnection.access$400());
        HttpConnection.access$302(HttpConnection.this, 3);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public void flush()
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

    public s timeout()
    {
        return HttpConnection.access$200(HttpConnection.this).timeout();
    }

    public void write(d d, long l)
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
            HttpConnection.access$200(HttpConnection.this).write(d, l);
            HttpConnection.access$200(HttpConnection.this).b("\r\n");
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
