// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.customviews;

import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import com.poshmark.analytics.Analytics;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.db.DbApi;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.fragments.BrandFragment;
import com.poshmark.ui.fragments.SearchResultsFragment;
import com.poshmark.utils.SearchFilterModel;
import java.util.List;

// Referenced classes of package com.poshmark.ui.customviews:
//            SearchFilterTextView

class this._cls0
    implements android.view.lterTextView._cls1
{

    final SearchFilterTextView this$0;

    public void onClick(View view)
    {
        SearchFilterModel searchfiltermodel;
        Object obj;
        InputMethodManager inputmethodmanager;
        if (screenNameForAnalytics != null)
        {
            if (searchTriggerType.equalsIgnoreCase("br"))
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "brand_link_tapped", null);
            } else
            if (size != null)
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "size_link_tapped", null);
            }
        }
        searchfiltermodel = new SearchFilterModel();
        searchfiltermodel.setSearchTrigger(searchTriggerType);
        searchfiltermodel.setAvailability("available");
        obj = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
        if (obj != null && ((UserStateSummary) (obj)).user_info.isMySizeAvailable())
        {
            searchfiltermodel.enableMySizeFilter(true);
        }
        if (category != null && category.length() > 0)
        {
            searchfiltermodel.setCategory(category);
            searchfiltermodel.setSubCategories(subCategoryList);
            searchfiltermodel.setFacet("brand");
            searchfiltermodel.setFacet("size");
            searchfiltermodel.setFacet("color");
            if (subCategoryList != null && subCategoryList.size() > 0)
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "browse_listings_by_subcategory", null);
            } else
            {
                Analytics.getInstance().trackEvent(screenNameForAnalytics, "listing", "browse_listings_by_category", null);
            }
        }
        if (size != null && size.length() > 0 && category != null && DbApi.getSizeForCategoryFromLabel(category, size) != null)
        {
            searchfiltermodel.getFilters().addSize(size);
        }
        if (brand != null && brand.length() > 0)
        {
            searchfiltermodel.getPrimaryFilters().addBrand(brand);
            searchfiltermodel.setFacet("category_v2");
            searchfiltermodel.setFacet("size");
            searchfiltermodel.setFacet("color");
            searchfiltermodel.setFacet("category_feature");
        }
        if (NWT_condition.booleanValue())
        {
            searchfiltermodel.getFilters().enableNWTOption(true);
        } else
        if (Retail_condition.booleanValue())
        {
            searchfiltermodel.getFilters().enableRetailOption(true);
        }
        obj = (PMContainerActivity)view.getContext();
        inputmethodmanager = (InputMethodManager)((PMContainerActivity) (obj)).getSystemService("input_method");
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
        if (searchTriggerType.equalsIgnoreCase("br"))
        {
            view.putString("ID", brand);
            ((PMContainerActivity) (obj)).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/BrandFragment, null);
            return;
        } else
        {
            view.putString("SEARCH_TRIGGER", searchTriggerType);
            ((PMContainerActivity) (obj)).launchFragmentInNewActivity(view, com/poshmark/ui/fragments/SearchResultsFragment, searchfiltermodel);
            return;
        }
    }

    ()
    {
        this$0 = SearchFilterTextView.this;
        super();
    }
}
