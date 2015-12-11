// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.newrelic.agent.android.instrumentation.okhttp2;

import com.h.b.e;
import com.h.b.s;
import com.h.b.u;
import com.h.b.x;
import com.newrelic.agent.android.instrumentation.HttpURLConnectionExtension;
import com.newrelic.agent.android.logging.AgentLog;
import com.newrelic.agent.android.logging.AgentLogManager;
import com.squareup.okhttp.OkUrlFactory;
import java.net.HttpURLConnection;
import java.net.URL;

// Referenced classes of package com.newrelic.agent.android.instrumentation.okhttp2:
//            ResponseBuilderExtension, RequestBuilderExtension, CallExtension

public class OkHttp2Instrumentation
{

    private static final AgentLog log = AgentLogManager.getAgentLog();

    private OkHttp2Instrumentation()
    {
    }

    public static com.h.b.w.a body(com.h.b.w.a a, x x)
    {
        return (new ResponseBuilderExtension(a)).body(x);
    }

    public static u build(com.h.b.u.a a)
    {
        return (new RequestBuilderExtension(a)).build();
    }

    public static com.h.b.w.a newBuilder(com.h.b.w.a a)
    {
        return new ResponseBuilderExtension(a);
    }

    public static e newCall(s s1, u u)
    {
        return new CallExtension(s1, u, s1.a(u));
    }

    public static HttpURLConnection open(OkUrlFactory okurlfactory, URL url)
    {
        return new HttpURLConnectionExtension(okurlfactory.open(url));
    }

}
