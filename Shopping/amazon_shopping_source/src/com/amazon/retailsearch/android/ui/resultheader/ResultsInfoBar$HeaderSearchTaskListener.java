// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.resultheader;

import com.amazon.searchapp.retailsearch.model.Breadcrumb;
import com.amazon.searchapp.retailsearch.model.Refinements;
import com.amazon.searchapp.retailsearch.model.ResultsMetadata;
import com.amazon.searchapp.retailsearch.model.Sort;
import com.amazon.searchapp.retailsearch.model.TrackingInfo;

// Referenced classes of package com.amazon.retailsearch.android.ui.resultheader:
//            ResultsInfoBar

private class <init> extends com.amazon.retailsearch.data.SearchTaskListener
{

    final ResultsInfoBar this$0;

    public void breadcrumb(Breadcrumb breadcrumb1)
    {
        setBreadcrumb(breadcrumb1);
    }

    public void refinements(Refinements refinements1)
    {
        setRefinements(refinements1);
    }

    public void resultMetadata(ResultsMetadata resultsmetadata)
    {
        if (resultsmetadata != null && !ResultsInfoBar.access$500(ResultsInfoBar.this))
        {
            setCountAndLabel(resultsmetadata.getTotalResults(), resultsmetadata.getResultsLabel());
            ResultsInfoBar.access$502(ResultsInfoBar.this, true);
        }
    }

    public void sort(Sort sort1)
    {
        setSort(sort1);
    }

    public void startResult()
    {
        clearAll();
    }

    public void trackingInfo(TrackingInfo trackinginfo)
    {
        setDepartment(trackinginfo.getSearchAliasDisplayName());
    }

    private ()
    {
        this$0 = ResultsInfoBar.this;
        super();
    }

    this._cls0(this._cls0 _pcls0)
    {
        this();
    }
}
