// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.loopj.android.http;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpRequest;
import cz.msebera.android.httpclient.HttpRequestInterceptor;
import cz.msebera.android.httpclient.protocol.HttpContext;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

// Referenced classes of package com.loopj.android.http:
//            AsyncHttpClient, LogInterface

class this._cls0
    implements HttpRequestInterceptor
{

    final AsyncHttpClient this$0;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
    {
        if (!httprequest.containsHeader("Accept-Encoding"))
        {
            httprequest.addHeader("Accept-Encoding", "gzip");
        }
        String s;
        for (httpcontext = AsyncHttpClient.access$000(AsyncHttpClient.this).keySet().iterator(); httpcontext.hasNext(); httprequest.addHeader(s, (String)AsyncHttpClient.access$000(AsyncHttpClient.this).get(s)))
        {
            s = (String)httpcontext.next();
            if (httprequest.containsHeader(s))
            {
                Header header = httprequest.getFirstHeader(s);
                AsyncHttpClient.log.d("AsyncHttpClient", String.format("Headers were overwritten! (%s | %s) overwrites (%s | %s)", new Object[] {
                    s, AsyncHttpClient.access$000(AsyncHttpClient.this).get(s), header.getName(), header.getValue()
                }));
                httprequest.removeHeader(header);
            }
        }

    }

    tpContext()
    {
        this$0 = AsyncHttpClient.this;
        super();
    }
}
