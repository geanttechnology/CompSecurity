// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.shop;

import android.view.View;
import com.target.ui.view.common.TargetErrorView;

// Referenced classes of package com.target.ui.view.shop:
//            DealsCategoryHeaderView, DealsNoStoreView, WeeklyAdView

public class 
    implements butterknife..ViewBinder
{

    public void bind(butterknife..ViewBinder viewbinder,  , Object obj)
    {
        .Header = (DealsCategoryHeaderView)viewbinder.w((View)viewbinder.w(obj, 0x7f100435, "field 'productErrorHeader'"), 0x7f100435, "field 'productErrorHeader'");
        .Header = (DealsNoStoreView)viewbinder.noStoreView((View)viewbinder.w(obj, 0x7f100432, "field 'noStoreView'"), 0x7f100432, "field 'noStoreView'");
        .View = (TargetErrorView)viewbinder.productErrorView((View)viewbinder.w(obj, 0x7f100436, "field 'productErrorView'"), 0x7f100436, "field 'productErrorView'");
        . = (WeeklyAdView)viewbinder.weeklyAdView((View)viewbinder.w(obj, 0x7f100431, "field 'weeklyAdView'"), 0x7f100431, "field 'weeklyAdView'");
        .ton = (View)viewbinder.w(obj, 0x7f100433, "field 'cartwheelButton'");
        .sButton = (View)viewbinder.w(obj, 0x7f100434, "field 'mobileCouponsButton'");
    }

    public volatile void bind(butterknife..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.Header = null;
        bind1.Header = null;
        bind1.View = null;
        bind1. = null;
        bind1.ton = null;
        bind1.sButton = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
