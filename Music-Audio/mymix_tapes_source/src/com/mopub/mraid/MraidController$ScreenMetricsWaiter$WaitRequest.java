// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.mopub.mraid;

import android.os.Handler;
import android.view.View;
import android.view.ViewTreeObserver;

// Referenced classes of package com.mopub.mraid:
//            MraidController

static class <init>
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



    private _cls1.this._cls0(Handler handler, View aview[])
    {
        mWaitingRunnable = new Runnable() {

            final MraidController.ScreenMetricsWaiter.WaitRequest this$0;

            public void run()
            {
                View aview1[] = mViews;
                int j = aview1.length;
                int i = 0;
                while (i < j) 
                {
                    View view = aview1[i];
                    if (view.getHeight() > 0 || view.getWidth() > 0)
                    {
                        countDown();
                    } else
                    {
                        view.getViewTreeObserver().addOnPreDrawListener(view. new android.view.ViewTreeObserver.OnPreDrawListener() {

                            final _cls1 this$1;
                            final View val$view;

                            public boolean onPreDraw()
                            {
                                view.getViewTreeObserver().removeOnPreDrawListener(this);
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
                this$0 = MraidController.ScreenMetricsWaiter.WaitRequest.this;
                super();
            }
        };
        mHandler = handler;
        mViews = aview;
    }

    mViews(Handler handler, View aview[], mViews mviews)
    {
        this(handler, aview);
    }
}
