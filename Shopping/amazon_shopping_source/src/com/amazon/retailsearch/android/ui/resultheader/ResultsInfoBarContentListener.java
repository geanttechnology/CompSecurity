// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.retailsearch.android.api.log.RetailSearchLogger;
import com.amazon.retailsearch.android.api.log.RetailSearchLoggingProvider;
import com.amazon.retailsearch.android.ui.results.ViewType;
import com.amazon.retailsearch.di.RetailSearchDaggerGraphController;
import com.amazon.retailsearch.interaction.SearchDataSource;
import com.amazon.searchapp.retailsearch.model.Refinements;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            IHeaderContentListener

public class ResultsInfoBarContentListener
    implements IHeaderContentListener
{

    private RetailSearchLogger retailSearchLogger;
    SearchDataSource searchDataSource;

    public ResultsInfoBarContentListener()
    {
        retailSearchLogger = RetailSearchLoggingProvider.getInstance().getRetailSearchLogger();
        RetailSearchDaggerGraphController.inject(this);
    }

    public void OnClearAllClick()
    {
        searchDataSource.submitStagedQuery();
        retailSearchLogger.filterMenuSearch();
    }

    public void onDepartmentLabelUpdated()
    {
    }

    public void onFilterCountUpdated()
    {
    }

    public void onHide()
    {
    }

    public void onRefinementClick(String s)
    {
        searchDataSource.submitQuery(s);
        retailSearchLogger.filterMenuSearch();
    }

    public void onResultCountUpdated()
    {
    }

    public void onUpdate(Refinements refinements)
    {
    }

    public void onViewSizeChanged()
    {
    }

    public void onViewTypeUpdated(ViewType viewtype)
    {
    }
}
