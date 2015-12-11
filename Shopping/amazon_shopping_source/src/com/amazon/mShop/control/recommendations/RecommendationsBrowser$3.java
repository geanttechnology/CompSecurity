// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;


// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsBrowser, RecommendationsSubscriber

class val.value
    implements Runnable
{

    final RecommendationsBrowser this$0;
    final String val$value;

    public void run()
    {
        getRecSubscriber().onReceivedNoRecommendationsExplanation(val$value);
    }

    ()
    {
        this$0 = final_recommendationsbrowser;
        val$value = String.this;
        super();
    }
}
