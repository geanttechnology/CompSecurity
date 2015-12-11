// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.product.pdp;

import android.view.View;
import android.widget.Button;
import com.target.ui.view.a;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.product.PdpCartwheelAndPromotionView;
import com.target.ui.view.product.PdpChokingHazardView;
import com.target.ui.view.product.PdpDvmView;
import com.target.ui.view.product.PdpFulfillmentView;
import com.target.ui.view.product.PdpHeaderView;
import com.target.ui.view.product.PdpOtherLayoutView;
import com.target.ui.view.product.PdpPhonePlanPricingView;
import com.target.ui.view.product.PdpPreOrderDateView;
import com.target.ui.view.product.PdpPriceInfoView;
import com.target.ui.view.product.PdpRecommendationsView;
import com.target.ui.view.product.PdpTitleView;
import com.target.ui.view.product.PdpVariationView;
import com.target.ui.view.product.ProductViewPager;

// Referenced classes of package com.target.ui.fragment.product.pdp:
//            ProductDetailsPageFragment

static class I extends a
{

    PdpCartwheelAndPromotionView cartwheelAndPromotionView;
    PdpChokingHazardView chokingHazardView;
    View contentContainer;
    PdpDvmView dvmView;
    TargetErrorView errorContainer;
    Button expressCheckoutButton;
    PdpFulfillmentView fulfillmentView;
    PdpHeaderView headerView;
    ProductViewPager imageViewPager;
    PdpOtherLayoutView otherLayouts;
    PdpPhonePlanPricingView phonePricingView;
    PdpPriceInfoView prdPriceGuestReviewView;
    PdpPreOrderDateView preOrderDateView;
    View progressContainer;
    PdpRecommendationsView recommendationsView;
    PdpTitleView titleView;
    PdpVariationView variationView;

    I(View view)
    {
        super(view);
    }
}
