// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.baidu.autoupdatesdk.obf;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.baidu.autoupdatesdk.obf:
//            m

class a
    implements HttpRequestInterceptor
{

    final m a;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = m.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)m.a(a).get(s)))
        {
            s = (String)httpcontext.next();
        }

    }

    text(m m1)
    {
        a = m1;
        super();
    }
}
