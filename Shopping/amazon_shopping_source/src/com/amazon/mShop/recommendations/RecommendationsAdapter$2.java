// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import com.amazon.mShop.control.recommendations.RecommendationsController;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsAdapter, RecommendationsActivity

class this._cls0
    implements Runnable
{

    final RecommendationsAdapter this$0;

    public void run()
    {
        String s = ((RecommendationsActivity)RecommendationsAdapter.access$100(RecommendationsAdapter.this)).constructUserUniqueInfo();
        RecommendationsController.getInstance().sendRecsRatingsForUser(s);
    }

    ntroller()
    {
        this$0 = RecommendationsAdapter.this;
        super();
    }
}
