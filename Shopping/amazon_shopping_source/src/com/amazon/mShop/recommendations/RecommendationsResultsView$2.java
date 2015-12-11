// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import com.amazon.mShop.control.recommendations.RecommendationsController;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsResultsView, RecommendationsActivity

class this._cls0
    implements com.amazon.mShop.error.ActionListener
{

    final RecommendationsResultsView this$0;

    public void onActionButtonClick(int i)
    {
        String s = ((RecommendationsActivity)RecommendationsResultsView.access$200(RecommendationsResultsView.this)).constructUserUniqueInfo();
        RecommendationsController.getInstance().eraseRatingRequestErrorInfo(s);
        RecommendationsResultsView.access$300(RecommendationsResultsView.this);
    }

    ller()
    {
        this$0 = RecommendationsResultsView.this;
        super();
    }
}
