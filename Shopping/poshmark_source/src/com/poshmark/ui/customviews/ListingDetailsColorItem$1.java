// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.PMColor;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.SearchResultsFragment;
import com.poshmark.utils.SearchFilterModel;

// Referenced classes of package com.poshmark.ui.customviews:
//            ListingDetailsColorItem

class this._cls0
    implements android.view.ilsColorItem._cls1
{

    final ListingDetailsColorItem this$0;

    public void onClick(View view)
    {
        Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "browse_listings_by_color", null);
        SearchFilterModel searchfiltermodel = new SearchFilterModel();
        searchfiltermodel.setSearchTrigger(searchTriggerType);
        searchfiltermodel.setAvailability("available");
        Object obj = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (obj != null && ((UserStateSummary) (obj)).user_info.isMySizeAvailable())
        {
            searchfiltermodel.enableMySizeFilter(true);
        }
        if (category != null && category.length() > 0)
        {
            searchfiltermodel.setCategory(category);
            searchfiltermodel.addColor(color.name);
            searchfiltermodel.setFacet("brand");
            searchfiltermodel.setFacet("size");
            searchfiltermodel.setFacet("category_v2");
            searchfiltermodel.setFacet("category_feature");
        }
        obj = (PMContainerActivity)view.getContext();
        InputMethodManager inputmethodmanager = (InputMethodManager)((PMContainerActivity) (obj)).getSystemService("input_method");
        if (inputmethodmanager.isAcceptingText())
        {
            if (((PMContainerActivity) (obj)).getCurrentFocus() != null)
            {
                inputmethodmanager.hideSoftInputFromWindow(view.getWindowToken(), 0);
            } else
            {
                inputmethodmanager.toggleSoftInput(1, 0);
            }
        }
        view = new Bundle();
        view.putString("SEARCH_TRIGGER", searchTriggerType);
        ((PMContainerActivity) (obj)).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
    }

    fo()
    {
        this$0 = ListingDetailsColorItem.this;
        super();
    }
}
