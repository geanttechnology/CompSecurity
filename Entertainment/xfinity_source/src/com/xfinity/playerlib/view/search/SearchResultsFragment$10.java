// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.xfinity.playerlib.model.tags.OrderedTag;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

class BreadcrumbClickListener extends BreadcrumbClickListener
{

    final SearchResultsFragment this$0;
    final OrderedTag val$genreFilter;
    final Set val$genreFilters;

    protected void onBreadcrumbClicked()
    {
        val$genreFilters.remove(val$genreFilter);
    }

    BreadcrumbClickListener()
    {
        this$0 = final_searchresultsfragment;
        val$genreFilters = set;
        val$genreFilter = OrderedTag.this;
        super(final_searchresultsfragment, null);
    }
}
