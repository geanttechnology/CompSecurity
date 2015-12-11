// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import org.apache.http.client.methods.HttpUriRequest;

// Referenced classes of package com.parse:
//            ParseApacheHttpClient

static final class val.apacheRequest
    implements Runnable
{

    final HttpUriRequest val$apacheRequest;

    public void run()
    {
        val$apacheRequest.abort();
    }

    pUriRequest(HttpUriRequest httpurirequest)
    {
        val$apacheRequest = httpurirequest;
        super();
    }
}
