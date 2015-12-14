// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.insights.impl;

import com.amazon.insights.ABTestClient;
import com.amazon.insights.InsightsCallback;
import com.amazon.insights.InsightsHandler;
import com.amazon.insights.error.InsightsError;

// Referenced classes of package com.amazon.insights.impl:
//            DisabledAmazonInsights

class this._cls0
    implements ABTestClient
{

    final DisabledAmazonInsights this$0;

    public transient InsightsHandler getVariations(String as[])
    {
        return new InsightsHandler() {

            final DisabledAmazonInsights._cls1 this$1;

            public void setCallback(InsightsCallback insightscallback)
            {
                insightscallback.onError(new InsightsError() {

                    final _cls1 this$2;

                    public String getMessage()
                    {
                        return "The Amazon Insights SDK was not initialized";
                    }

            
            {
                this$2 = _cls1.this;
                super();
            }
                });
            }

            
            {
                this$1 = DisabledAmazonInsights._cls1.this;
                super();
            }
        };
    }

    _cls1.this._cls1()
    {
        this$0 = DisabledAmazonInsights.this;
        super();
    }
}
