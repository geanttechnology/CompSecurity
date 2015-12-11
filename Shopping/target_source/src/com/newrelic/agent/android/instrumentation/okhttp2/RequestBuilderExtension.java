// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.h.b.d;
import com.h.b.p;
import com.h.b.u;
import com.h.b.v;
import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import java.net.URL;
import java.util.Locale;

public class RequestBuilderExtension extends com.h.b.u.a
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private com.h.b.u.a impl;
    private TransactionState transactionState;

    public RequestBuilderExtension(com.h.b.u.a a)
    {
        impl = a;
        setCrossProcessHeader();
    }

    private void setCrossProcessHeader()
    {
        String s = Agent.getCrossProcessId();
        if (s != null)
        {
            impl.addHeader("X-NewRelic-ID".toLowerCase(Locale.ENGLISH), s);
        }
    }

    public com.h.b.u.a addHeader(String s, String s1)
    {
        return impl.addHeader(s, s1);
    }

    public u build()
    {
        return impl.build();
    }

    public com.h.b.u.a cacheControl(d d)
    {
        return impl.cacheControl(d);
    }

    public com.h.b.u.a delete()
    {
        return impl.delete();
    }

    public com.h.b.u.a get()
    {
        return impl.get();
    }

    public com.h.b.u.a head()
    {
        return impl.head();
    }

    public com.h.b.u.a header(String s, String s1)
    {
        return impl.header(s, s1);
    }

    public com.h.b.u.a headers(p p)
    {
        return impl.headers(p);
    }

    public com.h.b.u.a method(String s, v v)
    {
        return impl.method(s, v);
    }

    public com.h.b.u.a patch(v v)
    {
        return impl.patch(v);
    }

    public com.h.b.u.a post(v v)
    {
        return impl.post(v);
    }

    public com.h.b.u.a put(v v)
    {
        return impl.put(v);
    }

    public com.h.b.u.a removeHeader(String s)
    {
        return impl.removeHeader(s);
    }

    public com.h.b.u.a tag(Object obj)
    {
        return impl.tag(obj);
    }

    public com.h.b.u.a url(String s)
    {
        return impl.url(s);
    }

    public com.h.b.u.a url(URL url1)
    {
        return impl.url(url1);
    }

}
