// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.volley.Cache;
import com.mopub.volley.Network;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.ResponseDelivery;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MoPubRequestQueue extends RequestQueue
{
    class DelayedRequestHelper
    {

        final int mDelayMs;
        final Runnable mDelayedRunnable;
        final Handler mHandler;
        final MoPubRequestQueue this$0;

        void cancel()
        {
            mHandler.removeCallbacks(mDelayedRunnable);
        }

        void start()
        {
            mHandler.postDelayed(mDelayedRunnable, mDelayMs);
        }

        DelayedRequestHelper(Request request, int i)
        {
            this(request, i, new Handler());
        }

        DelayedRequestHelper(Request request, int i, Handler handler)
        {
            this.this$0 = MoPubRequestQueue.this;
            super();
            mDelayMs = i;
            mHandler = handler;
            mDelayedRunnable = request. new _cls1();
        }
    }


    private static final int CAPACITY = 10;
    private final Map mDelayedRequests;

    MoPubRequestQueue(Cache cache, Network network)
    {
        super(cache, network);
        mDelayedRequests = new HashMap(10);
    }

    MoPubRequestQueue(Cache cache, Network network, int i)
    {
        super(cache, network, i);
        mDelayedRequests = new HashMap(10);
    }

    MoPubRequestQueue(Cache cache, Network network, int i, ResponseDelivery responsedelivery)
    {
        super(cache, network, i, responsedelivery);
        mDelayedRequests = new HashMap(10);
    }

    public void addDelayedRequest(Request request, int i)
    {
        Preconditions.checkNotNull(request);
        addDelayedRequest(request, new DelayedRequestHelper(request, i));
    }

    void addDelayedRequest(Request request, DelayedRequestHelper delayedrequesthelper)
    {
        Preconditions.checkNotNull(delayedrequesthelper);
        if (mDelayedRequests.containsKey(request))
        {
            cancel(request);
        }
        delayedrequesthelper.start();
        mDelayedRequests.put(request, delayedrequesthelper);
    }

    public void cancel(final Request request)
    {
        Preconditions.checkNotNull(request);
        cancelAll(new com.mopub.volley.RequestQueue.RequestFilter() {

            final MoPubRequestQueue this$0;
            final Request val$request;

            public boolean apply(Request request1)
            {
                return request == request1;
            }

            
            {
                this$0 = MoPubRequestQueue.this;
                request = request1;
                super();
            }
        });
    }

    public void cancelAll(com.mopub.volley.RequestQueue.RequestFilter requestfilter)
    {
        Preconditions.checkNotNull(requestfilter);
        super.cancelAll(requestfilter);
        Iterator iterator = mDelayedRequests.entrySet().iterator();
        do
        {
            if (!iterator.hasNext())
            {
                break;
            }
            java.util.Map.Entry entry = (java.util.Map.Entry)iterator.next();
            if (requestfilter.apply((Request)entry.getKey()))
            {
                ((Request)entry.getKey()).cancel();
                ((DelayedRequestHelper)entry.getValue()).cancel();
                iterator.remove();
            }
        } while (true);
    }

    public void cancelAll(final Object tag)
    {
        Preconditions.checkNotNull(tag);
        super.cancelAll(tag);
        cancelAll(new com.mopub.volley.RequestQueue.RequestFilter() {

            final MoPubRequestQueue this$0;
            final Object val$tag;

            public boolean apply(Request request)
            {
                return request.getTag() == tag;
            }

            
            {
                this$0 = MoPubRequestQueue.this;
                tag = obj;
                super();
            }
        });
    }

    Map getDelayedRequests()
    {
        return mDelayedRequests;
    }


    // Unreferenced inner class com/mopub/network/MoPubRequestQueue$DelayedRequestHelper$1

/* anonymous class */
    class DelayedRequestHelper._cls1
        implements Runnable
    {

        final DelayedRequestHelper this$1;
        final Request val$request;
        final MoPubRequestQueue val$this$0;

        public void run()
        {
            mDelayedRequests.remove(request);
            add(request);
        }

            
            {
                this$1 = final_delayedrequesthelper;
                this$0 = mopubrequestqueue;
                request = Request.this;
                super();
            }
    }

}
