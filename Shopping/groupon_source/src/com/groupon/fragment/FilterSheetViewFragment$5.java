// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.groupon.fragment;

import com.groupon.adapter.OnFilterSheetItemClickListener;
import com.groupon.models.search.data.Facet;
import com.groupon.models.search.data.FacetValue;
import com.groupon.models.search.domain.FilterSheetPresenter;
import com.groupon.models.search.domain.SortMethodWrapper;

// Referenced classes of package com.groupon.fragment:
//            FilterSheetViewFragment

class this._cls0
    implements OnFilterSheetItemClickListener
{

    final FilterSheetViewFragment this$0;

    public void onFacetValueSelected(Facet facet, FacetValue facetvalue, boolean flag)
    {
        FilterSheetViewFragment.access$200(FilterSheetViewFragment.this).facetValueSelectionChanged(FilterSheetViewFragment.access$100(FilterSheetViewFragment.this), channel, searchTerm, facet, facetvalue, flag);
    }

    public void onSortMethodSelected(SortMethodWrapper sortmethodwrapper)
    {
        FilterSheetViewFragment.access$200(FilterSheetViewFragment.this).sortValueSelected(FilterSheetViewFragment.access$100(FilterSheetViewFragment.this), channel, searchTerm, sortmethodwrapper);
    }

    per()
    {
        this$0 = FilterSheetViewFragment.this;
        super();
    }
}
