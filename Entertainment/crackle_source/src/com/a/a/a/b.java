// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.a.a.a;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package com.a.a.a:
//            a

class b
    implements HttpRequestInterceptor
{

    final a a;

    b(a a1)
    {
        a = a1;
        super();
    }

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        httpcontext = com.a.a.a.a.a(a).keySet().iterator();
        do
        {
            if (!httpcontext.hasNext())
            {
                return;
            }
            String s = (String)httpcontext.next();
            httprequest.addHeader(s, (String)com.a.a.a.a.a(a).get(s));
        } while (true);
    }
}
