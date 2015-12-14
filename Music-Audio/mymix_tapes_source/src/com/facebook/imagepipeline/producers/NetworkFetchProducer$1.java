// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.io.IOException;
import java.io.InputStream;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            NetworkFetchProducer, FetchState

class val.fetchState
    implements 
{

    final NetworkFetchProducer this$0;
    final FetchState val$fetchState;

    public void onCancellation()
    {
        NetworkFetchProducer.access$200(NetworkFetchProducer.this, val$fetchState);
    }

    public void onFailure(Throwable throwable)
    {
        NetworkFetchProducer.access$100(NetworkFetchProducer.this, val$fetchState, throwable);
    }

    public void onResponse(InputStream inputstream, int i)
        throws IOException
    {
        NetworkFetchProducer.access$000(NetworkFetchProducer.this, val$fetchState, inputstream, i);
    }

    ()
    {
        this$0 = final_networkfetchproducer;
        val$fetchState = FetchState.this;
        super();
    }
}
