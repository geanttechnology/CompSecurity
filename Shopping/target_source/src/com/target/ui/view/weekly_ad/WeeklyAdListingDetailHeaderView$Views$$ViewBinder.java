// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.common.TargetErrorCardView;
import com.target.ui.view.product.PdpFulfillmentView;
import com.target.ui.view.product.PdpTitleView;
import com.target.ui.view.product.ProductViewPager;

// Referenced classes of package com.target.ui.view.weekly_ad:
//            WeeklyAdListingPromotionView

public class 
    implements butterknife.iews..ViewBinder
{

    public void bind(butterknife.iews..ViewBinder viewbinder,  , Object obj)
    {
        .er = (ProductViewPager)viewbinder.imageViewPager((View)viewbinder.imageViewPager(obj, 0x7f1000cc, "field 'imageViewPager'"), 0x7f1000cc, "field 'imageViewPager'");
        .er = (PdpTitleView)viewbinder.titleView((View)viewbinder.titleView(obj, 0x7f1000cd, "field 'titleView'"), 0x7f1000cd, "field 'titleView'");
        .iew = (PdpFulfillmentView)viewbinder.fulfillmentView((View)viewbinder.fulfillmentView(obj, 0x7f1000c2, "field 'fulfillmentView'"), 0x7f1000c2, "field 'fulfillmentView'");
        .w = (WeeklyAdListingPromotionView)viewbinder.promotionView((View)viewbinder.promotionView(obj, 0x7f1005ed, "field 'promotionView'"), 0x7f1005ed, "field 'promotionView'");
        .lsView = (View)viewbinder.productDetailsView(obj, 0x7f1005ec, "field 'productDetailsView'");
        . = (View)viewbinder.progressView(obj, 0x7f1005ea, "field 'progressView'");
        .ls = (TextView)viewbinder.productDetails((View)viewbinder.productDetails(obj, 0x7f1004d4, "field 'productDetails'"), 0x7f1004d4, "field 'productDetails'");
        .ls = (TargetErrorCardView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f1005eb, "field 'errorView'"), 0x7f1005eb, "field 'errorView'");
    }

    public volatile void bind(butterknife.iews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.er = null;
        bind1.er = null;
        bind1.iew = null;
        bind1.w = null;
        bind1.lsView = null;
        bind1. = null;
        bind1.ls = null;
        bind1.ls = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
