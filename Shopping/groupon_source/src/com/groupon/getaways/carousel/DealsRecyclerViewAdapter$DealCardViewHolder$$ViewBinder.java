// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.getaways.carousel;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.groupon.view.UrlImageView;

public class 
    implements butterknife.older..ViewBinder
{

    public void bind(butterknife.older..ViewBinder viewbinder,  , Object obj)
    {
        .w = (UrlImageView)viewbinder.dealImageView((View)viewbinder.dealImageView(obj, 0x7f100121, "field 'dealImageView'"), 0x7f100121, "field 'dealImageView'");
        .w = (TextView)viewbinder.titleView((View)viewbinder.titleView(obj, 0x7f10007a, "field 'titleView'"), 0x7f10007a, "field 'titleView'");
        .w = (TextView)viewbinder.priceTextView((View)viewbinder.priceTextView(obj, 0x7f10021f, "field 'priceTextView'"), 0x7f10021f, "field 'priceTextView'");
        .ceTextView = (TextView)viewbinder.referencePriceTextView((View)viewbinder.referencePriceTextView(obj, 0x7f10021e, "field 'referencePriceTextView'"), 0x7f10021e, "field 'referencePriceTextView'");
        .er = (FrameLayout)viewbinder.priceContainer((View)viewbinder.priceContainer(obj, 0x7f100225, "field 'priceContainer'"), 0x7f100225, "field 'priceContainer'");
        .View = (TextView)viewbinder.locationTextView((View)viewbinder.locationTextView(obj, 0x7f100226, "field 'locationTextView'"), 0x7f100226, "field 'locationTextView'");
        .iew = (TextView)viewbinder.dealsBoughtView((View)viewbinder.dealsBoughtView(obj, 0x7f100227, "field 'dealsBoughtView'"), 0x7f100227, "field 'dealsBoughtView'");
        .iew = (TextView)viewbinder.mobileOnly((View)viewbinder.mobileOnly(obj, 0x7f100220, "field 'mobileOnly'"), 0x7f100220, "field 'mobileOnly'");
        .ngLabel = (TextView)viewbinder.urgencyPricingLabel((View)viewbinder.urgencyPricingLabel(obj, 0x7f100193, "field 'urgencyPricingLabel'"), 0x7f100193, "field 'urgencyPricingLabel'");
        .eTitle = (TextView)viewbinder.dealIncentiveTitle((View)viewbinder.dealIncentiveTitle(obj, 0x7f10022a, "field 'dealIncentiveTitle'"), 0x7f10022a, "field 'dealIncentiveTitle'");
        .ew = (TextView)viewbinder.gbucksTextView((View)viewbinder.gbucksTextView(obj, 0x7f100229, "field 'gbucksTextView'"), 0x7f100229, "field 'gbucksTextView'");
        .edMarketPlace = (TextView)viewbinder.goodsConnectedMarketPlace((View)viewbinder.goodsConnectedMarketPlace(obj, 0x7f100228, "field 'goodsConnectedMarketPlace'"), 0x7f100228, "field 'goodsConnectedMarketPlace'");
        .nnerContainer = (View)viewbinder.newSoldOutBannerContainer(obj, 0x7f100230, "field 'newSoldOutBannerContainer'");
        .nnerText = (TextView)viewbinder.newSoldOutBannerText((View)viewbinder.newSoldOutBannerText(obj, 0x7f100231, "field 'newSoldOutBannerText'"), 0x7f100231, "field 'newSoldOutBannerText'");
        .ner = (LinearLayout)viewbinder.badgesContainer((View)viewbinder.badgesContainer(obj, 0x7f100223, "field 'badgesContainer'"), 0x7f100223, "field 'badgesContainer'");
        .ew = (TextView)viewbinder.badgesTextView((View)viewbinder.badgesTextView(obj, 0x7f100224, "field 'badgesTextView'"), 0x7f100224, "field 'badgesTextView'");
        .ble = viewbinder.soldOutDrawable(obj).getResources().getDrawable(0x7f02014c);
    }

    public volatile void bind(butterknife.older..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.w = null;
        bind1.w = null;
        bind1.w = null;
        bind1.ceTextView = null;
        bind1.er = null;
        bind1.View = null;
        bind1.iew = null;
        bind1.iew = null;
        bind1.ngLabel = null;
        bind1.eTitle = null;
        bind1.ew = null;
        bind1.edMarketPlace = null;
        bind1.nnerContainer = null;
        bind1.nnerText = null;
        bind1.ner = null;
        bind1.ew = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
