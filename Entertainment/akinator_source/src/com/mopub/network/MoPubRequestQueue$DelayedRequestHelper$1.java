// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.Request;
import java.util.Map;

// Referenced classes of package com.mopub.network:
//            MoPubRequestQueue

class val.request
    implements Runnable
{

    final val.request this$1;
    final Request val$request;
    final MoPubRequestQueue val$this$0;

    public void run()
    {
        MoPubRequestQueue.access$000(_fld0).remove(val$request);
        add(val$request);
    }

    ()
    {
        this$1 = final_;
        val$this$0 = mopubrequestqueue;
        val$request = Request.this;
        super();
    }
}
