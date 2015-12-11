// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.ListingDetails;
import com.poshmark.ui.PMActivity;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment, MappPageFragment

class this._cls0
    implements android.view.sFragment._cls20
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "listing", "buyer_view_offer_link_tapped", listingDetails.getIdAsString());
        view = listingDetails.getOffersUrl();
        if (view != null)
        {
            Bundle bundle = new Bundle();
            bundle.putString("URL", (new StringBuilder()).append("https://www.poshmark.com/mapp/").append(view).toString());
            bundle.putString("ANALYTICS_PAGE_NAME", "Offers");
            ((PMActivity)getActivity()).launchFragmentInNewActivity(bundle, com/poshmark/ui/fragments/MappPageFragment, null);
        }
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
