// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.os.Handler;
import android.os.Looper;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.volley.Request;

// Referenced classes of package com.mopub.network:
//            Networking, MoPubRequestQueue, BackoffPolicy

public abstract class RequestManager
{

    protected BackoffPolicy mBackoffPolicy;
    protected Request mCurrentRequest;
    protected Handler mHandler;
    protected RequestFactory mRequestFactory;

    public RequestManager(Looper looper)
    {
        mHandler = new Handler(looper);
    }

    public void cancelRequest()
    {
        MoPubRequestQueue mopubrequestqueue = Networking.getRequestQueue();
        if (mopubrequestqueue != null && mCurrentRequest != null)
        {
            mopubrequestqueue.cancel(mCurrentRequest);
        }
        clearRequest();
    }

    void clearRequest()
    {
        mCurrentRequest = null;
        mRequestFactory = null;
        mBackoffPolicy = null;
    }

    abstract Request createRequest();

    Request getCurrentRequest()
    {
        return mCurrentRequest;
    }

    public boolean isAtCapacity()
    {
        return mCurrentRequest != null;
    }

    public void makeRequest(RequestFactory requestfactory, BackoffPolicy backoffpolicy)
    {
        Preconditions.checkNotNull(requestfactory);
        Preconditions.checkNotNull(backoffpolicy);
        cancelRequest();
        mRequestFactory = requestfactory;
        mBackoffPolicy = backoffpolicy;
        makeRequestInternal();
    }

    void makeRequestInternal()
    {
        mCurrentRequest = createRequest();
        MoPubRequestQueue mopubrequestqueue = Networking.getRequestQueue();
        if (mopubrequestqueue == null)
        {
            MoPubLog.d("MoPubRequest queue is null. Clearing request.");
            clearRequest();
            return;
        }
        if (mBackoffPolicy.getRetryCount() == 0)
        {
            mopubrequestqueue.add(mCurrentRequest);
            return;
        } else
        {
            mopubrequestqueue.addDelayedRequest(mCurrentRequest, mBackoffPolicy.getBackoffMs());
            return;
        }
    }
}
