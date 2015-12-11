// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.net;


// Referenced classes of package com.amazon.mShop.net:
//            HttpFetcher, CallObserver

class val.result
    implements Runnable
{

    final HttpFetcher this$0;
    final Object val$result;

    public void run()
    {
        if (!isCancelled())
        {
            if (val$result == null)
            {
                HttpFetcher.access$000(HttpFetcher.this).getSubscriber().onHttpRequestFailed(HttpFetcher.access$000(HttpFetcher.this));
            } else
            {
                HttpFetcher.access$000(HttpFetcher.this).getSubscriber().onHttpResponseReceived(val$result, HttpFetcher.access$000(HttpFetcher.this));
            }
        }
        if (!mCallObserver.isFinished())
        {
            mCallObserver.onComplete();
        }
    }

    bscriber()
    {
        this$0 = final_httpfetcher;
        val$result = Object.this;
        super();
    }
}
