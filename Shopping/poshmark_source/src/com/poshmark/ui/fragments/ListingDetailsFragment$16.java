// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.view.View;
import com.poshmark.analytics.Analytics;

// Referenced classes of package com.poshmark.ui.fragments:
//            ListingDetailsFragment

class this._cls0
    implements android.view.sFragment._cls16
{

    final ListingDetailsFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "add_listing_to_bundle_cell_tapped", null);
        addListingToBundle();
    }

    _cls9()
    {
        this$0 = ListingDetailsFragment.this;
        super();
    }
}
