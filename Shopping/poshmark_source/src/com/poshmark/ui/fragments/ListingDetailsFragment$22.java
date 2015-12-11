// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.utils.CheckoutFlowHandler;
import com.poshmark.utils.FBDPAHelper;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements android.view.sFragment._cls22
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buy_button_clicked", null);
        FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_SINGLE_LISTING);
        FBDPAHelper.trackListingPurchaseInitiated(listingDetails, FBDPAHelper.PURCHASE_TYPE_SINGLE_LISTING);
        (new CheckoutFlowHandler(ListingDetailsFragment.this)).beginCheckoutForListing(listingDetails);
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
