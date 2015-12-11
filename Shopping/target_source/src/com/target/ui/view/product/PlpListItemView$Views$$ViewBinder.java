// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.product;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.AisleBadgeView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.StarRatingView;

// Referenced classes of package com.target.ui.view.product:
//            ProductPriceView, ProductEyebrowView, PlpFulfillmentView, PlpFulfillmentOverflowView

public class 
    implements butterknife.ws..ViewBinder
{

    public void bind(butterknife.ws..ViewBinder viewbinder,  , Object obj)
    {
        .eBadge = (AisleBadgeView)viewbinder.overflowAisleBadge((View)viewbinder.w(obj, 0x7f100500, "field 'overflowAisleBadge'"), 0x7f100500, "field 'overflowAisleBadge'");
        .eBadge = (BitmapImageView)viewbinder.imageView((View)viewbinder.w(obj, 0x7f1004fd, "field 'imageView'"), 0x7f1004fd, "field 'imageView'");
        .eBadge = (TextView)viewbinder.title((View)viewbinder.w(obj, 0x7f1004ff, "field 'title'"), 0x7f1004ff, "field 'title'");
        .eBadge = (TextView)viewbinder.subTitle((View)viewbinder.w(obj, 0x7f100501, "field 'subTitle'"), 0x7f100501, "field 'subTitle'");
        .eBadge = (StarRatingView)viewbinder.guestRating((View)viewbinder.w(obj, 0x7f1004fe, "field 'guestRating'"), 0x7f1004fe, "field 'guestRating'");
        .eBadge = (ProductPriceView)viewbinder.priceLayout((View)viewbinder.w(obj, 0x7f100502, "field 'priceLayout'"), 0x7f100502, "field 'priceLayout'");
        .t = (ProductEyebrowView)viewbinder.eyebrowLayout((View)viewbinder.w(obj, 0x7f100504, "field 'eyebrowLayout'"), 0x7f100504, "field 'eyebrowLayout'");
        .ayout = (PlpFulfillmentView)viewbinder.fulfillmentLayout((View)viewbinder.w(obj, 0x7f100503, "field 'fulfillmentLayout'"), 0x7f100503, "field 'fulfillmentLayout'");
        .verflowView = (PlpFulfillmentOverflowView)viewbinder.lowView((View)viewbinder.w(obj, 0x7f100505, "field 'fulfillmentOverflowView'"), 0x7f100505, "field 'fulfillmentOverflowView'");
    }

    public volatile void bind(butterknife.ws..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.eBadge = null;
        bind1.eBadge = null;
        bind1.eBadge = null;
        bind1.eBadge = null;
        bind1.eBadge = null;
        bind1.eBadge = null;
        bind1.t = null;
        bind1.ayout = null;
        bind1.verflowView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
