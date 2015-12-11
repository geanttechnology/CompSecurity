// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.target.ui.fragment.checkout;

import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import com.target.ui.view.a;
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

// Referenced classes of package com.target.ui.fragment.checkout:
//            CheckoutHomeFragment

static class  extends a
{

    CardSummaryView cardSummaryView;
    TextView cartNumber;
    LinearLayout checkoutContainer;
    CheckoutProductsView checkoutProductListView;
    ContactView contactView;
    CouponWalletItemContainerView couponWalletItemContainerView;
    CouponWalletSavedOffersView couponWalletSavedOffersView;
    View couponWalletSpacer;
    DeliveryView deliveryView;
    TargetErrorView errorView;
    GiftCardContainerView giftCardContainerView;
    View giftCardSpacer;
    View paymentSpacer;
    PaymentView paymentView;
    PromoCodeContainerView promoCodeContainer;
    Button purchaseButton;
    View rootView;
    ScrollView scrollView;
    SummaryView summaryView;

    (View view)
    {
        super(view);
    }
}
