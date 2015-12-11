// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import a.i;
import a.j;
import com.parse.http.ParseHttpRequest;

// Referenced classes of package com.parse:
//            ParseRequest, ParseHttpClient, ProgressCallback

class k
    implements i
{

    final ParseRequest this$0;
    final ParseHttpClient val$client;
    final ProgressCallback val$downloadProgressCallback;
    final ParseHttpRequest val$request;

    public j then(j j)
        throws Exception
    {
        j = val$client.execute(val$request);
        return onResponseAsync(j, val$downloadProgressCallback);
    }

    public volatile Object then(j j)
        throws Exception
    {
        return then(j);
    }

    k()
    {
        this$0 = final_parserequest;
        val$client = parsehttpclient;
        val$request = parsehttprequest;
        val$downloadProgressCallback = ProgressCallback.this;
        super();
    }
}
