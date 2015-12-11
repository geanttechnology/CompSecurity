// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.comcast.cim.cmasl.apachehttp.client;

import com.comcast.cim.httpcomponentsandroid.HttpResponse;
import com.comcast.cim.httpcomponentsandroid.client.HttpClient;
import com.comcast.cim.httpcomponentsandroid.client.methods.HttpUriRequest;
import java.io.IOException;

// Referenced classes of package com.comcast.cim.cmasl.apachehttp.client:
//            RetryingHttpClient

class equest
    implements sponseProvider
{

    final RetryingHttpClient this$0;
    final HttpUriRequest val$request;

    public HttpResponse executeRequest()
        throws IOException
    {
        return RetryingHttpClient.access$000(RetryingHttpClient.this).execute(val$request);
    }

    equest()
    {
        this$0 = final_retryinghttpclient;
        val$request = HttpUriRequest.this;
        super();
    }
}
