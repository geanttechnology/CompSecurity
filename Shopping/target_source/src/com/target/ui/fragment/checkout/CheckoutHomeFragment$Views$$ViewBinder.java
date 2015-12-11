// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.target.ui.view.checkout.CardSummaryView;
import com.target.ui.view.checkout.CheckoutProductsView;
import com.target.ui.view.checkout.ContactView;
import com.target.ui.view.checkout.CouponWalletItemContainerView;
import com.target.ui.view.checkout.CouponWalletSavedOffersView;
import com.target.ui.view.checkout.DeliveryView;
import com.target.ui.view.checkout.GiftCardContainerView;
import com.target.ui.view.checkout.PaymentView;
import com.target.ui.view.checkout.PromoCodeContainerView;
import com.target.ui.view.checkout.SummaryView;
import com.target.ui.view.common.TargetErrorView;

public class 
    implements butterknife.t.Views..ViewBinder
{

    public void bind(butterknife.t.Views..ViewBinder viewbinder,  , Object obj)
    {
        . = (View)viewbinder.rootView(obj, 0x7f10013e, "field 'rootView'");
        . = (TargetErrorView)viewbinder.errorView((View)viewbinder.errorView(obj, 0x7f100150, "field 'errorView'"), 0x7f100150, "field 'errorView'");
        . = (ScrollView)viewbinder.scrollView((View)viewbinder.scrollView(obj, 0x7f10013f, "field 'scrollView'"), 0x7f10013f, "field 'scrollView'");
        .ainer = (LinearLayout)viewbinder.checkoutContainer((View)viewbinder.checkoutContainer(obj, 0x7f100140, "field 'checkoutContainer'"), 0x7f100140, "field 'checkoutContainer'");
        .uctListView = (CheckoutProductsView)viewbinder.checkoutProductListView((View)viewbinder.checkoutProductListView(obj, 0x7f100141, "field 'checkoutProductListView'"), 0x7f100141, "field 'checkoutProductListView'");
        .uctListView = (TextView)viewbinder.cartNumber((View)viewbinder.cartNumber(obj, 0x7f10014f, "field 'cartNumber'"), 0x7f10014f, "field 'cartNumber'");
        .on = (Button)viewbinder.purchaseButton((View)viewbinder.purchaseButton(obj, 0x7f10014e, "field 'purchaseButton'"), 0x7f10014e, "field 'purchaseButton'");
        .tainer = (PromoCodeContainerView)viewbinder.promoCodeContainer((View)viewbinder.promoCodeContainer(obj, 0x7f100148, "field 'promoCodeContainer'"), 0x7f100148, "field 'promoCodeContainer'");
        .ainerView = (GiftCardContainerView)viewbinder.giftCardContainerView((View)viewbinder.giftCardContainerView(obj, 0x7f100143, "field 'giftCardContainerView'"), 0x7f100143, "field 'giftCardContainerView'");
        .er = (View)viewbinder.giftCardSpacer(obj, 0x7f100144, "field 'giftCardSpacer'");
        .er = (ContactView)viewbinder.contactView((View)viewbinder.contactView(obj, 0x7f100142, "field 'contactView'"), 0x7f100142, "field 'contactView'");
        .r = (View)viewbinder.paymentSpacer(obj, 0x7f100146, "field 'paymentSpacer'");
        .Spacer = (View)viewbinder.couponWalletSpacer(obj, 0x7f10014b, "field 'couponWalletSpacer'");
        .Spacer = (SummaryView)viewbinder.summaryView((View)viewbinder.summaryView(obj, 0x7f10014c, "field 'summaryView'"), 0x7f10014c, "field 'summaryView'");
        .iew = (CardSummaryView)viewbinder.cardSummaryView((View)viewbinder.cardSummaryView(obj, 0x7f10014d, "field 'cardSummaryView'"), 0x7f10014d, "field 'cardSummaryView'");
        . = (DeliveryView)viewbinder.deliveryView((View)viewbinder.deliveryView(obj, 0x7f100147, "field 'deliveryView'"), 0x7f100147, "field 'deliveryView'");
        . = (PaymentView)viewbinder.paymentView((View)viewbinder.paymentView(obj, 0x7f100145, "field 'paymentView'"), 0x7f100145, "field 'paymentView'");
        .SavedOffersView = (CouponWalletSavedOffersView)viewbinder.View((View)viewbinder.View(obj, 0x7f100149, "field 'couponWalletSavedOffersView'"), 0x7f100149, "field 'couponWalletSavedOffersView'");
        .ItemContainerView = (CouponWalletItemContainerView)viewbinder.erView((View)viewbinder.erView(obj, 0x7f10014a, "field 'couponWalletItemContainerView'"), 0x7f10014a, "field 'couponWalletItemContainerView'");
    }

    public volatile void bind(butterknife.t.Views..ViewBinder viewbinder, Object obj, Object obj1)
    {
        bind(viewbinder, (bind)obj, obj1);
    }

    public void unbind(bind bind1)
    {
        bind1.bind = null;
        bind1.bind = null;
        bind1.bind = null;
        bind1.ainer = null;
        bind1.uctListView = null;
        bind1.uctListView = null;
        bind1.on = null;
        bind1.tainer = null;
        bind1.ainerView = null;
        bind1.er = null;
        bind1.er = null;
        bind1.r = null;
        bind1.Spacer = null;
        bind1.Spacer = null;
        bind1.iew = null;
        bind1. = null;
        bind1. = null;
        bind1.SavedOffersView = null;
        bind1.ItemContainerView = null;
    }

    public volatile void unbind(Object obj)
    {
        unbind((unbind)obj);
    }

    public ()
    {
    }
}
