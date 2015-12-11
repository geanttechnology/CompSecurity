// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.control.recommendations;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

// Referenced classes of package com.amazon.mShop.control.recommendations:
//            RecommendationsController, RecommendationsRatingSubscriber

class this._cls0
    implements Runnable
{

    final RecommendationsController this$0;

    public void run()
    {
        RecommendationsController.access$002(RecommendationsController.this, false);
        for (Iterator iterator = (new ArrayList(RecommendationsController.access$200(RecommendationsController.this))).iterator(); iterator.hasNext(); ((RecommendationsRatingSubscriber)iterator.next()).onRecsRatingCallCompleted()) { }
    }

    ber()
    {
        this$0 = RecommendationsController.this;
        super();
    }
}
