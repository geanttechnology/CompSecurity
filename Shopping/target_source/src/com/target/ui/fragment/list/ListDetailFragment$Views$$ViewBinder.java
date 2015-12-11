// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.list;

import android.view.View;
import com.target.ui.view.common.TargetErrorView;
import com.target.ui.view.list.ListDetailView;
import com.target.ui.view.list.PromotionsCarouselView;

public class 
    implements butterknife.ews..ViewBinder
{

    public void bind(butterknife.ews..ViewBinder viewbinder,  , Object obj)
    {
        .ew = (ListDetailView)viewbinder.listDetailView((View)viewbinder.listDetailView(obj, 0x7f100186, "field 'listDetailView'"), 0x7f100186, "field 'listDetailView'");
        .rouselView = (PromotionsCarouselView)viewbinder.promotionsCarouselView((View)viewbinder.promotionsCarouselView(obj, 0x7f100185, "field 'promotionsCarouselView'"), 0x7f100185, "field 'promotionsCarouselView'");
        .rouselView = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f100172, "field 'errorView'"), 0x7f100172, "field 'errorView'");
    }

    public volatile void bind(butterknife.ews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.ew = null;
        bind1.rouselView = null;
        bind1.rouselView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
