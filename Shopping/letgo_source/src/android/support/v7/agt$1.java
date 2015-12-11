// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package android.support.v7;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package android.support.v7:
//            agt

class a
    implements HttpRequestInterceptor
{

    final agt a;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = agt.a(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)agt.a(a).get(s)))
        {
            s = (String)httpcontext.next();
        }

    }

    HttpContext(agt agt1)
    {
        a = agt1;
        super();
    }
}
