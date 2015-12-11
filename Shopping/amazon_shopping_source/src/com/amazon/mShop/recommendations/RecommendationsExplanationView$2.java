// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.mShop.recommendations;

import android.view.View;
import com.amazon.mShop.AmazonActivity;

// Referenced classes of package com.amazon.mShop.recommendations:
//            RecommendationsExplanationView

class val.activity
    implements android.view.nsExplanationView._cls2
{

    final RecommendationsExplanationView this$0;
    final AmazonActivity val$activity;

    public void onClick(View view)
    {
        val$activity.authenticateUser(RecommendationsExplanationView.this, null, true);
    }

    ()
    {
        this$0 = final_recommendationsexplanationview;
        val$activity = AmazonActivity.this;
        super();
    }
}
