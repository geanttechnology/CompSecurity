// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import android.view.View;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.ui.PMActivity;
import com.poshmark.utils.meta_data.MetaItemPickerInfo;

// Referenced classes of package com.poshmark.ui.fragments:
//            SuggestedBrandsPickerFragment, MetaItemListViewFragment

class this._cls0
    implements android.view.erFragment._cls4
{

    final SuggestedBrandsPickerFragment this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(viewNameForAnalytics, "brand", "view_more_brands_onramp", null);
        view = new MetaItemPickerInfo();
        view.allItems = GlobalDbController.getGlobalDbController().getAllBrands();
        Bundle bundle = new Bundle();
        bundle.putInt("META_ITEM_MODE", EM_MODES.BRAND_MODE.ordinal());
        bundle.putBoolean("SEARCH_ENABLED", true);
        bundle.putBoolean("BRAND_FOLLOW_BUTTON", true);
        PMActivity pmactivity = (PMActivity)getActivity();
        if (pmactivity != null && pmactivity.isActivityInForeground())
        {
            pmactivity.launchFragment(bundle, com/poshmark/ui/fragments/MetaItemListViewFragment, view);
        }
    }

    EM_MODES()
    {
        this$0 = SuggestedBrandsPickerFragment.this;
        super();
    }
}
