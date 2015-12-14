// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.facebook.imagepipeline.producers;

import java.util.Map;

// Referenced classes of package com.facebook.imagepipeline.producers:
//            NetworkFetcher, FetchState

public abstract class BaseNetworkFetcher
    implements NetworkFetcher
{

    public BaseNetworkFetcher()
    {
    }

    public Map getExtraMap(FetchState fetchstate, int i)
    {
        return null;
    }

    public void onFetchCompletion(FetchState fetchstate, int i)
    {
    }

    public boolean shouldPropagate(FetchState fetchstate)
    {
        return true;
    }
}
