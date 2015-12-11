// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.parse;

import android.support.v7.ct;
import android.support.v7.cu;

// Referenced classes of package com.parse:
//            ParseRequest, ParseHttpClient, ProgressCallback, ParseHttpRequest

class k
    implements ct
{

    final ParseRequest this$0;
    final ParseHttpClient val$client;
    final ProgressCallback val$downloadProgressCallback;
    final ParseHttpRequest val$request;

    public cu then(cu cu)
        throws Exception
    {
        cu = val$client.execute(val$request);
        return onResponseAsync(cu, val$downloadProgressCallback);
    }

    public volatile Object then(cu cu)
        throws Exception
    {
        return then(cu);
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
