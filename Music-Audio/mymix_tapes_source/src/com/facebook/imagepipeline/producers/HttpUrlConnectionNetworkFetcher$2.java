// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.util.concurrent.Future;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            BaseProducerContextCallbacks, HttpUrlConnectionNetworkFetcher

class > extends BaseProducerContextCallbacks
{

    final HttpUrlConnectionNetworkFetcher this$0;
    final tion val$callback;
    final Future val$future;

    public void onCancellationRequested()
    {
        if (val$future.cancel(false))
        {
            val$callback.tion();
        }
    }

    ()
    {
        this$0 = final_httpurlconnectionnetworkfetcher;
        val$future = future1;
        val$callback = val.callback.this;
        super();
    }
}
