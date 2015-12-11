// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley;

import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.android.volley:
//            CacheDispatcher, Request

class val.finalRequest
    implements Runnable
{

    final CacheDispatcher this$0;
    final Request val$finalRequest;

    public void run()
    {
        try
        {
            CacheDispatcher.access$000(CacheDispatcher.this).put(val$finalRequest);
            return;
        }
        catch (InterruptedException interruptedexception)
        {
            return;
        }
    }

    ()
    {
        this$0 = final_cachedispatcher;
        val$finalRequest = Request.this;
        super();
    }
}
