// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import c.c;
import c.e;
import com.h.b.o;
import com.h.b.p;
import com.h.b.t;
import com.h.b.u;
import com.h.b.w;
import com.h.b.x;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.io.IOException;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            PrebufferedResponseBody

public class ResponseBuilderExtension extends com.h.b.w.a
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private com.h.b.w.a impl;

    public ResponseBuilderExtension(com.h.b.w.a a)
    {
        impl = a;
    }

    public com.h.b.w.a addHeader(String s, String s1)
    {
        return impl.addHeader(s, s1);
    }

    public com.h.b.w.a body(x x1)
    {
        e e1 = x1.source();
        c c1 = new c();
        try
        {
            e1.a(c1);
        }
        catch (IOException ioexception)
        {
            log.error("IOException reading from source: ", ioexception);
        }
        return impl.body(new PrebufferedResponseBody(x1, c1));
    }

    public w build()
    {
        return impl.build();
    }

    public com.h.b.w.a cacheResponse(w w)
    {
        return impl.cacheResponse(w);
    }

    public com.h.b.w.a code(int i)
    {
        return impl.code(i);
    }

    public com.h.b.w.a handshake(o o)
    {
        return impl.handshake(o);
    }

    public com.h.b.w.a header(String s, String s1)
    {
        return impl.header(s, s1);
    }

    public com.h.b.w.a headers(p p)
    {
        return impl.headers(p);
    }

    public com.h.b.w.a message(String s)
    {
        return impl.message(s);
    }

    public com.h.b.w.a networkResponse(w w)
    {
        return impl.networkResponse(w);
    }

    public com.h.b.w.a priorResponse(w w)
    {
        return impl.priorResponse(w);
    }

    public com.h.b.w.a protocol(t t)
    {
        return impl.protocol(t);
    }

    public com.h.b.w.a removeHeader(String s)
    {
        return impl.removeHeader(s);
    }

    public com.h.b.w.a request(u u)
    {
        return impl.request(u);
    }

}
