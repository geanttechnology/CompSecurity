// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.view.weekly_ad;

import android.view.View;
import android.widget.TextView;
import com.target.ui.view.BitmapImageView;
import com.target.ui.view.product.PlpFulfillmentView;
import com.target.ui.view.product.ProductEyebrowView;
import com.target.ui.view.product.ProductPriceView;

public class I
    implements butterknife.iews..ViewBinder
{

    public void bind(butterknife.iews..ViewBinder viewbinder, I i, Object obj)
    {
        i.View = (BitmapImageView)viewbinder.productImageView((View)viewbinder.productImageView(obj, 0x7f1004fd, "field 'productImageView'"), 0x7f1004fd, "field 'productImageView'");
        i.View = (TextView)viewbinder.title((View)viewbinder.title(obj, 0x7f1004ff, "field 'title'"), 0x7f1004ff, "field 'title'");
        i.View = (ProductPriceView)viewbinder.priceLayout((View)viewbinder.priceLayout(obj, 0x7f100502, "field 'priceLayout'"), 0x7f100502, "field 'priceLayout'");
        i.ayout = (PlpFulfillmentView)viewbinder.fulfillmentLayout((View)viewbinder.fulfillmentLayout(obj, 0x7f100503, "field 'fulfillmentLayout'"), 0x7f100503, "field 'fulfillmentLayout'");
        i.t = (ProductEyebrowView)viewbinder.eyebrowLayout((View)viewbinder.eyebrowLayout(obj, 0x7f100504, "field 'eyebrowLayout'"), 0x7f100504, "field 'eyebrowLayout'");
    }

    public volatile void bind(butterknife.iews..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.View = null;
        bind1.View = null;
        bind1.View = null;
        bind1.ayout = null;
        bind1.t = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public I()
    {
    }
}
