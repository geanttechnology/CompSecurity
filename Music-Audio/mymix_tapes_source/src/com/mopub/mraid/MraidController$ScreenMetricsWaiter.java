// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.mraid:
//            MraidController

static class WaitRequest
{
    static class WaitRequest
    {

        private final Handler mHandler;
        private Runnable mSuccessRunnable;
        private final View mViews[];
        int mWaitCount;
        private final Runnable mWaitingRunnable;

        private void countDown()
        {
            mWaitCount = mWaitCount - 1;
            if (mWaitCount == 0 && mSuccessRunnable != null)
            {
                mSuccessRunnable.run();
                mSuccessRunnable = null;
            }
        }

        void cancel()
        {
            mHandler.removeCallbacks(mWaitingRunnable);
            mSuccessRunnable = null;
        }

        void start(Runnable runnable)
        {
            mSuccessRunnable = runnable;
            mWaitCount = mViews.length;
            mHandler.post(mWaitingRunnable);
        }



        private WaitRequest(Handler handler, View aview[])
        {
            mWaitingRunnable = new _cls1();
            mHandler = handler;
            mViews = aview;
        }

        WaitRequest(Handler handler, View aview[], MraidController._cls1 _pcls1)
        {
            this(handler, aview);
        }
    }


    private final Handler mHandler = new Handler();
    private WaitRequest mLastWaitRequest;

    void cancelLastRequest()
    {
        if (mLastWaitRequest != null)
        {
            mLastWaitRequest.cancel();
            mLastWaitRequest = null;
        }
    }

    transient WaitRequest waitFor(View aview[])
    {
        mLastWaitRequest = new WaitRequest(mHandler, aview, null);
        return mLastWaitRequest;
    }

    WaitRequest()
    {
    }

    // Unreferenced inner class com/mopub/mraid/MraidController$ScreenMetricsWaiter$WaitRequest$1

/* anonymous class */
    class WaitRequest._cls1
        implements Runnable
    {

        final WaitRequest this$0;

        public void run()
        {
            View aview[] = mViews;
            int j = aview.length;
            int i = 0;
            while (i < j) 
            {
                View view = aview[i];
                if (view.getHeight() > 0 || view.getWidth() > 0)
                {
                    countDown();
                } else
                {
                    view.getViewTreeObserver().addOnPreDrawListener(view. new android.view.ViewTreeObserver.OnPreDrawListener() {

                        final WaitRequest._cls1 this$1;
                        final View val$view;

                        public boolean onPreDraw()
                        {
                            view.getViewTreeObserver().removeOnPreDrawListener(this);
    class WaitRequest._cls1
        implements Runnable
    {
                            countDown();
                            return true;
                        }

            
            {
                this$1 = final__pcls1;
                view = View.this;
                super();
            }
                    });
                }
                i++;
            }
        }

            
            {
                this$0 = WaitRequest.this;
                super();
            }
    }

}
