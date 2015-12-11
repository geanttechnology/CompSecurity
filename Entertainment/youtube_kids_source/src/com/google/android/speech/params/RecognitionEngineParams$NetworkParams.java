// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.google.android.speech.params;

import com.google.android.speech.engine.RetryPolicy;
import dab;

// Referenced classes of package com.google.android.speech.params:
//            NetworkRequestProducerParams

public class mNetworkRequestProducerParams
{

    private final dab mFallbackConnectionFactory;
    private final NetworkRequestProducerParams mNetworkRequestProducerParams;
    private final dab mPrimaryConnectionFactory;
    private final RetryPolicy mRetryPolicy;

    public dab getFallbackConnectionFactory()
    {
        return mFallbackConnectionFactory;
    }

    public NetworkRequestProducerParams getNetworkRequestProducerParams()
    {
        return mNetworkRequestProducerParams;
    }

    public dab getPrimaryConnectionFactory()
    {
        return mPrimaryConnectionFactory;
    }

    public RetryPolicy getRetryPolicy()
    {
        return mRetryPolicy;
    }

    public (dab dab, dab dab1, RetryPolicy retrypolicy, NetworkRequestProducerParams networkrequestproducerparams)
    {
        mPrimaryConnectionFactory = dab;
        mFallbackConnectionFactory = dab1;
        mRetryPolicy = retrypolicy;
        mNetworkRequestProducerParams = networkrequestproducerparams;
    }
}
