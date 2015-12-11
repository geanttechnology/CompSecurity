// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.StarRatingView;

// Referenced classes of package com.target.ui.view.product:
//            ProductPriceView, ProductEyebrowView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        . = (ProductPriceView)viewbinder.priceBlock((View)viewbinder.(obj, 0x7f100526, "field 'priceBlock'"), 0x7f100526, "field 'priceBlock'");
        . = (ProductEyebrowView)viewbinder.eyebrow((View)viewbinder.(obj, 0x7f100527, "field 'eyebrow'"), 0x7f100527, "field 'eyebrow'");
        .iewContainer = (View)viewbinder.(obj, 0x7f100528, "field 'guestRatingViewContainer'");
        .iewContainer = (StarRatingView)viewbinder.guestRating((View)viewbinder.(obj, 0x7f100529, "field 'guestRating'"), 0x7f100529, "field 'guestRating'");
        .ount = (TextView)viewbinder.guestRatingCount((View)viewbinder.(obj, 0x7f10052a, "field 'guestRatingCount'"), 0x7f10052a, "field 'guestRatingCount'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.iewContainer = null;
        bind1.iewContainer = null;
        bind1.ount = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
