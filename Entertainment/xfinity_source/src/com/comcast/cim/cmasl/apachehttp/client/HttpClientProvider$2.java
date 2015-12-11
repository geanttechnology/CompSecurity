// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.HttpException;
import com.comcast.cim.httpcomponentsandroid.HttpRequest;
import com.comcast.cim.httpcomponentsandroid.HttpRequestInterceptor;
import com.comcast.cim.httpcomponentsandroid.protocol.HttpContext;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.client:
//            HttpClientProvider

class this._cls0
    implements HttpRequestInterceptor
{

    final HttpClientProvider this$0;

    public void process(HttpRequest httprequest, HttpContext httpcontext)
        throws HttpException, IOException
    {
        httprequest.addHeader(HttpClientProvider.access$000(HttpClientProvider.this));
    }

    ()
    {
        this$0 = HttpClientProvider.this;
        super();
    }
}
