// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.os.Bundle;
import com.poshmark.controllers.GlobalDbController;
import com.poshmark.controllers.UserStateSummaryController;
import com.poshmark.data_model.models.MetaItem;
import com.poshmark.data_model.models.UserStateSummary;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.utils.SearchFilterModel;
import com.poshmark.utils.StringUtils;

// Referenced classes of package com.poshmark.ui.fragments:
//            MetaItemListViewFragment, SearchResultsFragment

public class CategoryMetaItemListViewFragment extends MetaItemListViewFragment
{

    boolean returnResults;

    public CategoryMetaItemListViewFragment()
    {
        returnResults = false;
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        if (bundle == null)
        {
            returnResults = getArguments().getBoolean("RETURN_RESULT", false);
        }
    }

    public void returnData()
    {
        if (!returnResults)
        {
            Object obj = StringUtils.toJson(metaItem, com/poshmark/data_model/models/MetaItem);
            if (obj != null)
            {
                Object obj1 = (MetaItem)StringUtils.fromJson(((String) (obj)), com/poshmark/data_model/models/MetaItem);
                obj = new SearchFilterModel();
                ((SearchFilterModel) (obj)).setAvailability("available");
                GlobalDbController.getGlobalDbController().getAllSizesForCategory(((MetaItem) (obj1)).getId());
                UserStateSummary userstatesummary = UserStateSummaryController.getGlobalInteractionsController().getUserStateSummary();
                if (userstatesummary != null && userstatesummary.user_info.isMySizeAvailable())
                {
                    ((SearchFilterModel) (obj)).enableMySizeFilter(true);
                }
                ((SearchFilterModel) (obj)).setSearchTrigger("ct");
                ((SearchFilterModel) (obj)).setCategory(((MetaItem) (obj1)).getId());
                ((SearchFilterModel) (obj)).setFacet("brand");
                ((SearchFilterModel) (obj)).setFacet("size");
                obj1 = new Bundle();
                ((Bundle) (obj1)).putString("SEARCH_TRIGGER", "ct");
                ((PMContainerActivity)getActivity()).launchFragmentInNewActivity(((Bundle) (obj1)), com/poshmark/ui/fragments/SearchResultsFragment, obj);
            }
            return;
        } else
        {
            super.returnData();
            return;
        }
    }
}
