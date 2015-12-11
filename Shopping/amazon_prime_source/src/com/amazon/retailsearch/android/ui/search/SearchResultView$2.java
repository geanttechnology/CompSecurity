// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.amazon.retailsearch.android.ui.search;

import com.amazon.retailsearch.android.ui.resultheader.ResultsInfoBar;
import com.amazon.retailsearch.android.ui.results.layout.FilterRequestListener;

// Referenced classes of package com.amazon.retailsearch.android.ui.search:
//            SearchResultView

class this._cls0
    implements FilterRequestListener
{

    final SearchResultView this$0;

    public void onFilterApplied(String s, boolean flag)
    {
        SearchResultView.access$100(SearchResultView.this).openFilter(s, flag);
    }

    r()
    {
        this$0 = SearchResultView.this;
        super();
    }
}
