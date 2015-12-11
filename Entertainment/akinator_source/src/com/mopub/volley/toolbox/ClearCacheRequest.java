// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;

public class ClearCacheRequest extends Request
{

    private final Cache mCache;
    private final Runnable mCallback;

    public ClearCacheRequest(Cache cache, Runnable runnable)
    {
        super(0, null, null);
        mCache = cache;
        mCallback = runnable;
    }

    protected void deliverResponse(Object obj)
    {
    }

    public com.mopub.volley.Request.Priority getPriority()
    {
        return com.mopub.volley.Request.Priority.IMMEDIATE;
    }

    public boolean isCanceled()
    {
        mCache.clear();
        if (mCallback != null)
        {
            (new Handler(Looper.getMainLooper())).postAtFrontOfQueue(mCallback);
        }
        return true;
    }

    protected Response parseNetworkResponse(NetworkResponse networkresponse)
    {
        return null;
    }
}
