// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            Consumer, ProducerContext, FetchState

public interface NetworkFetcher
{
    public static interface Callback
    {

        public abstract void onCancellation();

        public abstract void onFailure(Throwable throwable);

        public abstract void onResponse(InputStream inputstream, int i)
            throws IOException;
    }


    public abstract FetchState createFetchState(Consumer consumer, ProducerContext producercontext);

    public abstract void fetch(FetchState fetchstate, Callback callback);

    public abstract Map getExtraMap(FetchState fetchstate, int i);

    public abstract void onFetchCompletion(FetchState fetchstate, int i);

    public abstract boolean shouldPropagate(FetchState fetchstate);
}
