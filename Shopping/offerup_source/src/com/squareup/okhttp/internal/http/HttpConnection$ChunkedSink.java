// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.squareup.okhttp.internal.http;

import d.aa;
import d.ac;
import d.f;
import d.i;

// Referenced classes of package com.squareup.okhttp.internal.http:
//            HttpConnection

final class <init>
    implements aa
{

    private boolean closed;
    final HttpConnection this$0;

    public final void close()
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
        HttpConnection.access$300(HttpConnection.this).b("0\r\n\r\n");
        HttpConnection.access$402(HttpConnection.this, 3);
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final void flush()
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
        HttpConnection.access$300(HttpConnection.this).flush();
        if (true) goto _L1; else goto _L3
_L3:
        Exception exception;
        exception;
        throw exception;
    }

    public final ac timeout()
    {
        return HttpConnection.access$300(HttpConnection.this).timeout();
    }

    public final void write(f f, long l)
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
            HttpConnection.access$300(HttpConnection.this).i(l);
            HttpConnection.access$300(HttpConnection.this).b("\r\n");
            HttpConnection.access$300(HttpConnection.this).write(f, l);
            HttpConnection.access$300(HttpConnection.this).b("\r\n");
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
