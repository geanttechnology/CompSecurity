// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import com.target.ui.view.common.TargetErrorCardView;

// Referenced classes of package com.target.ui.view.product:
//            PdpHeaderView, ProductViewPager, PdpTitleView, PdpFulfillmentView, 
//            PdpCartwheelAndPromotionView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (PdpHeaderView)viewbinder.headerView((View)viewbinder.headerView(obj, 0x7f100408, "field 'headerView'"), 0x7f100408, "field 'headerView'");
        .er = (ProductViewPager)viewbinder.imageViewPager((View)viewbinder.imageViewPager(obj, 0x7f100409, "field 'imageViewPager'"), 0x7f100409, "field 'imageViewPager'");
        .er = (PdpTitleView)viewbinder.titleView((View)viewbinder.titleView(obj, 0x7f10040a, "field 'titleView'"), 0x7f10040a, "field 'titleView'");
        .iew = (PdpFulfillmentView)viewbinder.fulfillmentView((View)viewbinder.fulfillmentView(obj, 0x7f10040d, "field 'fulfillmentView'"), 0x7f10040d, "field 'fulfillmentView'");
        .PromotionView = (PdpCartwheelAndPromotionView)viewbinder.cartwheelAndPromotionView((View)viewbinder.cartwheelAndPromotionView(obj, 0x7f10040e, "field 'cartwheelAndPromotionView'"), 0x7f10040e, "field 'cartwheelAndPromotionView'");
        .ainer = (View)viewbinder.progressContainer(obj, 0x7f10040b, "field 'progressContainer'");
        .er = (TargetErrorCardView)viewbinder.errorContainer((View)viewbinder.errorContainer(obj, 0x7f10040c, "field 'errorContainer'"), 0x7f10040c, "field 'errorContainer'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.er = null;
        bind1.er = null;
        bind1.iew = null;
        bind1.PromotionView = null;
        bind1.ainer = null;
        bind1.er = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
