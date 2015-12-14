// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.Request;

// Referenced classes of package com.mopub.network:
//            MoPubRequestQueue

class val.request
    implements com.mopub.volley.Filter
{

    final MoPubRequestQueue this$0;
    final Request val$request;

    public boolean apply(Request request1)
    {
        return val$request == request1;
    }

    ilter()
    {
        this$0 = final_mopubrequestqueue;
        val$request = Request.this;
        super();
    }
}
