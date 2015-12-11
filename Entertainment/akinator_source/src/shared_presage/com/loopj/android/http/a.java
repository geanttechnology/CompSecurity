// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package shared_presage.com.loopj.android.http;

import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import org.apache.http.HttpRequest;
import org.apache.http.HttpRequestInterceptor;
import org.apache.http.protocol.HttpContext;

// Referenced classes of package shared_presage.com.loopj.android.http:
//            AsyncHttpClient

final class a
    implements HttpRequestInterceptor
{

    final AsyncHttpClient a;

    a(AsyncHttpClient asynchttpclient)
    {
        a = asynchttpclient;
        super();
    }

    public final void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = AsyncHttpClient.access$000(a).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)AsyncHttpClient.access$000(a).get(s)))
        {
            s = (String)httpcontext.next();
        }

    }
}
