// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.localytics.android;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Callable;

// Referenced classes of package com.localytics.android:
//            MarketingRulesAdapter, MarketingHandler, MarketingMessage

class this._cls0
    implements Callable
{

    final MarketingRulesAdapter this$0;

    public Boolean call()
    {
        boolean flag = false;
        for (Iterator iterator = MarketingRulesAdapter.access$000(MarketingRulesAdapter.this).getMarketingMessages().iterator(); iterator.hasNext();)
        {
            MarketingMessage marketingmessage = (MarketingMessage)iterator.next();
            MarketingRulesAdapter.access$100(MarketingRulesAdapter.this).add(marketingmessage);
            flag = true;
        }

        return Boolean.valueOf(flag);
    }

    public volatile Object call()
    {
        return call();
    }

    ()
    {
        this$0 = MarketingRulesAdapter.this;
        super();
    }
}
