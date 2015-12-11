// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.api;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.amazon.retailsearch.android.api.display.results.ResultsInfoBarWidgetType;
import com.amazon.retailsearch.android.api.query.RetailSearchQuery;
import com.amazon.retailsearch.android.ui.results.ResultsDisplay;
import com.amazon.retailsearch.android.ui.search.SearchResultView;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;

public class RetailSearchPage extends ResultsDisplay
{

    SearchDataSource dataSource;
    private SearchResultView searchResultView;

    public RetailSearchPage()
    {
    }

    public void onCreate(Bundle bundle)
    {
        super.onCreate(bundle);
        RetailSearchDaggerGraphController.inject(this);
    }

    public View onCreateView(LayoutInflater layoutinflater, ViewGroup viewgroup, Bundle bundle)
    {
        layoutinflater = (ViewGroup)layoutinflater.inflate(com.amazon.retailsearch.R.layout.search_page_root, viewgroup, false);
        searchResultView = (SearchResultView)layoutinflater.findViewById(com.amazon.retailsearch.R.id.rs_search_result_view);
        if (searchResultView != null)
        {
            searchResultView.linkExternalWidgetsManager(externalWidgetsManager);
        }
        return layoutinflater;
    }

    public void onPause()
    {
        super.onPause();
        if (searchResultView != null)
        {
            searchResultView.onPause();
        }
    }

    public void onResume()
    {
        super.onResume();
        if (searchResultView != null)
        {
            searchResultView.onResume();
        }
    }

    public void onStart()
    {
        super.onStart();
        if (searchResultView != null)
        {
            searchResultView.onStart();
        }
    }

    public void onStop()
    {
        super.onStop();
        if (searchResultView != null)
        {
            searchResultView.onStop();
        }
    }

    public void search(RetailSearchQuery retailsearchquery)
    {
        dataSource.submitQuery(retailsearchquery);
        dataSource.stageLastQuery();
    }

    public void setResultsInfoBarWidgetType(ResultsInfoBarWidgetType resultsinfobarwidgettype, View view)
    {
        if (searchResultView != null)
        {
            searchResultView.setResultsInfoBarWidgetType(resultsinfobarwidgettype, view);
        }
    }
}
