// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import android.content.res.Resources;
import android.os.Bundle;
import com.poshmark.config.NewRelicWrapper;
import com.poshmark.ui.PMContainerActivity;
import com.poshmark.ui.customviews.PMCustomSearchWidget;
import com.poshmark.utils.FilterResultsManager;
import com.poshmark.utils.NewRelicCustomInteractions;
import com.poshmark.utils.PMSearchViewListener;
import com.poshmark.utils.SearchFilterModel;

// Referenced classes of package com.poshmark.ui.fragments:
//            SearchResultsFragment, BrandFragment

class this._cls0
    implements PMSearchViewListener
{

    final SearchResultsFragment this$0;

    public void clearSearchString()
    {
    }

    public void fireKeywordSearch(Bundle bundle, SearchFilterModel searchfiltermodel, boolean flag)
    {
        if (flag)
        {
            ((PMContainerActivity)getActivity()).launchFragment(bundle, com/poshmark/ui/fragments/BrandFragment, searchfiltermodel);
            return;
        }
        searchTrigger = bundle.getString("SEARCH_TRIGGER");
        if (searchTrigger != null && searchTrigger.equals("sl"))
        {
            keywordSource = bundle.getString("KEYWORD_SOURCE");
            NewRelicWrapper.startCustomInteraction(NewRelicCustomInteractions.SEARCH_LISTINGS_BY_KEYWORD);
        }
        getFilterManager().setSearchModel(searchfiltermodel);
        searchView.setSilentText(getFilterModel().getQueryText());
        showProgressDialogWithMessage(getResources().getString(0x7f060190));
        SearchResultsFragment.access$000(SearchResultsFragment.this, false);
    }

    ()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }
}
