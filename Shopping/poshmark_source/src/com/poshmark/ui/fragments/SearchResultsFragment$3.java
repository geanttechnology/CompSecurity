// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.poshmark.ui.fragments;

import com.poshmark.http.api.PMApiResponse;
import com.poshmark.http.api.PMApiResponseHandler;
import com.poshmark.ui.customviews.ListingsFilterWidget;

// Referenced classes of package com.poshmark.ui.fragments:
//            SearchResultsFragment

class this._cls0
    implements PMApiResponseHandler
{

    final SearchResultsFragment this$0;

    public void handleResponse(PMApiResponse pmapiresponse)
    {
        if (isAdded())
        {
            SearchResultsFragment.access$100(SearchResultsFragment.this, pmapiresponse, false);
            hideFilterButtonsForSingleFacet();
            filterWidget.setVisibility(0);
        }
    }

    ()
    {
        this$0 = SearchResultsFragment.this;
        super();
    }
}
