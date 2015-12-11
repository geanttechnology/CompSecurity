// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.HttpHost;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.client:
//            RetryingHttpClient

class val.context
    implements sponseProvider
{

    final RetryingHttpClient this$0;
    final HttpContext val$context;
    final HttpRequest val$request;
    final HttpHost val$target;

    public HttpResponse executeRequest()
        throws IOException
    {
        return RetryingHttpClient.access$000(RetryingHttpClient.this).execute(val$target, val$request, val$context);
    }

    sponseProvider()
    {
        this$0 = final_retryinghttpclient;
        val$target = httphost;
        val$request = httprequest;
        val$context = HttpContext.this;
        super();
    }
}
