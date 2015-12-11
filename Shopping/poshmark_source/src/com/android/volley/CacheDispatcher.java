// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.android.volley;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

// Referenced classes of package com.android.volley:
//            VolleyLog, Cache, Request, NetworkResponse, 
//            ResponseDelivery, Response

public class CacheDispatcher extends Thread
{

    private static final boolean DEBUG;
    private final Cache mCache;
    private final BlockingQueue mCacheQueue;
    private final ResponseDelivery mDelivery;
    private final BlockingQueue mNetworkQueue;
    private volatile boolean mQuit;

    public CacheDispatcher(BlockingQueue blockingqueue, BlockingQueue blockingqueue1, Cache cache, ResponseDelivery responsedelivery)
    {
        mQuit = false;
        mCacheQueue = blockingqueue;
        mNetworkQueue = blockingqueue1;
        mCache = cache;
        mDelivery = responsedelivery;
    }

    public void quit()
    {
        mQuit = true;
        interrupt();
    }

    public void run()
    {
        if (DEBUG)
        {
            VolleyLog.v("start new dispatcher", new Object[0]);
        }
        Process.setThreadPriority(10);
        mCache.initialize();
_L1:
        final Object finalRequest = (Request)mCacheQueue.take();
        ((Request) (finalRequest)).addMarker("cache-queue-take");
        if (!((Request) (finalRequest)).isCanceled())
        {
            break MISSING_BLOCK_LABEL_94;
        }
        ((Request) (finalRequest)).finish("cache-discard-canceled");
          goto _L1
        finalRequest;
        if (!mQuit) goto _L1; else goto _L2
_L2:
        return;
        Cache.Entry entry = mCache.get(((Request) (finalRequest)).getCacheKey());
label0:
        {
            if (entry != null)
            {
                break label0;
            }
            try
            {
                ((Request) (finalRequest)).addMarker("cache-miss");
                mNetworkQueue.put(finalRequest);
            }
            // Misplaced declaration of an exception variable
            catch (final Object finalRequest)
            {
                VolleyLog.e(((Throwable) (finalRequest)), "Unhandled exception %s", new Object[] {
                    ((Exception) (finalRequest)).toString()
                });
            }
        }
          goto _L1
label1:
        {
            if (!entry.isExpired())
            {
                break label1;
            }
            ((Request) (finalRequest)).addMarker("cache-hit-expired");
            ((Request) (finalRequest)).setCacheEntry(entry);
            mNetworkQueue.put(finalRequest);
        }
          goto _L1
        Response response;
label2:
        {
            ((Request) (finalRequest)).addMarker("cache-hit");
            response = ((Request) (finalRequest)).parseNetworkResponse(new NetworkResponse(entry.data, entry.responseHeaders));
            ((Request) (finalRequest)).addMarker("cache-hit-parsed");
            if (entry.refreshNeeded())
            {
                break label2;
            }
            mDelivery.postResponse(((Request) (finalRequest)), response);
        }
          goto _L1
        ((Request) (finalRequest)).addMarker("cache-hit-refresh-needed");
        ((Request) (finalRequest)).setCacheEntry(entry);
        response.intermediate = true;
        mDelivery.postResponse(((Request) (finalRequest)), response, new Runnable() {

            final CacheDispatcher this$0;
            final Request val$finalRequest;

            public void run()
            {
                try
                {
                    mNetworkQueue.put(finalRequest);
                    return;
                }
                catch (InterruptedException interruptedexception)
                {
                    return;
                }
            }

            
            {
                this$0 = CacheDispatcher.this;
                finalRequest = request;
                super();
            }
        });
          goto _L1
    }

    static 
    {
        DEBUG = VolleyLog.DEBUG;
    }

}
