// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.mvc.view;

import android.view.View;
import android.widget.TextView;
import com.groupon.goods.shoppingcart.view.ShoppingCartIconView;
import com.groupon.view.SpinnerButton;

// Referenced classes of package com.groupon.mvc.view:
//            DealDetailsBottomBarView

public class 
    implements butterknife.ewBinder
{

    public void bind(butterknife.ewBinder ewbinder, DealDetailsBottomBarView dealdetailsbottombarview, Object obj)
    {
        dealdetailsbottombarview.shoppingCartButton = (ShoppingCartIconView)ewbinder.conView((View)ewbinder.conView(obj, 0x7f10023a, "field 'shoppingCartButton'"), 0x7f10023a, "field 'shoppingCartButton'");
        dealdetailsbottombarview.bottomBarLeftContainer = (View)ewbinder.tomBarLeftContainer(obj, 0x7f10023b, "field 'bottomBarLeftContainer'");
        dealdetailsbottombarview.timeLeftContainer = (View)ewbinder.eLeftContainer(obj, 0x7f10023c, "field 'timeLeftContainer'");
        dealdetailsbottombarview.timeLeftUrgencyPricingLabelView = (TextView)ewbinder.eLeftUrgencyPricingLabelView((View)ewbinder.eLeftUrgencyPricingLabelView(obj, 0x7f10023d, "field 'timeLeftUrgencyPricingLabelView'"), 0x7f10023d, "field 'timeLeftUrgencyPricingLabelView'");
        dealdetailsbottombarview.timeLeftLabelView = (TextView)ewbinder.eLeftLabelView((View)ewbinder.eLeftLabelView(obj, 0x7f10023f, "field 'timeLeftLabelView'"), 0x7f10023f, "field 'timeLeftLabelView'");
        dealdetailsbottombarview.timeLeftView = (TextView)ewbinder.eLeftView((View)ewbinder.eLeftView(obj, 0x7f10023e, "field 'timeLeftView'"), 0x7f10023e, "field 'timeLeftView'");
        dealdetailsbottombarview.buyButton = (SpinnerButton)ewbinder.Button((View)ewbinder.Button(obj, 0x7f100243, "field 'buyButton'"), 0x7f100243, "field 'buyButton'");
        dealdetailsbottombarview.buyButtonOverlayText = (TextView)ewbinder.ButtonOverlayText((View)ewbinder.ButtonOverlayText(obj, 0x7f100244, "field 'buyButtonOverlayText'"), 0x7f100244, "field 'buyButtonOverlayText'");
        dealdetailsbottombarview.freeShippingBand = (View)ewbinder.eShippingBand(obj, 0x7f100245, "field 'freeShippingBand'");
    }

    public volatile void bind(butterknife.ewBinder ewbinder, Object obj, Object obj1)
    {
        bind(ewbinder, (DealDetailsBottomBarView)obj, obj1);
    }

    public void unbind(DealDetailsBottomBarView dealdetailsbottombarview)
    {
        dealdetailsbottombarview.shoppingCartButton = null;
        dealdetailsbottombarview.bottomBarLeftContainer = null;
        dealdetailsbottombarview.timeLeftContainer = null;
        dealdetailsbottombarview.timeLeftUrgencyPricingLabelView = null;
        dealdetailsbottombarview.timeLeftLabelView = null;
        dealdetailsbottombarview.timeLeftView = null;
        dealdetailsbottombarview.buyButton = null;
        dealdetailsbottombarview.buyButtonOverlayText = null;
        dealdetailsbottombarview.freeShippingBand = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((DealDetailsBottomBarView)obj);
    }

    public ()
    {
    }
}
