// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.ads.a.d;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.facebook.ads.a.d:
//            a

final class a
    implements HttpRequestInterceptor
{

    final a a;

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = com.facebook.ads.a.d.a.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)com.facebook.ads.a.d.a.a(a).get(s)))
        {
            s = (String)httpcontext.next();
        }

    }

    HttpContext(a a1)
    {
        a = a1;
        super();
    }
}
