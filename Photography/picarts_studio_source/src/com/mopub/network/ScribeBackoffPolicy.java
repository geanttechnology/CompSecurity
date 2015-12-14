// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.NoConnectionError;
import com.mopub.volley.VolleyError;

// Referenced classes of package com.mopub.network:
//            BackoffPolicy

public class ScribeBackoffPolicy extends BackoffPolicy
{

    private static final int BACKOFF_MULTIPLIER = 2;
    private static final int DEFAULT_BACKOFF_TIME_MS = 60000;
    private static final int MAX_RETRIES = 5;

    public ScribeBackoffPolicy()
    {
        this(60000, 5, 2);
    }

    ScribeBackoffPolicy(int i, int j, int k)
    {
        mDefaultBackoffTimeMs = i;
        mMaxRetries = j;
        mBackoffMultiplier = k;
    }

    private void updateBackoffTime()
    {
        mBackoffMs = (int)(Math.pow(mBackoffMultiplier, mRetryCount) * (double)mDefaultBackoffTimeMs);
        mRetryCount = mRetryCount + 1;
    }

    public void backoff(VolleyError volleyerror)
    {
        if (!hasAttemptRemaining())
        {
            throw volleyerror;
        }
        if (volleyerror instanceof NoConnectionError)
        {
            updateBackoffTime();
            return;
        }
        NetworkResponse networkresponse = volleyerror.networkResponse;
        if (networkresponse != null && (networkresponse.statusCode == 503 || networkresponse.statusCode == 504))
        {
            updateBackoffTime();
            return;
        } else
        {
            throw volleyerror;
        }
    }
}
