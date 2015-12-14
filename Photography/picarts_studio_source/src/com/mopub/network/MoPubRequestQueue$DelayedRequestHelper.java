// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.network;

import android.os.Handler;
import com.mopub.volley.Request;
import java.util.Map;

// Referenced classes of package com.mopub.network:
//            MoPubRequestQueue

class _cls1.val.request
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

    _cls1.val.request(Request request, int i)
    {
        this(request, i, new Handler());
    }

    <init>(final Request request, int i, Handler handler)
    {
        this.this$0 = MoPubRequestQueue.this;
        super();
        mDelayMs = i;
        mHandler = handler;
        mDelayedRunnable = new Runnable() {

            final MoPubRequestQueue.DelayedRequestHelper this$1;
            final Request val$request;
            final MoPubRequestQueue val$this$0;

            public void run()
            {
                MoPubRequestQueue.access$000(MoPubRequestQueue.DelayedRequestHelper.this.this$0).remove(request);
                add(request);
            }

            
            {
                this$1 = MoPubRequestQueue.DelayedRequestHelper.this;
                this$0 = mopubrequestqueue;
                request = request1;
                super();
            }
        };
    }
}
