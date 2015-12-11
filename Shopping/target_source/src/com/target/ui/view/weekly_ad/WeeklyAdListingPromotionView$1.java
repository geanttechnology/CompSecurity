// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.view.View;
import com.target.mothership.model.weeklyad.interfaces.WeeklyAdListingPromotion;

// Referenced classes of package com.target.ui.view.weekly_ad:
//            WeeklyAdListingPromotionView

class ingPromotion
    implements android.view.PromotionView._cls1
{

    final WeeklyAdListingPromotionView this$0;
    final WeeklyAdListingPromotion val$promo;

    public void onClick(View view)
    {
        if (WeeklyAdListingPromotionView.a(WeeklyAdListingPromotionView.this) != null)
        {
            WeeklyAdListingPromotionView.a(WeeklyAdListingPromotionView.this).a(val$promo);
        }
    }

    ingPromotion()
    {
        this$0 = final_weeklyadlistingpromotionview;
        val$promo = WeeklyAdListingPromotion.this;
        super();
    }
}
