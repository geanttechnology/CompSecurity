// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.data_model.models.PMBundle;
import com.poshmark.ui.PMActivity;
import java.util.UUID;

// Referenced classes of package com.poshmark.ui.fragments:
//            ViewBundleFragment, UnavailableBundleItemsFragment

class this._cls0
    implements android.view.leFragment._cls1
{

    final ViewBundleFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "bundle", "view_unavailable_listings_in_bundle_tapped", null);
        view = new Bundle();
        view.putString("NAME", userName);
        view.putString("PARENT_ID", getFragmentId().toString());
        view.putString("SELLER_USER_NAME", bundleData.getSellerUsername());
        getParentActivity().launchFragmentForResult(view, com/poshmark/ui/fragments/UnavailableBundleItemsFragment, unavailableBundleData, ViewBundleFragment.this, VIEW_UNAVAILABLE_ITEMS);
    }

    sFragment()
    {
        this$0 = ViewBundleFragment.this;
        super();
    }
}
