// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.Request;

// Referenced classes of package com.mopub.network:
//            MoPubRequestQueue

class val.tag
    implements com.mopub.volley.Filter
{

    final MoPubRequestQueue this$0;
    final Object val$tag;

    public boolean apply(Request request)
    {
        return request.getTag() == val$tag;
    }

    ilter()
    {
        this$0 = final_mopubrequestqueue;
        val$tag = Object.this;
        super();
    }
}
