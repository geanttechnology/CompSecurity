// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.api.display;

import android.view.ViewStub;
import com.amazon.retailsearch.android.api.display.input.SearchEntry;
import com.amazon.retailsearch.android.api.display.results.ResultsDisplay;
import com.amazon.retailsearch.android.ui.search.FragmentBasedResultsDisplay;

public class RetailSearchDisplayComponentProvider
{

    public RetailSearchDisplayComponentProvider()
    {
    }

    public static ResultsDisplay inflateResultsDisplay(ViewStub viewstub)
    {
        FragmentBasedResultsDisplay fragmentbasedresultsdisplay = new FragmentBasedResultsDisplay();
        fragmentbasedresultsdisplay.createDisplay(viewstub.getContext(), viewstub);
        return fragmentbasedresultsdisplay;
    }

    public static SearchEntry inflateSearchEntry(ViewStub viewstub)
    {
        viewstub.setLayoutResource(com.amazon.retailsearch.R.layout.rs_action_bar_query_entry);
        return (SearchEntry)viewstub.inflate();
    }
}
