// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: braces fieldsfirst space lnc 

package com.xfinity.playerlib.view.search;

import com.xfinity.playerlib.model.tags.Network;
import java.util.Set;

// Referenced classes of package com.xfinity.playerlib.view.search:
//            SearchResultsFragment

class gBreadcrumbClickListener extends gBreadcrumbClickListener
{

    final SearchResultsFragment this$0;
    final Network val$networkFilter;
    final Set val$networkFilters;

    protected void onBreadcrumbClicked()
    {
        val$networkFilters.remove(val$networkFilter);
    }

    gBreadcrumbClickListener()
    {
        this$0 = final_searchresultsfragment;
        val$networkFilters = set;
        val$networkFilter = Network.this;
        super(final_searchresultsfragment, null);
    }
}
