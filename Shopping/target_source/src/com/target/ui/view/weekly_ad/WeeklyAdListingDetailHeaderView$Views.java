// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorCardView;
import com.target.ui.view.product.PdpFulfillmentView;
import com.target.ui.view.product.PdpTitleView;
import com.target.ui.view.product.ProductViewPager;

// Referenced classes of package com.target.ui.view.weekly_ad:
//            WeeklyAdListingDetailHeaderView, WeeklyAdListingPromotionView

static class  extends a
{

    TargetErrorCardView errorView;
    PdpFulfillmentView fulfillmentView;
    ProductViewPager imageViewPager;
    TextView productDetails;
    View productDetailsView;
    View progressView;
    WeeklyAdListingPromotionView promotionView;
    PdpTitleView titleView;

    (View view)
    {
        super(view);
    }
}
