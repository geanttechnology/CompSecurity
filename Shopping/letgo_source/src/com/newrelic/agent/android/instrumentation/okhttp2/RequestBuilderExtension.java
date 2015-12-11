// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.newrelic.agent.android.Agent;
import com.newrelic.agent.android.instrumentation.TransactionState;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.CacheControl;
import com.squareup.okhttp.Headers;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import java.net.URL;
import java.util.Locale;

public class RequestBuilderExtension extends com.squareup.okhttp.Request.Builder
{

    private static final AgentLog log = AgentLogManager.getAgentLog();
    private com.squareup.okhttp.Request.Builder impl;
    private TransactionState transactionState;

    public RequestBuilderExtension(com.squareup.okhttp.Request.Builder builder)
    {
        impl = builder;
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

    public com.squareup.okhttp.Request.Builder addHeader(String s, String s1)
    {
        return impl.addHeader(s, s1);
    }

    public Request build()
    {
        return impl.build();
    }

    public com.squareup.okhttp.Request.Builder cacheControl(CacheControl cachecontrol)
    {
        return impl.cacheControl(cachecontrol);
    }

    public com.squareup.okhttp.Request.Builder delete()
    {
        return impl.delete();
    }

    public com.squareup.okhttp.Request.Builder get()
    {
        return impl.get();
    }

    public com.squareup.okhttp.Request.Builder head()
    {
        return impl.head();
    }

    public com.squareup.okhttp.Request.Builder header(String s, String s1)
    {
        return impl.header(s, s1);
    }

    public com.squareup.okhttp.Request.Builder headers(Headers headers1)
    {
        return impl.headers(headers1);
    }

    public com.squareup.okhttp.Request.Builder method(String s, RequestBody requestbody)
    {
        return impl.method(s, requestbody);
    }

    public com.squareup.okhttp.Request.Builder patch(RequestBody requestbody)
    {
        return impl.patch(requestbody);
    }

    public com.squareup.okhttp.Request.Builder post(RequestBody requestbody)
    {
        return impl.post(requestbody);
    }

    public com.squareup.okhttp.Request.Builder put(RequestBody requestbody)
    {
        return impl.put(requestbody);
    }

    public com.squareup.okhttp.Request.Builder removeHeader(String s)
    {
        return impl.removeHeader(s);
    }

    public com.squareup.okhttp.Request.Builder tag(Object obj)
    {
        return impl.tag(obj);
    }

    public com.squareup.okhttp.Request.Builder url(String s)
    {
        return impl.url(s);
    }

    public com.squareup.okhttp.Request.Builder url(URL url1)
    {
        return impl.url(url1);
    }

}
