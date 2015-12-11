// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.utils.FBDPAHelper;
import com.poshmark.utils.OfferFlowHandler;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements android.view.sFragment._cls21
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        FBDPAHelper.trackAddToCart(listingDetails, FBDPAHelper.PURCHASE_TYPE_OFFER);
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buyer_make_offer_link_tapped", listingDetails.getIdAsString());
        (new OfferFlowHandler(ListingDetailsFragment.this)).beginCheckoutForListing(listingDetails);
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
