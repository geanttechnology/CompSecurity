// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import android.os.Handler;
import android.os.Looper;

// Referenced classes of package com.localytics.android:
//            MarketingHandler, MarketingRulesAdapter

class er extends Thread
{

    final MarketingHandler this$0;
    final MarketingRulesAdapter val$adapter;

    public void run()
    {
        class _cls1
            implements Runnable
        {

            final MarketingHandler._cls6 this$1;

            public void run()
            {
                adapter.updateDataSet();
                adapter.notifyDataSetChanged();
            }

            _cls1()
            {
                this$1 = MarketingHandler._cls6.this;
                super();
            }
        }

        (new Handler(Looper.getMainLooper())).post(new _cls1());
    }

    er()
    {
        this$0 = final_marketinghandler;
        val$adapter = MarketingRulesAdapter.this;
        super();
    }
}
